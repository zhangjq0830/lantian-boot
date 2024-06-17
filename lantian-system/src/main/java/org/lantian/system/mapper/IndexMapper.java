package org.lantian.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.lantian.system.entity.IndexEntity;

/**
 * @Description: 测试mapper
 * @Author: zhang_jq
 * @Date: 2024-06-17 09:23
 * @Version: 1.0
 **/
@Mapper
public interface IndexMapper extends BaseMapper<IndexEntity> {

  public IndexEntity selectOther(Long id);
}
