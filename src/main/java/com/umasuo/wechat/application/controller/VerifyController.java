package com.umasuo.wechat.application.controller;

import com.umasuo.wechat.infrastructure.Router;
import com.umasuo.wechat.infrastructure.config.ApplicationConfig;
import com.umasuo.wechat.infrastructure.utils.ByteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Created by umasuo on 17/5/9.
 * Wechat server need to verify the service with this api.
 */
@RestController
public class VerifyController {

  /**
   * LOG.
   */
  private static Logger LOG = LoggerFactory.getLogger(VerifyController.class);

  /**
   * application config.
   */
  @Autowired
  private transient ApplicationConfig applicationConfig;

  /**
   * Verify api for wechat.
   *
   * @param timestamp String
   * @param nonce     String
   * @param signature String
   * @param echoStr   String
   * @return String
   */
  @GetMapping(Router.ROOT)
  public String get(
      @RequestParam(value = Router.TIMESTAMP) String timestamp,
      @RequestParam(value = Router.NONCE) String nonce,
      @RequestParam(value = Router.SIGNATURE) String signature,
      @RequestParam(value = Router.ECHO_STR) String echoStr) {
    LOG.info("Enter. timestamp: {}, nonce: {}, signature: {}, echostr: {}",
        timestamp, nonce, signature, echoStr);

    String result = "";
    if (hasEmpty(timestamp, nonce, signature, echoStr)) {
      LOG.warn("Verify failed for some parameter has no text. ");
    }
    try {
      String[] arr = new String[] {timestamp, nonce, applicationConfig.getWechatToken()};
      Arrays.sort(arr);
      String rawValue = arr[0] + arr[1] + arr[2];
      String verifyString = ByteUtils.getHexString(rawValue);
      if (signature.equals(verifyString.toLowerCase())) {
        LOG.info("Verify success.");
        result = echoStr;
      }
    } catch (Exception e) {
      LOG.error(e.getMessage(), e);
    }
    return result;
  }

  /**
   * make sure the char sequence has text.
   *
   * @param strs charsequence
   * @return boolean
   */
  private boolean hasEmpty(CharSequence... strs) {
    for (CharSequence str : strs) {
      if (!StringUtils.hasText(str)) {
        return true;
      }
    }
    return false;
  }

}
