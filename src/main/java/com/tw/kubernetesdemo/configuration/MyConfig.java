package com.tw.kubernetesdemo.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "demo")
@Data
public class MyConfig {

  private String username;
  private String password;
}