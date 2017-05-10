package com.umasuo.wechat.application.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 自动更新微信token
 * Created by umasuo on 17/5/10.
 */
@Service
public class TokenUpdater {

  /**
   * 在token过期前12分钟去重新取token.
   */
  private static transient long TIME_BEFORE_EXPIRED= 720000;

  /**
   * 每10分钟检查一下token的有效性, 10分钟与12分钟是为了避免出现token过期却没被更新的错误.
   */
  @Scheduled(fixedRate = 600000)
  public void executor(){

  }
}
