package com.woniuxy.smart_community.controller;

import com.github.pagehelper.Page;
import com.woniuxy.smart_community.entity.RbacRole;
import com.woniuxy.smart_community.service.RbacRoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RbacRole)表控制层
 *
 * @author makejava
 * @since 2022-07-04 14:57:40
 */
@RestController
@RequestMapping("rbacRole")
public class RbacRoleController {
    /**
     * 服务对象
     */
    @Resource
    private RbacRoleService rbacRoleService;


}

