package com.woniuxy.smart_community.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 李佳复  <br/>
 * Date: 2022/6/30:16:12
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
