package org.lantian.framework.common.config;

import com.alibaba.druid.spring.boot3.autoconfigure.DruidDataSourceAutoConfigure;
import com.alibaba.druid.spring.boot3.autoconfigure.properties.DruidStatProperties;
import com.alibaba.druid.util.Utils;
import jakarta.servlet.*;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @Description: DruidConfig配置类
 * @Author: zhang_jq
 * @Date: 2025-01-26 16:06
 * @Version: 1.0
 **/
@Configuration
@AutoConfigureAfter(DruidDataSourceAutoConfigure.class)
public class DruidConfig {

  /**
   * 带有广告的common.js全路径
   */
  private static final String FILE_PATH = "support/http/resources/js/common.js";

  /**
   * 原始脚本，触发构建广告的语句
   */
  private static final String ORIGIN_JS = "this.buildFooter();";

  /**
   * 替换后的脚本
   */
  private static final String NEW_JS = "//this.buildFooter();";

  /**
   * 去除Druid监控页面的广告
   */
  @Bean
  @ConditionalOnWebApplication
  @ConditionalOnProperty(name = "spring.datasource.druid.stat-view-servlet.enabled", havingValue = "true")
  public FilterRegistrationBean<RemoveAdFilter> removeDruidAdFilter(DruidStatProperties properties) throws IOException {
    // 获取web监控页面的参数
    DruidStatProperties.StatViewServlet config = properties.getStatViewServlet();
    // 提取common.js的配置路径
    String pattern = config.getUrlPattern() != null ? config.getUrlPattern() : "/druid/*";
    String commonJsPattern = pattern.replaceAll("\\*", "js/common.js");
    // 获取common.js
    String text = Utils.readFromResource(FILE_PATH);
    // 屏蔽 this.buildFooter(); 不构建广告
    final String newJs = text.replace(ORIGIN_JS, NEW_JS);
    FilterRegistrationBean<RemoveAdFilter> registration = new FilterRegistrationBean<>();
    registration.setFilter(new RemoveAdFilter(newJs));
    registration.addUrlPatterns(commonJsPattern);
    return registration;

  }

  private class RemoveAdFilter implements Filter {
    private final String newJs;

    public RemoveAdFilter(String newJs) {
      this.newJs = newJs;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      chain.doFilter(request, response);
      // 重置缓冲区，响应头不会被重置
      response.resetBuffer();
      response.getWriter().write(newJs);
    }
  }
}
