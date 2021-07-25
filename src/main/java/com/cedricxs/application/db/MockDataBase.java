package com.cedricxs.application.db;

import java.util.List;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
public interface MockDataBase {
    /**
     * @param tableName
     * @param key
     * @param value
     * @return
     */
    boolean set(String tableName, String key, String value);

    /**
     * @param table
     * @return
     */
    List<String> getAll(String table);
}
