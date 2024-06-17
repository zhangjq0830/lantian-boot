package org.lantian.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description: 实体类
 * @Author: zhang_jq
 * @Date: 2024-06-17 09:26
 * @Version: 1.0
 **/
@Data
@TableName("tb_user")
public class IndexEntity {
  private Long id;
  private String name;
  private Integer age;
  private String email;
}
