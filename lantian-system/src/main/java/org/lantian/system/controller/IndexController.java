package org.lantian.system.controller;

import org.lantian.framework.common.utils.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description: 测试控制层
 * @Author: zhang_jq
 * @Date: 2024-06-07 10:58
 * @Version: 1.0
 **/
@RestController
public class IndexController {

  @GetMapping("/")
  public CommonResult<String> index() {
    return CommonResult.ok("Hello World");
  }
}
