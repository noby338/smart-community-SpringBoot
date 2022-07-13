package com.woniuxy.smart_community.service.impl;/**
 * @description: TODO
 * @author 李佳复
 * @date 2022/7/6 10:46
 * @version 1.0
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.dao.PropertyUserDao;
import com.woniuxy.smart_community.entity.PropertyUser;
import com.woniuxy.smart_community.entity.RbacPerm;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.PropertyUserService;
import com.woniuxy.smart_community.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author: &#x674E;&#x4F73;&#x590D;  <br/>
 * Date: 2022/7/6:10:46  <br/>
 * Description:
 */
@Service
public class PropertyUserServiceImpl implements PropertyUserService {
    @Autowired(required = false)
    PropertyUserDao propertyUserDao;
    @Override
    public ResponseEntity findAll(int state, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<PropertyUser> all = propertyUserDao.findAll(state);
        PageInfo<PropertyUser> of=PageInfo.of(all);
        if(all.size()>0) {
            return new ResponseEntity(200, "查询成功", of);
        }else {
            return new ResponseEntity(500, "查询失败", null);
        }
    }

    @Override
    public ResponseEntity update(PropertyUser propertyUser) {
        boolean update = propertyUserDao.update(propertyUser);
        if(update) {
            return new ResponseEntity(200, "修改成功", null);
        }else {
            return new ResponseEntity(500, "修改失败", null);
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public ResponseEntity insert(PropertyUser propertyUser) {
        boolean update = propertyUserDao.insert(propertyUser);
        if(update) {
            return new ResponseEntity(200, "添加成功", null);
        }else {
            return new ResponseEntity(500, "添加失败", null);
        }
    }

    @Override
    public ResponseEntity deleteByLoginName(String loginName) {
        boolean delete= propertyUserDao.deleteByLoginName(loginName);
        if(delete) {
            return new ResponseEntity(200, "删除成功", null);
        }else {
            return new ResponseEntity(500, "删除失败", null);
        }
    }

    @Override
    public ResponseEntity login(PropertyUser propertyUser) {
        PropertyUser login= propertyUserDao.login(propertyUser);

        if(login!=null) {
            String token= JWTUtil.sign(propertyUser.getLoginName(),propertyUser.getPassword());
            login.setToken(token);
            return new ResponseEntity(200, "登录成功", login);
        }else {
            return new ResponseEntity(500, "登录失败", null);
        }
    }

    @Override
    public String findPassword(String loginName) {
        return propertyUserDao.findPassword(loginName);
    }

    @Override
    public Set<String> findAllRoles(String username) {
        return propertyUserDao.findAllRoles(username);
    }

    @Override
    public Set<String> findAllPerms(String username) {
        return propertyUserDao.findAllPerms(username);
    }

    @Override
    public ResponseEntity findOtherByLoginName(String loginName) {
       Set set= propertyUserDao.findOtherByLoginName(loginName);
        if(set.size()!=0) {
            return new ResponseEntity(200, "查询成功", set);
        }else {
            return new ResponseEntity(500, "查询失败", null);
        }
    }

    @Override
    public ResponseEntity allRoles() {
        Set<RbacPerm> roles = propertyUserDao.allRoles();
        if(roles.size()!=0) {
            return new ResponseEntity(200, "查询成功", roles);
        }else {
            return new ResponseEntity(500, "查询失败", null);
        }
    }

    @Override
    public ResponseEntity updatePerm(int userId,String loginName, String[] perms) {

        propertyUserDao.deleteByUserId(userId);
        int i=0;
        for (String perm: perms) {
            Set<RbacPerm> otherByLoginName = propertyUserDao.findOtherByLoginName(loginName);
            int roleId = propertyUserDao.findrolesByName(perm);
             i += propertyUserDao.updatePerm(roleId,userId);
        }
        if(i==perms.length) {
            return new ResponseEntity(200, "查询成功", null);
        }else {
            return new ResponseEntity(500, "查询失败", null);
        }
    }

}
