package com.cedricxs.rpc;

import lombok.Data;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
@Data
public class RpcResponse extends RpcData {
    private Integer status;
    private Object responseBody;
}
