package org.lantian.system.controller;

import jakarta.annotation.Resource;
import org.lantian.framework.common.utils.CommonResult;
import org.lantian.system.entity.IndexEntity;
import org.lantian.system.mapper.IndexMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;


/**
 * @Description: 测试控制层
 * @Author: zhang_jq
 * @Date: 2024-06-07 10:58
 * @Version: 1.0
 **/
@RestController
public class IndexController {

  @Resource
  private IndexMapper indexMapper;

  @Resource
  private DataSource dataSource;

  @GetMapping("/")
  public CommonResult<Class<?>> index() {
    return CommonResult.ok(dataSource.getClass());
  }

  @GetMapping("/{id}")
  public CommonResult<IndexEntity> index(@PathVariable Long id) {
    IndexEntity indexEntity = indexMapper.selectOther(id);
    return CommonResult.ok(indexEntity);
  }
}
