package com.woniuxy.smart_community.controller;

import com.woniuxy.smart_community.entity.PropertyUser;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.PropertyUserService;
import lombok.experimental.Accessors;
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
@RequestMapping("/user")
@CrossOrigin
public class PropertyUserController {
    /**
     * 服务对象
     */
    @Autowired
    private PropertyUserService propertyUserService;
@RequestMapping("/findAll/{currentPage}/{pageSize}")
    public ResponseEntity findAll(@PathVariable("currentPage") int currentPage,@PathVariable("pageSize") int pageSize) {

       return propertyUserService.findAll(currentPage, pageSize);
    }
@RequestMapping("/update")
    public ResponseEntity update(@RequestBody PropertyUser propertyUser){
    return propertyUserService.update(propertyUser);
}
@RequestMapping("/insert")
    public ResponseEntity insert(@RequestBody PropertyUser propertyUser){
    return propertyUserService.insert(propertyUser);
}
@DeleteMapping("/delete/{loginName}")
    public ResponseEntity deleteByLoginName(@PathVariable String loginName){
return propertyUserService.deleteByLoginName(loginName);
}

}

