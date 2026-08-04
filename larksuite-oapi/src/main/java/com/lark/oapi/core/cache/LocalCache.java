/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.lark.oapi.core.cache;

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

    private LocalCache() {
    }

    public static LocalCache getInstance() {
        return Inner.LOCAL_CACHE;
    }

    @Override
    public String get(String key) {
        Value v = CACHE.get(key);
        if (v == null || new Date().after(v.end)) {
            return "";
        }

        log.debug("get key:{},time left:{}s", key, (v.end.getTime() - System.currentTimeMillis()) / 1000);
        return v.value;
    }

    @Override
    public void set(String key, String value, int expire, TimeUnit timeUnit) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, (int) timeUnit.toSeconds(expire));
        Value v = new Value(value, calendar.getTime());
        log.debug("put key:{}, expire time:{} ", key, calendar.getTime());
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

    private static class Inner {

        private static final LocalCache LOCAL_CACHE = new LocalCache();
    }
}
