package com.larksuite.oapi.example;

import com.larksuite.oapi.sdk.servlet.ext.ServletAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// TODO springboot example 放入 sample 模块是不是更好些
@SpringBootApplication
public class AppStartup {

  public static void main(String[] args) {
    SpringApplication.run(AppStartup.class, args);
  }

  @Bean
  public ServletAdapter getServletAdapter() {
    return new ServletAdapter();
  }
}
