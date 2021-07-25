package com.cedricxs.rpc;

import com.alibaba.fastjson.JSON;
import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 * 压测结果 100qps -> 响应延迟300ms
 *         1000qps -> 响应延迟5000ms
 *         10000qps -> 响应延迟50000ms, 成功率下跌
 */
@Slf4j
@Component
public class RpcServer implements ApplicationContextAware, InitializingBean {

    private ApplicationContext applicationContext;

    private Executor executor;

    @Value("${rpc.server:99}")
    private Integer port;

    @Value("${rpc.server.corePoreSize:5}")
    private Integer corePoolSize;

    @Value("${rpc.server.maximumPoolSize:20}")
    private Integer maximumPoolSize;

    @Value("${rpc.server.keepAliveTime:1000}")
    private Long keepAliveTime;

    @Value("${rpc.server.workqueueSize:1024}")
    private Integer workqueueSize;

    public void run() throws IOException {
        ServerSocket serverSocket = new ServerSocket(this.port);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                this.executor.execute(() -> {
                    try {
                        this.accept(socket);
                    } catch (IOException e) {
                        e.printStackTrace();
                        log.error("error when io rpc", e);
                    }
                });
            } catch (IOException e) {
                log.error("error when socket connection", e);
            }
        }
    }

    public void accept(Socket socket) throws IOException {
        Hessian2Input input = new Hessian2Input(socket.getInputStream());
        Hessian2Output output = new Hessian2Output(socket.getOutputStream());
        RpcRequest rpcRequest = (RpcRequest) input.readObject();
        log.debug("read rpc request={}", JSON.toJSONString(rpcRequest));
        try {
            RpcResponse response = this.response(rpcRequest);
            output.writeObject(response);
            output.flushBuffer();
            log.debug("send rpc response={}", JSON.toJSONString(response));
        } catch (RpcException e) {
            RpcResponse response = new RpcResponse();
            response.setRpcContext(rpcRequest.getRpcContext());
            response.setStatus(500);
            output.writeObject(response);
            output.flushBuffer();
            log.debug("send rpc error response={}", JSON.toJSONString(response));
        }
    }

    public RpcResponse response(RpcRequest rpcRequest) throws RpcException {
        try {
            RpcContext rpcContext = rpcRequest.getRpcContext();
            Class<?> clazz = Class.forName(rpcContext.getClazz());
            Object bean = this.applicationContext.getBean(clazz);
            String method = rpcContext.getMethod();
            Method targetMethod = clazz.getDeclaredMethod(method, rpcRequest.getRequestParamsType());
            Object res = targetMethod.invoke(bean, rpcRequest.getRequestParams());
            RpcResponse response = new RpcResponse();
            response.setRpcContext(rpcContext);
            response.setResponseBody(res);
            response.setStatus(200);
            return response;
        } catch (Throwable e) {
            throw new RpcException();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() {
        log.debug("start rpc server");
        this.executor = new RpcThreadPool(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(128), new RpcThreadFactory());
        new Thread(() -> {
            try {
                this.run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        log.debug("start rpc server successfully");
    }
}
