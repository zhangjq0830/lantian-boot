package org.lantian;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description: 项目单体启动类
 * @Author: zhang_jq
 * @Date: 2024-06-05 08:57
 * @Version: 1.0
 **/
@Slf4j
@SpringBootApplication
public class ServerApplication extends SpringBootServletInitializer {
  public static void main(String[] args) throws UnknownHostException {
    ApplicationContext application = SpringApplication.run(ServerApplication.class, args);
    Environment env = application.getEnvironment();
    String ip = InetAddress.getLocalHost().getHostAddress();
    String port = env.getProperty("server.port");
    String path = env.getProperty("server.servlet.context-path");
    log.info("\n----------------------------------------------------------\n\t" +
            "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
            "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
            "Swagger文档: \thttp://" + ip + ":" + port + path + "/doc.html\n" +
            "----------------------------------------------------------");
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(ServerApplication.class);
  }
}
