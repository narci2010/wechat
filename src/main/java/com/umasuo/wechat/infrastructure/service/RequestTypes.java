package com.umasuo.wechat.infrastructure.service;

/**
 * Created by umasuo on 17/5/10.
 */
public final class RequestTypes {

  /**
   * 用户关注了公众号
   */
  public static final String MSG_EVENT_SUBSCRIBE = "subscribe";
  /**
   * 用户取消关注公众号
   */
  public static final String MSG_EVENT_UNSUBSCRIBE = "unsubscribe";
  /**
   * 用户点击了菜单
   */
  public static final String MSG_EVENT_CLICK = "CLICK";


  public static final String MSG_TYPE_DEVICE_EVENT = "device_event";
  public static final String MSG_TYPE_DEVICE_TEXT = "device_text";
  public static final String MSG_TYPE_CUSTOMER_SERVICE = "transfer_customer_service";
  public static final String MSG_TYPE_EVENT = "event";
  public static final String MSG_TYPE_TEXT = "text";
  public static final String MSG_DEVICE_EVENT_BIND = "bind";
  public static final String MSG_DEVICE_EVENT_UNBIND = "unbind";
  public static final String MSG_DEFAULT = "default";
}
