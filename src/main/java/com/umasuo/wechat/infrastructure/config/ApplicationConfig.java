package com.umasuo.wechat.infrastructure.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by umasuo on 17/5/9.
 */
@Configuration
@Data
public class ApplicationConfig {

  /**
   * wechat token.
   */
  @Value("${wechat.token}")
  public String wechatToken;
}
