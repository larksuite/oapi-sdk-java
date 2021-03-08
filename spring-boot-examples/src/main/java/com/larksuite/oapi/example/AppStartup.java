package com.larksuite.oapi.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class AppStartup {

    public static void main(String[] args) {
        SpringApplication.run(AppStartup.class, args);
    }

}
