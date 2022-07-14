package com.woniuxy.smart_community.controller;/**
 * @description: TODO
 * @author 李佳复
 * @date 2022/7/8 15:39
 * @version 1.0
 */

import com.woniuxy.smart_community.entity.PropertyUser;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.PropertyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 李佳复  <br/>
 * Date: 2022/7/8:15:39  <br/>
 * Description:
 */
@RestController
public class LoginController {
    @Autowired
    PropertyUserService propertyUserService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody PropertyUser propertyUser){
        return propertyUserService.login(propertyUser);
    }
}
