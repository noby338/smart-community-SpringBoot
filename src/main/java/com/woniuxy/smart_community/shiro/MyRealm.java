//package com.woniuxy.smart_community.shiro;/**
// * @description: TODO
// * @author 李佳复
// * @date 2022/7/1 11:16
// * @version 1.0
// */
//
//import com.woniuxy.smart_community.entity.PropertyUser;
//import com.woniuxy.smart_community.service.PropertyUserService;
//import com.woniuxy.smart_community.utils.JWTUtil;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Set;
//
///**
// * @author: 李佳复  <br/>
// * Date: 2022/7/1:11:16  <br/>
// * Description:自定义域
// */
//@Component
//public class MyRealm extends AuthorizingRealm {
//    @Autowired
//    PropertyUserService propertyUserService;
//
////    @Override
////    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
////        String token = principals.getPrimaryPrincipal()+"";
////        String username = JWTUtil.getUsername(token);
////        //去数据库查询该用户所有的角色和权限
////        Set<String> roles = propertyUserService.findAllRoles(username);
////        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
////        simpleAuthorizationInfo.setRoles(roles);
////        //获取权限
////        Set<String> perms =propertyUserService.findAllPerms(username);
////        simpleAuthorizationInfo.setStringPermissions(perms);
////        return simpleAuthorizationInfo;
//////        return null;
////    }
////
/////**
//// * Auther: 李佳复  <br/>
//// * Date: 11:22:2022/7/1  <br/>
//// * Description:认证，判断token
//// */
////
////    @Override
////    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
////        MyJsonWebToken myJsonWebToken = (MyJsonWebToken) authenticationToken;
////        //这里是我们前端传来的token！
////        String token = myJsonWebToken.getCredentials()+"";
////        String username = JWTUtil.getUsername(token);
////
////        //使用username去数据库查询密码！
////        String password = propertyUserService.findPassword(username);
////        //校验token是否正常,密码做盐使加密更散列
////        boolean verify = JWTUtil.verify(token, username, password);
////        if (verify){
////            //直接把token封装进去！
////            return new SimpleAuthenticationInfo(token,token,"myRealm");
////        }else{
////            throw new AuthenticationException("token被篡改，请重新登录！");
////        }
////    }
//}
