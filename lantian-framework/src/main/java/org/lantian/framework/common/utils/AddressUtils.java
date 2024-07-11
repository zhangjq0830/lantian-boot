package org.lantian.framework.common.utils;

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 获取真实地址
 * @Author: zhang_jq
 * @Date: 2024-06-07 09:11
 * @Version: 1.0
 **/
@Slf4j
public class AddressUtils {
  // IP地址查询
  public static final String ADDRESS_URL = "https://whois.pconline.com.cn/ipJson.jsp";

  // 未知地址
  public static final String UNKNOWN = "未知";


  public static String getRealAddressByIp(String ip) {
    // 内网不查询
    if (NetUtil.isInnerIP(ip)) {
      return "内网IP";
    }

    try {
      Map<String, Object> paramMap = new HashMap<>();
      paramMap.put("ip", ip);
      paramMap.put("json", true);
      String response = HttpUtil.get(ADDRESS_URL, paramMap);
      if (StrUtil.isBlank(ip)) {
        log.error("根据IP获取地址异常 {}", ip);
        return UNKNOWN;
      }
      Address address = JSONUtil.toBean(response, Address.class);
      return StrUtil.format("{}-{}", address.getPro(), address.getCity());
    } catch (Exception e) {
      log.error("根据IP获取地址异常 {}", ip);
    }
    return UNKNOWN;
  }


  @Data
  static class Address {
    /**
     * 省
     */
    private String pro;
    /**
     * 市
     */
    private String city;
  }
}
