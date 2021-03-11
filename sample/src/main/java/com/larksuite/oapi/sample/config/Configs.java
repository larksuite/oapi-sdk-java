package com.larksuite.oapi.sample.config;

import com.larksuite.oapi.core.AppSettings;
import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.DefaultStore;
import com.larksuite.oapi.core.Domain;

public class Configs {

    public static Config getConfig(Domain domain, AppSettings appSettings) {
        return new Config(domain, appSettings, new DefaultStore());
    }

    public static Config getConfig(String domain, AppSettings appSettings) {
        return new Config(domain, appSettings, new DefaultStore());
    }

    /**
     * by redis store access token
     *
     * @param domain
     * @param appSettings
     * @return
     */
    public static Config getConfigWithRedisStore(Domain domain, AppSettings appSettings) {
        return new Config(domain, appSettings, new RedisStore());
    }

    public static Config getConfigWithRedisStore(String domain, AppSettings appSettings) {
        return new Config(domain, appSettings, new RedisStore());
    }

}
