package com.woniuxy.smart_community.controller;

import com.github.pagehelper.Page;
import com.woniuxy.smart_community.entity.RbacPerm;
import com.woniuxy.smart_community.service.RbacPermService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RbacPerm)表控制层
 *
 * @author makejava
 * @since 2022-07-04 14:57:40
 */
@RestController
@RequestMapping("rbacPerm")
public class RbacPermController {
    /**
     * 服务对象
     */
    @Resource
    private RbacPermService rbacPermService;


}

