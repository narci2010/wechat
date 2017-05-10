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
