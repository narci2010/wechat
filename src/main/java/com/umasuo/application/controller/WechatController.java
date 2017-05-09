package com.umasuo.application.controller;

import com.umasuo.infrastructure.Router;
import com.umasuo.infrastructure.config.ApplicationConfig;
import com.umasuo.infrastructure.utils.ByteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

/**
 * Created by umasuo on 17/5/9.
 */
public class WechatController {

  private static Logger LOG = LoggerFactory.getLogger(WechatController.class);

  private transient ApplicationConfig applicationConfig;

  public String get(
      @RequestParam(value = Router.TIMESTAMP) String timestamp,
      @RequestParam(value = Router.NONCE) String nonce,
      @RequestParam(value = Router.SIGNATURE) String signature,
      @RequestParam(value = Router.ECHO_STR) String echoStr) {
    if (hasNoText(timestamp, nonce, signature, echoStr)) {
      LOG.error(
          "wechat api verify failed. Invalid parameters: timestamp {}, nonce {}, signature {}, " +
              "echostr {}",
          timestamp, nonce, signature, echoStr);
      return "";
    }
    try {
      String[] arr = new String[] {timestamp, nonce, applicationConfig.getWechatToken()};
      Arrays.sort(arr);
      String rawValue = arr[0] + arr[1] + arr[2];
      String verifyString = ByteUtils.getHexString(rawValue);
      if (signature.equals(verifyString.toLowerCase())) {
        LOG.info(
            "wechat api verify success. timestamp:{},nonce:{},signature:{},echostr:{}," +
                "verifyString:{}",
            timestamp, nonce, signature, echoStr, verifyString);
        return echoStr;
      }
    } catch (Exception e) {
      LOG.error(e.getMessage(), e);
    }
    LOG.error(
        "wechat api verify failed. timestamp {}, nonce {}, signature {}, echostr {}, token {}",
        timestamp, nonce, signature, echoStr, applicationConfig.getWechatToken());
    return "";
  }

  private boolean hasNoText(CharSequence... strs) {
    for (CharSequence str : strs) {
      if (!StringUtils.hasText(str)) {
        return true;
      }
    }
    return false;
  }

}
