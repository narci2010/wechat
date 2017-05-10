package com.umasuo.wechat.infrastructure.service;

import com.umasuo.wechat.application.model.WechatRequest;

import javax.servlet.http.HttpServletResponse;

/**
 * wechat service interface.
 * Created by umasuo on 17/5/10.
 */
public interface WechatService {

  /**
   * wechat request handler.
   * @param request request
   * @param response response
   * @throws Exception
   */
  void handle(WechatRequest request, HttpServletResponse response) throws Exception;
}
