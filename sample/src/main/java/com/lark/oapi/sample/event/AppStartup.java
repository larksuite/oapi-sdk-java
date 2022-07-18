package com.lark.oapi.sample.event;

import com.larksuite.oapi.sdk.servlet.ext.ServletAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
