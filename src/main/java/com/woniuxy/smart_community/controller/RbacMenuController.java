package com.woniuxy.smart_community.controller;

import com.github.pagehelper.Page;
import com.woniuxy.smart_community.entity.PropertyUser;
import com.woniuxy.smart_community.entity.RbacMenu;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.RbacMenuService;
import org.springframework.beans.factory.annotation.Autowired;
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

            @Autowired

    private RbacMenuService rbacMenuService;
            @PostMapping("/findAllMenu")
    public ResponseEntity findAllMenu(@RequestBody PropertyUser propertyUser){
        return rbacMenuService.findAllMenu(propertyUser);
    }

}

