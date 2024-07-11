package org.lantian.system.controller;

import org.lantian.framework.common.exception.ServiceException;
import org.lantian.framework.common.utils.CommonResult;
import org.lantian.system.entity.IndexEntity;
import org.lantian.system.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Description: 测试控制层
 * @Author: zhang_jq
 * @Date: 2024-06-07 10:58
 * @Version: 1.0
 **/
@RestController
public class IndexController {

  @Autowired
  private IndexMapper indexMapper;

  @GetMapping("/")
  public CommonResult<List<IndexEntity>> index() {
    try {
      int i = 1 / 0;
    } catch (Exception e) {
      throw new ServiceException("adijwij");
    }
    return CommonResult.ok("Hello world");
  }

  @GetMapping("/{id}")
  public CommonResult<IndexEntity> index(@PathVariable Long id) {
    IndexEntity indexEntity = indexMapper.selectOther(id);
    return CommonResult.ok(indexEntity);
  }
}
