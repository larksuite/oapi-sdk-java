package com.larksuite.oapi.core.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public class LocalCache implements ICache {
    private static final Logger log = LoggerFactory.getLogger(LocalCache.class);
    private static final ConcurrentMap<String, Value> CACHE = new ConcurrentHashMap<>(64);

    @Override
    public String get(String key) {
        log.debug("get key:{}", key);
        Value v = this.CACHE.get(key);
        if (v == null || new Date().after(v.end)) {
            return "";
        }
        return v.value;
    }

    @Override
    public void set(String key, String value, int expire, TimeUnit timeUnit) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, (int) timeUnit.toSeconds(expire));
        Value v = new Value(value, calendar.getTime());
        log.debug("put key:{}, value:{}, expire time:{} ", key, value, calendar.getTime());
        this.CACHE.put(key, v);
    }

    private static class Value {
        String value;
        Date end;

        public Value(String value, Date time) {
            this.value = value;
            this.end = time;
        }
    }
}
