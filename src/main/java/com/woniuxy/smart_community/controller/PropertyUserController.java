package com.woniuxy.smart_community.controller;

import com.woniuxy.smart_community.entity.PropertyUser;
import com.woniuxy.smart_community.entity.RbacManager;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.PropertyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RbacManager)表控制层
 *
 * @author makejava
 * @since 2022-07-04 14:57:37
 */
@RestController
@RequestMapping("/User")
public class PropertyUserController {
    /**
     * 服务对象
     */
    @Autowired
    private PropertyUserService propertyUserService;

    public ResponseEntity findAll() {

       return propertyUserService.findAll();
    }


}

