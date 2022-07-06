package com.woniuxy.smart_community.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 该类用于测试 controller 和 演示文档注释的规范
 * @Author noby
 * @Date 2022/7/5 19:22
 */
@RestController
public class Test {
    /**
     * 该方法获取根据用户 id 获取用户名
     * @param id 用户的id
     * @return 用户名和 id 的字符串信息
     */
    @RequestMapping("/getName/{id}")
    public String getName(@PathVariable("id") int id) {
        return "username:noby,userid:"+id;
    }
}
