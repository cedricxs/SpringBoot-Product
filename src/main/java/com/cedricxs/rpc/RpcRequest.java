package com.cedricxs.rpc;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RpcRequest extends RpcData {
    private Class<?>[] requestParamsType;
    private Object[] requestParams;
}
