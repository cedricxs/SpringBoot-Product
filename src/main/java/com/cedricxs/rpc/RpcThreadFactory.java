package com.cedricxs.rpc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadFactory;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
@Slf4j
public class RpcThreadFactory implements ThreadFactory {

    private static int rpcThreadNum;

    @Override
    public Thread newThread(Runnable r) {
        String threadName = "rpc-thread-" + ++rpcThreadNum;
        log.debug("create new rpc thread " + threadName);
        return new Thread(r, threadName);
    }
}
