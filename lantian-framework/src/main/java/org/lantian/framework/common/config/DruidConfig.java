package org.lantian.framework.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: druid配置文件
 * @Author: zhang_jq
 * @Date: 2025-01-10 14:15
 * @Version: 1.0
 **/
@Configuration
public class DruidConfig {

  @Bean
  @ConfigurationProperties("spring.datasource.druid")
  public DruidDataSource druidDataSource() {
    return new DruidDataSource();
  }
}
