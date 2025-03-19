package org.lantian.system.controller;

import com.alibaba.druid.pool.DruidDataSource;
import jakarta.annotation.Resource;
import org.lantian.framework.common.utils.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 欢迎信息
 * @Author: zhang_jq
 * @Date: 2025-01-10 10:43
 * @Version: 1.0
 **/
@RestController
public class IndexController {

  @Resource
  private DruidDataSource dataSource;

  @RequestMapping("/")
  public CommonResult<Map<String, Object>> index() {
    Map<String, Object> map = new HashMap<>();
    map.put("initialSize", dataSource.getInitialSize());
    map.put("maxActive", dataSource.getMaxActive());

    return CommonResult.ok(map);
  }
}
