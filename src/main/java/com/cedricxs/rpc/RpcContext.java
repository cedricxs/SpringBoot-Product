package com.cedricxs.rpc;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
@Data
public class RpcContext implements Serializable {
    private String clazz;
    private String method;
}
