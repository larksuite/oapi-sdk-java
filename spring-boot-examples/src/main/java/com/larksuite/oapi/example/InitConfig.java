package com.larksuite.oapi.example;

import com.larksuite.oapi.core.AppSettings;
import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Domain;
import com.larksuite.oapi.example.config.Configs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitConfig {

    private static final Logger log = LoggerFactory.getLogger(InitConfig.class);

    @Bean
    public Config config() {

        // for Cutome APP（自建应用）
        AppSettings appSettings = Config.getInternalAppSettingsByEnv();
        // config with redis store
        // Config config = Configs.getConfigWithRedisStore(Domain.FeiShu, appSettings);
        Config config = Configs.getConfig(Domain.FeiShu, appSettings);
        log.debug("config:{}", config);
        return config;

    }
}
