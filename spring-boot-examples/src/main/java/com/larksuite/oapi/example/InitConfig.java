package com.larksuite.oapi.example;

import com.larksuite.oapi.core.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitConfig {
    private static final Logger log = LoggerFactory.getLogger(InitConfig.class);

    @Bean
    public Config config() {
        //Config config = Config.getTestISVConf("boe");
        Config config = Config.getTestInternalConf("online");
        log.info("config:{}", config);
        return config;
    }
}
