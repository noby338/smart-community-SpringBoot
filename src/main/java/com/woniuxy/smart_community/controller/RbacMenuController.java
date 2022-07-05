package com.woniuxy.smart_community.controller;

import com.github.pagehelper.Page;
import com.woniuxy.smart_community.entity.RbacMenu;
import com.woniuxy.smart_community.service.RbacMenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RbacMenu)表控制层
 *
 * @author makejava
 * @since 2022-07-04 14:57:40
 */
@RestController
@RequestMapping("rbacMenu")
public class RbacMenuController {
    /**
     * 服务对象
     */
//    @Resource
    private RbacMenuService rbacMenuService;


}

