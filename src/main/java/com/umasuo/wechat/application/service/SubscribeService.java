package com.umasuo.wechat.application.service;

import com.umasuo.wechat.application.model.WechatRequest;
import com.umasuo.wechat.infrastructure.service.WechatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * subscribe service, used to handler subscribe messages.
 */
@Service(value = "subscribe")
public class SubscribeService implements WechatService {

  private static Logger LOG = LoggerFactory.getLogger(SubscribeService.class);
//
//    @Autowired
//    private BindingDao bindingDao;
//    @Autowired
//    private WeChatCustomApiService apiService;
//    @Autowired
//    private EMQMessageProducer messageProducer;

//    @Override
//    public void handle(WeChatRequest request, HttpServletResponse response) throws Exception {
//
//        String openId = request.getFromUserName();
//
//        WeChatBindingEntity entity = this.bindingDao.getByOpenId(openId);
//        if (entity == null) {
//            entity = new WeChatBindingEntity();
//            entity.setOpenId(openId);
//            entity.setStatus(WeChatBindingEntity.STATUS_SUBSCRIBE);
//        } else if (WeChatBindingEntity.STATUS_UNSUBSCRIBE.equals(entity.getStatus())) {
//            entity.setStatus(WeChatBindingEntity.STATUS_SUBSCRIBE);
//        }
//        entity.setSubscribeTime(System.currentTimeMillis() / 1000);
//        boolean success = this.bindingDao.save(entity);
//        if (success && !StringUtils.isEmpty(entity.getUserId())) {
//            MessageAttribute attr = new MessageAttribute("STRING");
//            //这个userId 是之前绑定手环时的userId，这时候重新关注的话，可能userId已经不一样了，所以这里不再推送数据
//            attr.setStringValue(entity.getUserId());
//            Map<String, MessageAttribute> messageAttributes = ImmutableMap.of
// (SystemParametersUtils.USER_ID, attr);
//            String message = JsonUtils.serialize(entity);
//            this.messageProducer.sendMessage(message, entity.getUserId(), messageAttributes);
//        }
//        logger.info("Subscribe, request: {}, result: {}", request, success);
//
//        this.apiService.sendTextToUser(openId, "欢迎关注，购买AMAZFIT请上京东：http://item.jd
// .com/1968013.html");
//    }


  @Override
  public void handle(WechatRequest request, HttpServletResponse response) throws Exception {
    LOG.debug("Enter. wechatRequest: {}", request);
  }
}
