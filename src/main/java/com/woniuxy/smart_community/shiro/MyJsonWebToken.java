//package com.woniuxy.smart_community.shiro;/**
// * @description: TODO
// * @author 李佳复
// * @date 2022/7/1 10:46
// * @version 1.0
// */
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.apache.shiro.authc.AuthenticationToken;
//
///**
// * @author: 李佳复  <br/>
// * Date: 2022/7/1:10:46  <br/>
// * Description:替代UsernamePasswordToken的一个 实体类！
// * 用于封装token！获取校长getPrincipal，之前在
// * UsernamePasswordToken中的时候，拿到的是username；
// * 现在基于JWT认证的时候，将直接获取token！
// * 为了避免token被篡改和过期失效！
// */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class MyJsonWebToken implements AuthenticationToken {
//    private String token;
//    @Override
//    public Object getPrincipal() {
//        return token;
//    }
//
//    @Override
//    public Object getCredentials() {
//        return token;
//    }
//}
