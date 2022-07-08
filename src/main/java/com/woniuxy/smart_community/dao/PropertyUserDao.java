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
/*/*
 * Description : TODO  <br/>
 * ChangeLog : 1. 创建 (2022/7/6 11:22 [58369]);
 ** @param null
 * *  @return 所有账号
*/


    List<PropertyUser> findAll();

    boolean update(PropertyUser propertyUser);

    boolean insert(PropertyUser propertyUser);

    boolean deleteByLoginName(String loginName);
}

