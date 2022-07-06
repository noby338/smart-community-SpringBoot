package com.woniuxy.smart_community.service.impl;/**
 * @description: TODO
 * @author 李佳复
 * @date 2022/7/6 10:46
 * @version 1.0
 */

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
    public ResponseEntity findAll() {
       return new ResponseEntity(200,"查询成功", propertyUserDao.findAll());

    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}
