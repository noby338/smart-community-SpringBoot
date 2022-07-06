package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.PropertyUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (PropertyUser)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-06 10:20:02
 */
public interface PropertyUserDao {


    List findAll();
}

