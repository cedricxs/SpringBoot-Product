package com.cedricxs.rpc;

import com.alibaba.fastjson.JSON;
import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.Socket;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
@Component
public class RpcClient {

    @Value("${rpc.client:127.0.0.1}")
    private String address;

    @Value("${rpc.port:99}")
    private Integer port;

    public RpcResponse request(RpcRequest rpcRequest) throws IOException {
        System.out.println("rpcRequest:" + JSON.toJSONString(rpcRequest));
        Socket socket = new Socket(this.address, this.port);
        this.sendRpcRequest(socket, rpcRequest);
        RpcResponse rpcResponse = this.receiveRpcResponse(socket);
        System.out.println("rpcResponse:" + JSON.toJSONString(rpcResponse));
        return rpcResponse;
    }

    private void sendRpcRequest(Socket socket, RpcRequest rpcRequest) throws IOException {
        Hessian2Output output = new Hessian2Output(socket.getOutputStream());
        output.writeObject(rpcRequest);
        output.flushBuffer();
    }

    private RpcResponse receiveRpcResponse(Socket socket) throws IOException {
        Hessian2Input input = new Hessian2Input(socket.getInputStream());
        RpcResponse rpcResponse = (RpcResponse)input.readObject();
        return rpcResponse;
    }
}
