package com.umasuo.wechat.infrastructure.service;

import com.umasuo.wechat.application.model.WechatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * wecaht service locator. used to find service for handler wechat request.
 * Created by umasuo on 17/5/10.
 */
@Service
public class ServiceLocator {

  /**
   * the application context.
   */
  @Autowired
  private transient ApplicationContext context;

  /**
   * find the service that used to handler this request.
   *
   * @param request WechatRequest
   * @return WechatRequest
   */
  public WechatService getService(WechatRequest request) {
    String serviceId = getServiceId(request);
    return context.getBean(serviceId, WechatService.class);
  }

  /**
   * service id resolver, get service id by wechat request.
   *
   * @param weChatRequest
   * @return String service id
   */
  private String getServiceId(WechatRequest weChatRequest) {
    switch (weChatRequest.getMsgType()) {
      case RequestTypes.MSG_TYPE_EVENT:
      case RequestTypes.MSG_TYPE_DEVICE_EVENT: {
        switch (weChatRequest.getEvent()) {
          case RequestTypes.MSG_EVENT_SUBSCRIBE:
          case RequestTypes.MSG_EVENT_UNSUBSCRIBE:
          case RequestTypes.MSG_DEVICE_EVENT_BIND:
          case RequestTypes.MSG_DEVICE_EVENT_UNBIND:
            return weChatRequest.getEvent();
          case RequestTypes.MSG_EVENT_CLICK:
            return weChatRequest.getEventKey();
          default:
            return "default";
        }
      }
      case RequestTypes.MSG_TYPE_TEXT:
        return weChatRequest.getMsgType();
      case RequestTypes.MSG_TYPE_DEVICE_TEXT:
      default:
        return "default";
    }
  }

}
