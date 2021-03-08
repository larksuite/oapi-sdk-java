package com.larksuite.oapi.sample.config;

import com.larksuite.oapi.core.IStore;
import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

public class RedisStore implements IStore {

    private final Jedis jedis;

    public RedisStore() {
        this.jedis = new Jedis("127.0.0.1", 6379);
    }

    @Override
    public String get(String key) throws Exception {
        return jedis.get(key);
    }

    @Override
    public void put(String key, String value, int expire, TimeUnit timeUnit) throws Exception {
        jedis.setex(key, (int) timeUnit.toSeconds(expire), value);
    }
}
