package com.woniuxy.smart_community.controller;

import com.woniuxy.smart_community.entity.PropertyUser;
import com.woniuxy.smart_community.entity.RbacPerm;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.PropertyUserService;
import lombok.experimental.Accessors;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * (RbacManager)表控制层
 *
 * @author makejava
 * @since 2022-07-04 14:57:37
 */
@RestController
@RequestMapping("/user")
//@CrossOrigin
//@RequiresAuthentication
public class PropertyUserController {
    /**
     * 服务对象
     */
    @Autowired
    private PropertyUserService propertyUserService;
@RequestMapping("/findAll/{currentPage}/{pageSize}/{state}")
    public ResponseEntity findAll(@PathVariable("state") int state,@PathVariable("currentPage") int currentPage,@PathVariable("pageSize") int pageSize) {

       return propertyUserService.findAll(state,currentPage, pageSize);
    }
    @RequiresPermissions("role_manage")
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
@RequestMapping("/findOther/{loginName}")
public ResponseEntity findOtherByLoginName(@PathVariable String loginName){
    return propertyUserService.findOtherByLoginName(loginName);
}
@GetMapping("/allRoles")
    public ResponseEntity allRoles(){
    return propertyUserService.allRoles();
}
@PutMapping("/updateperm/{userId}/{loginName}")
    public ResponseEntity updatePerm(@PathVariable("userId") int userId,@PathVariable("loginName") String loginName,@RequestBody String[] perms){
   return propertyUserService.updatePerm(userId,loginName,perms);
}
}

