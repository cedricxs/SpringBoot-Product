package com.cedricxs.application.db.impl;

import com.cedricxs.application.db.MockDataBase;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
@Component
@Profile("local")
public class MockDataBaseImpl implements MockDataBase {

    private final Map<String, Map<String, String>> database = new ConcurrentHashMap<>(16);

    @Override
    public boolean set(String tableName, String key, String value) {
        Map<String, String> table = null;
        if (!database.containsKey(tableName)) {
            table = new ConcurrentHashMap<>(1024);
            database.put(tableName, table);
        } else {
            table = database.get(tableName);
        }
        table.put(key, value);
        return true;
    }

    @Override
    public List<String> getAll(String table) {
        return Optional.ofNullable(database.get(table))
                .map(Map::entrySet)
                .orElseGet(HashSet::new)
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
