//package com.woniuxy.smart_community.shiro;/**
// * @description: TODO
// * @author 李佳复
// * @date 2022/7/1 10:52
// * @version 1.0
// */
//
//import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author: 李佳复  <br/>
// * Date: 2022/7/1:10:52  <br/>
// * Description:JWT过滤器，拦截token
// * 过滤链流程：preHandler-->isAccessAllowed
// * -->isLoginAttempt-->executeLogin
// */
//
//public class JWTFilter extends BasicHttpAuthenticationFilter {
//    /*/*
//     * Description : 用于跨域  <br/>
//     * ChangeLog : 1. 创建 (2022/7/1 10:53 [58369]);
//     ** @param null
//     * *  @return null
//     */
//
//    @Override
//    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
//        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
//        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
//        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
//        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
//        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
//            httpServletResponse.setStatus(HttpStatus.OK.value());
//            return false;
//        }
//        return super.preHandle(request, response);
//////        return true;
//    }
//    /*/*
//     * Description : token认证入口，进行业务逻辑处理！和后续过滤器方法的调用  <br/>
//     * ChangeLog : 1. 创建 (2022/7/1 10:55 [58369]);
//     ** @param null
//     * *  @return null
//     */
//
//    @Override
//    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
//        //检查认证请求 获取请求头中的token,判断是不是登录请求
//        if (isLoginAttempt(request, response)) {
//            System.out.println(request);
//            try {
//                //执行登录 subject.login
//                executeLogin(request, response);
//            } catch (Exception e) {
//                //如果请求头中没有token  跳转到401请求！让401controller返回前端一个请求
//                response401(request, response);
//                e.printStackTrace();
//            }
//        } else {
//            //如果没有请求头的情况，我们直接返回401信息即可！
//            response401(request, response);
//        }
//        return true;
//    }
//
//    /*/*
//     * Description : 登录请求判断，尝试获取请求头中的token信息！  <br/>
//     * ChangeLog : 1. 创建 (2022/7/1 11:06 [58369]);
//     ** @param null
//     * *  @return null
//     */
//
//    @Override
//    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
//        HttpServletRequest request1 = (HttpServletRequest) request;
//        //从请求头中获取认证token信息
//        String token = request1.getHeader("Authorization");
//        return token != null;
//    }
//    /*/*
//     * Description : 执行登录  <br/>
//     * ChangeLog : 1. 创建 (2022/7/1 11:09 [58369]);
//     ** @param null
//     * *  @return null
//     */
//
//    @Override
//    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
//        HttpServletRequest request1 = (HttpServletRequest) request;
//        //从请求头中获取认证token信息
//        String token = request1.getHeader("Authorization");
//        getSubject(request, response).login(new MyJsonWebToken(token));
//        return true;
//    }
//
//    //如果请求头没有token则跳转401请求controller
//    private void response401(ServletRequest request, ServletResponse response) {
//        HttpServletResponse response1 = (HttpServletResponse) response;
//        try {
//            response1.sendRedirect("/401");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
