package com.cedricxs.application.db.impl;

import com.cedricxs.application.db.RedisManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author chaxingshuo
 * @date 2021/07/12
 */
@Slf4j
@Component
@Profile("dev")
public class RedisManagerImpl implements RedisManager {

    @Resource
    RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
                return true;
            } else {
                log.warn("[RedisManager.expire] expire time invalid. expire={}", time);
                return false;
            }
        } catch (Exception e) {
            log.error("[RedisManager.expire] set key expire failed. key={}, expire={}, exception={}.", key, time, e);
            return false;
        }
    }

    @Override
    public boolean del(String key) {
        if (key != null) {
            return Optional.ofNullable(redisTemplate.delete(key))
                    .orElse(Boolean.FALSE);
        }
        return false;
    }

    @Override
    public String get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean set(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            log.error("[RedisManager.set] set key value failed. key={}, value={}, exception={}.", key, value, e);
            return false;
        }
    }

    @Override
    public boolean set(String key, String value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                log.warn("[RedisManager.set] expire time invalid. expire={}", time);
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            log.error("[RedisManager.set] set key value expire failed. key={}, value={}, expire={}, exception={}.", key, value, time, e);
            return false;
        }
    }

    @Override
    public Object hget(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    @Override
    public Map<Object, Object> hmget(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    @Override
    public boolean hmset(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            log.error("[RedisManager.hmset] hmset key map failed. key={}, map={}, exception={}.", key, map, e);
            return false;
        }
    }

    @Override
    public boolean hset(String key, String item, Object value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            log.error("[RedisManager.hset] hset key value failed. key={}, map={}, exception={}.", key, value, e);
            return false;
        }
    }

    @Override
    public void hdel(String key, Object... item) {
        redisTemplate.opsForHash().delete(key, item);
    }

    @Override
    public boolean hHasKey(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    @Override
    public List<Object> hvals(String key) {
        return redisTemplate.opsForHash().values(key);
    }
}
