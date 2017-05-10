package com.umasuo.wechat.infrastructure.utils;

import com.umasuo.wechat.application.model.WechatRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Resolver for wechat request.
 * Created by umasuo on 17/5/10.
 */
public final class WechatRequestResolver {

  private static final int DATA_SIZE = 1000;

  private static Logger LOG = LoggerFactory.getLogger(WechatRequestResolver.class);

  // JaxbConext for xml resolve
  private static JAXBContext context;
  private static Unmarshaller unmarshaller;
  private static Marshaller marshaller;
  private static StringWriter writer;

  /**
   * resolve wechat request.
   * @param request
   * @return WechatRequest
   * @throws IOException
   * @throws JAXBException
   */
  public static WechatRequest resolve(HttpServletRequest request)
      throws IOException, JAXBException {
    Reader reader = request.getReader();
    char[] dataChar = new char[DATA_SIZE];
    int readResult = reader.read(dataChar);
    LOG.debug("resolve wechat request. char count: {}", readResult);

    String data = new String(dataChar);
    data = data.replace('\n', ' ').trim();

    return decodeRequest(data);
  }

  /**
   * decode request data and change it to WechatRequest
   * @param data String data
   * @return WechatRequest
   * @throws JAXBException
   */
  public static WechatRequest decodeRequest(String data) throws JAXBException {
    Unmarshaller unmarshaller = getUnmarshaller();
    WechatRequest request = (WechatRequest) unmarshaller.unmarshal(new StringReader(data));
    return request;
  }

  /**
   * encode a WechatRequest to string
   * @param request
   * @return
   * @throws JAXBException
   */
  public static String encodeRequest(WechatRequest request) throws JAXBException {
    Marshaller marshaller = getMarshaller();

    marshaller.marshal(request, writer);
    return writer.toString();
  }

  /**
   * Unmarshaller.
   * @return Unmarshaller
   * @throws JAXBException
   */
  private static Unmarshaller getUnmarshaller() throws JAXBException {

    if (context == null) {
      context = JAXBContext.newInstance(WechatRequest.class);
    }

    if (unmarshaller == null) {
      unmarshaller = context.createUnmarshaller();
    }
    return unmarshaller;
  }

  /**
   * Marshaller.
   * @return Marshaller
   * @throws JAXBException
   */
  private static Marshaller getMarshaller() throws JAXBException {

    if (context == null) {
      context = JAXBContext.newInstance(WechatRequest.class);
    }

    if (marshaller == null) {
      marshaller = context.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");//编码格式
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);//是否格式化生成的xml串
      marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);//是否省略xm头声明信息

    }
    if (writer == null) {
      writer = new StringWriter();
    }
    return marshaller;
  }
}
