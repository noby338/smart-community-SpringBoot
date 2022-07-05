package com.woniuxy.smart_community.controller;

import com.woniuxy.smart_community.service.RbacManagerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

