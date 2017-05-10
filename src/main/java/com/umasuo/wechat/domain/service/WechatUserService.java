package com.umasuo.wechat.domain.service;

import com.umasuo.wechat.domain.model.User;
import com.umasuo.wechat.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 公众号关注用户服务，用于处理
 * Created by umasuo on 17/5/10.
 */
@Service
public class WechatUserService {

  @Autowired
  private transient UserRepository userRepository;

  /**
   * create user with openId.
   *
   * @param openId open id
   * @return User
   */
  public User createUser(String openId) {
    User user = new User();
    user.setOpenId(openId);
    return userRepository.save(user);
  }

}
