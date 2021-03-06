//package com.woniuxy.smart_community.controller;/**
// * @description: TODO
// * @author 李佳复
// * @date 2022/7/2 9:43
// * @version 1.0
// */
//
//import com.woniuxy.smart_community.entity.ResponseEntity;
//import org.apache.shiro.ShiroException;
//import org.apache.shiro.authz.UnauthorizedException;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * @author: 李佳复  <br/>
// * Date: 2022/7/2:9:43  <br/>
// * Description:
// */
//
//@RestControllerAdvice
//public class ShiroExceptionController {
//
//    // 捕捉shiro的异常
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    @ExceptionHandler(ShiroException.class)
//    public ResponseEntity handle401(ShiroException e) {
//        return new ResponseEntity(401, e.getMessage(), null);
//    }
//
//    // 捕捉UnauthorizedException
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    @ExceptionHandler(UnauthorizedException.class)
//    public ResponseEntity handle401() {
//        return new ResponseEntity(401, "Unauthorized", null);
//    }
//
//    // 捕捉其他所有异常
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity globalException(HttpServletRequest request, Throwable ex) {
//        return new ResponseEntity(getStatus(request).value(), ex.getMessage(), null);
//    }
//
//    private HttpStatus getStatus(HttpServletRequest request) {
//        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
//        if (statusCode == null) {
//            return HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//        return HttpStatus.valueOf(statusCode);
//    }
//}