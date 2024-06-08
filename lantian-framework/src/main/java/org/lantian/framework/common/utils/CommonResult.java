package org.lantian.framework.common.utils;

import cn.hutool.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Description: 公共返回类
 * @Author: zhang_jq
 * @Date: 2024-06-07 11:36
 * @Version: 1.0
 **/
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResult<T> {

  /**
   * 状态码
   */
  private int code;

  /**
   * 提示语
   */
  private String msg;

  /**
   * 数据对象
   */
  private T data;

  /**
   * 返回成功数据
   *
   * @return 成功消息
   */
  public static <T> CommonResult<T> ok() {
    return ok("操作成功");
  }

  /**
   * 返回成功数据
   *
   * @param msg 提示语
   * @return 成功消息
   */
  public static <T> CommonResult<T> ok(String msg) {
    return new CommonResult<>(HttpStatus.HTTP_OK, msg, null);
  }

  /**
   * 返回成功数据
   *
   * @param data 数据对象
   * @return 成功消息
   */
  public static <T> CommonResult<T> ok(T data) {
    return new CommonResult<>(HttpStatus.HTTP_OK, "操作成功", data);
  }

  /**
   * 返回失败消息
   *
   * @return 失败消息
   */
  public static <T> CommonResult<T> error() {
    return error("服务器异常");
  }

  /**
   * 返回失败消息
   *
   * @param msg 提示语
   * @return 失败消息
   */
  public static <T> CommonResult<T> error(String msg) {
    return error(HttpStatus.HTTP_INTERNAL_ERROR, msg);
  }

  /**
   * 返回失败消息
   *
   * @param code 状态码
   * @param msg  提示语
   * @return 失败消息
   */
  public static <T> CommonResult<T> error(int code, String msg) {
    return new CommonResult<>(code, msg, null);
  }
}
