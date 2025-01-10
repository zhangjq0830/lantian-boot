package org.lantian.system.controller;

import org.lantian.framework.common.utils.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 欢迎信息
 * @Author: zhang_jq
 * @Date: 2025-01-10 10:43
 * @Version: 1.0
 **/
@RestController
public class IndexController {

  @RequestMapping("/")
  public CommonResult<String> index() {
    return CommonResult.ok("lantian-system");
  }
}
