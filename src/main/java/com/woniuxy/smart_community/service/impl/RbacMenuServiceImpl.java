package com.woniuxy.smart_community.service.impl;/**
 * @description: TODO
 * @author 李佳复
 * @date 2022/7/11 10:32
 * @version 1.0
 */

import com.woniuxy.smart_community.dao.RbacMenuDao;
import com.woniuxy.smart_community.entity.PropertyUser;
import com.woniuxy.smart_community.entity.RbacMenu;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.RbacMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 李佳复  <br/>
 * Date: 2022/7/11:10:32  <br/>
 * Description:
 */
@Service
public class RbacMenuServiceImpl implements RbacMenuService {
    @Autowired(required = false)
    RbacMenuDao rbacMenuDao;
    @Override
    public ResponseEntity findAllMenu(PropertyUser propertyUser) {
        List allFMenu = rbacMenuDao.findAllFMenu(propertyUser);
        System.out.println(propertyUser);
        if (allFMenu!=null){
        for (int i = 0; i < allFMenu.size(); i++) {
            Object o = allFMenu.get(i);
            RbacMenu rbacMenu=(RbacMenu)o;
            List<RbacMenu> allSMenu = rbacMenuDao.findAllSMenu(propertyUser.getLoginName(), rbacMenu.getId());
            rbacMenu.setChildMenu(allSMenu);
        }
        return new ResponseEntity (200,"查询成功",allFMenu);
    }else {
            return new ResponseEntity (200,"查询失败",null);
        }
    }

//    @Override
//    public List<RbacMenu> findAllSMenu(PropertyUser propertyUser) {
//        return rbacMenuDao.findAllSMenu(propertyUser);
//    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}
