package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 统一的响应对象
 * @Author noby
 * @Date 2022/7/6 20:17
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseResult<T>{
    private Integer code;//响应码
    private String msg;//响应信息
    private T data;//响应数据
}
