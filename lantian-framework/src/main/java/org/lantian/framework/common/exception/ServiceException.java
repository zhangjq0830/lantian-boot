package org.lantian.framework.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @Description: 业务异常处理
 * @Author: zhang_jq
 * @Date: 2024-06-08 09:42
 * @Version: 1.0
 **/
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class ServiceException extends RuntimeException {
  @Serial
  private static final long serialVersionUID = 1L;

  /**
   * 错误码
   */
  private int code;

  /**
   * 错误提示
   */
  private String msg;

  public ServiceException(String msg) {
    this.msg = msg;
  }
}

