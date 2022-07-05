package com.woniuxy.smart_community.controller;

import com.woniuxy.smart_community.entity.RbacManager;
import com.woniuxy.smart_community.service.RbacManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RbacManager)表控制层
 *
 * @author makejava
 * @since 2022-07-04 14:57:37
 */
@RestController
@RequestMapping("rbacManager")
public class RbacManagerController {
    /**
     * 服务对象
     */
//    @Resource
    private RbacManagerService rbacManagerService;



}

