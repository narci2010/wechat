package com.umasuo.wechat.application.controller;

import com.umasuo.wechat.application.model.WechatRequest;
import com.umasuo.wechat.infrastructure.Router;
import com.umasuo.wechat.infrastructure.service.ServiceLocator;
import com.umasuo.wechat.infrastructure.utils.WechatRequestResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by umasuo on 17/5/10.
 * Wechat controller, the unique entrance for messages from wechat server.
 */
@RestController
public class WechatController {

  /**
   * LOG.
   */
  private static Logger LOG = LoggerFactory.getLogger(WechatController.class);

  /**
   * service locator.
   */
  @Autowired
  private transient ServiceLocator serviceLocator;

  /**
   * the unique entrance of wechat request.
   *
   * @param request
   * @param response
   */
  @PostMapping(value = Router.ROOT)
  public void wechat(HttpServletRequest request, HttpServletResponse response) {
    try {
      // 用异步方式处理，这里直接返回“”，因有些接口需要response返回，这里返回空串而不是“success”
      response.getWriter().write("");
      response.getWriter().flush();

      WechatRequest weChatRequest = WechatRequestResolver.resolve(request);
      LOG.info("Enter. wechatRequest: {}", weChatRequest);
      serviceLocator.getService(weChatRequest).handle(weChatRequest, response);
//      String serviceId = this.getServiceId(weChatRequest);
//      WechatService service = map.get(serviceId);
//      service.handle(weChatRequest, response);

    } catch (Exception e) {
      LOG.error(e.getMessage(), e);
    }
  }
}
