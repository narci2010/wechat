package com.umasuo.wechat.application.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The request from wechat.
 * Reference: http://iot.weixin.qq.com/wiki/document-2_1.html
 * Created by umasuo on 17/5/10.
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class WechatRequest {

  public static final String MSG_TYPE_DEVICE_EVENT = "device_event";
  public static final String MSG_TYPE_DEVICE_TEXT = "device_text";
  public static final String MSG_TYPE_CUSTOMER_SERVICE = "transfer_customer_service";
  public static final String MSG_TYPE_EVENT = "event";
  public static final String MSG_TYPE_TEXT = "text";
  public static final String MSG_EVENT_SUBSCRIBE = "subscribe";
  public static final String MSG_EVENT_UNSUBSCRIBE = "unsubscribe";
  public static final String MSG_EVENT_CLICK = "CLICK";
  public static final String MSG_DEVICE_EVENT_BIND = "bind";
  public static final String MSG_DEVICE_EVENT_UNBIND = "unbind";
  public static final String MSG_DEFAULT = "default";

  @XmlElement(name = "ToUserName")
  private String toUserName;

  @XmlElement(name = "FromUserName")
  private String fromUserName;

  @XmlElement(name = "CreateTime")
  private String createTime;

  @XmlElement(name = "MsgType")
  private String msgType;

  @XmlElement(name = "Content")
  private String content;

  @XmlElement(name = "MsgId")
  private String msgId;

  @XmlElement(name = "Latitude")
  public String latitude;

  @XmlElement(name = "Event")
  public String event;

  @XmlElement(name = "Longitude")
  public String longitude;

  @XmlElement(name = "Precision")
  public String precision;

  @XmlElement(name = "DeviceID")
  public String deviceId;

  @XmlElement(name = "DeviceType")
  public String deviceType;

  @XmlElement(name = "SessionID")
  public String sessionId;

  @XmlElement(name = "OpenID")
  public String openId;

  @XmlElement(name = "FuncFlag")
  public String funcFlag;

  @XmlElement(name = "Ticket")
  public String ticket;

  @XmlElement(name = "EventKey")
  public String eventKey;

}
