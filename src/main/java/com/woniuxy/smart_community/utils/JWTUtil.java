package com.woniuxy.smart_community.utils;/**
 * @description: TODO
 * @author 李佳复
 * @date 2022/7/1 10:35
 * @version 1.0
 */

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * @author: 李佳复  <br/>
 * Date: 2022/7/1:10:35  <br/>
 * Description:jwt工具类
 */

public class JWTUtil {
    //过期时间 未来会频繁变化修改，所以提出来 目前过期时间5min
    private static final long EXPIRE_TIME = 5 * 60 * 1000;

    /**
     * Auther: 李佳复  <br/>
     * Date: 10:39:2022/7/1  <br/>
     * Description:签名生成JWT
     */

    public static String sign(String username, String password) {
        //先对密码进行加密  让盐值更加散列
        Algorithm algorithm = Algorithm.HMAC256(password);
        return JWT.create().withClaim("username", username)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                .sign(algorithm);
    }

    /**
     * Auther: 李佳复  <br/>
     * Date: 10:39:2022/7/1  <br/>
     * Description:使用token 用户和密码 进行内部直接jwt校验
     */

    public static boolean verify(String token, String username, String password) {
        //先对密码进行加密  算法和sign生成的时候 要保持一致
        Algorithm algorithm = Algorithm.HMAC256(password);
        //传入你签名时候的秘钥，还有claim属性
        JWTVerifier verifier = JWT.require(algorithm).withClaim("username", username)
                .build();
        //这个方法就能直接校验jwt的正确性！
        verifier.verify(token);
        //如果校验失败会报错！
        return true;
    }

    /**
     * Auther: 李佳复  <br/>
     * Date: 10:38:2022/7/1  <br/>
     * Description:根据token获取用户名
     */
    public static String getUsername(String token) {
        DecodedJWT decode = JWT.decode(token);
        return decode.getClaim("username").asString();
    }
}
