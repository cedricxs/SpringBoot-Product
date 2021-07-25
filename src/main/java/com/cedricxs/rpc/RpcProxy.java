package com.cedricxs.rpc;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
@Component
public class RpcProxy implements InvocationHandler {

    @Resource
    private RpcClient rpcClient;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            System.out.println("start create rpc request");
            Class<?> clazz = proxy.getClass().getInterfaces()[0];
            RpcRequest rpcRequest = new RpcRequest();
            rpcRequest.setRequestParams(args);
            RpcContext rpcContext = new RpcContext();
            rpcContext.setClazz(clazz.getName());
            rpcContext.setMethod(method.getName());
            rpcRequest.setRpcContext(rpcContext);
            int len = Objects.isNull(args) ? 0 : args.length;
            Class<?>[] paramsType = new Class<?>[len];
            for (int i = 0; i < len; i++) {
                paramsType[i] = args[i].getClass();
            }
            rpcRequest.setRequestParamsType(paramsType);
            Class<?> responseClazz = method.getReturnType();
            System.out.println("start send rpc request");
            RpcResponse rpcResponse = rpcClient.request(rpcRequest);
            return cast(responseClazz, rpcResponse);
        } catch (Throwable e) {
            e.printStackTrace();
            throw e;
        }
    }

    private <T> T cast(Class<T> responseClazz, RpcResponse rpcResponse) {
        return (T)rpcResponse.getResponseBody();
    }
}
