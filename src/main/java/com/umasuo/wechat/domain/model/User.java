package com.umasuo.wechat.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 关注公众号的用户的基本信息, 如果需要更多信息，可另建表补充.
 * Created by umasuo on 17/5/10.
 */
@Entity
@Table(name = "wechat_user")
@Data
@EqualsAndHashCode(callSuper = false)
@EntityListeners(AuditingEntityListener.class)
public class User {

  /**
   * uuid.
   */
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private String id;

  /**
   * The Created at.
   */
  @CreatedDate
  @Column
  private ZonedDateTime createdAt;

  /**
   * The Last modified at.
   */
  @LastModifiedDate
  @Column
  private ZonedDateTime lastModifiedAt;

  /**
   * 公众号的openId,每个公众号唯一
   */
  @Column
  @NotEmpty
  private String openId;

  /**
   * 每个开放平台的唯一ID，可为空
   */
  @Column
  private String unionId;

  /**
   * 用户最后关注的时间
   */
  @Column
  private Long subscribeTime;

  /**
   * 用户取消关注的时间
   */
  @Column
  private Long unsubscribeTime;

  /**
   * 用户的状态
   */
  private Integer status;
}
