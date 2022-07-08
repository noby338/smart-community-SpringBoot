package com.woniuxy.smart_community.service;

import com.woniuxy.smart_community.entity.PropertyUser;
import com.woniuxy.smart_community.entity.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * (RbacManager)表服务接口
 *
 * @author makejava
 * @since 2022-07-04 14:57:39
 */
public interface PropertyUserService {

    ResponseEntity findAll(int currentPage,int pageSize);
    //修改
    ResponseEntity update(PropertyUser propertyUser);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    ResponseEntity insert(PropertyUser propertyUser);

    ResponseEntity deleteByLoginName(String loginName);
}
