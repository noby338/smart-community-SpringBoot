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
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.PropertyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ResponseEntity findAll(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<PropertyUser> all = propertyUserDao.findAll();
        PageInfo<PropertyUser> of=PageInfo.of(all);
        if(all.size()>0) {
            return new ResponseEntity(200, "查询成功", of);
        }else {
            return new ResponseEntity(200, "查询失败", null);
        }
    }

    @Override
    public ResponseEntity update(PropertyUser propertyUser) {
        boolean update = propertyUserDao.update(propertyUser);
        if(update) {
            return new ResponseEntity(200, "修改成功", null);
        }else {
            return new ResponseEntity(200, "修改失败", null);
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
            return new ResponseEntity(200, "修改成功", null);
        }else {
            return new ResponseEntity(200, "修改失败", null);
        }
    }

    @Override
    public ResponseEntity deleteByLoginName(String loginName) {
        boolean delete= propertyUserDao.deleteByLoginName(loginName);
        if(delete) {
            return new ResponseEntity(200, "删除成功", null);
        }else {
            return new ResponseEntity(200, "删除失败", null);
        }
    }
}
