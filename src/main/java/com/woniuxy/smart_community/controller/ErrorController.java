package com.woniuxy.smart_community.controller;/**
 * @description: TODO
 * @author 李佳复
 * @date 2022/7/1 12:13
 * @version 1.0
 */

import com.woniuxy.smart_community.entity.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 李佳复  <br/>
 * Date: 2022/7/1:12:13  <br/>
 * Description:
 */

@RestController
public class ErrorController {
    @RequestMapping("/401")
    public ResponseEntity send401(){
        return new ResponseEntity(401,"token认证失败！","");
    }
}
