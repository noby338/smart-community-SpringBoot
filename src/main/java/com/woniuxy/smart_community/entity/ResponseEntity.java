package com.woniuxy.smart_community.entity;/**
 * @description: TODO
 * @author 李佳复
 * @date 2022/6/30 16:12
 * @version 1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 李佳复  <br/>
 * Date: 2022/6/30:16:12  <br/>
 * Description:统一响应
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEntity<T> {
    int code;
    String msg;
    T data;
}
