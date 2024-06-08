package org.lantian.framework.common.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.lantian.framework.common.utils.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description: 全局异常处理
 * @Author: zhang_jq
 * @Date: 2024-06-08 09:21
 * @Version: 1.0
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ServiceException.class)
  public CommonResult<String> handleServiceException(ServiceException e, HttpServletRequest request) {
    String requestURI = request.getRequestURI();
    log.error("请求地址'{}',发生业务异常.", requestURI, e);
    return CommonResult.error(e.getCode(), e.getMsg());
  }

  @ExceptionHandler(Exception.class)
  public CommonResult<String> handleException(Exception e, HttpServletRequest request) {
    String requestURI = request.getRequestURI();
    log.error("请求地址'{}',发生系统异常.", requestURI, e);
    return CommonResult.error("系统内部异常，请联系管理员");
  }
}
