package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.PropertyUser;
import com.woniuxy.smart_community.entity.RbacMenu;
import com.woniuxy.smart_community.entity.RbacPerm;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

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


    List<PropertyUser> findAll(int state);

    boolean update(PropertyUser propertyUser);

    boolean insert(PropertyUser propertyUser);

    boolean deleteByLoginName(String loginName);

    PropertyUser login(PropertyUser propertyUser);

    String findPassword(String loginName);

    Set<String> findAllRoles(String username);

    Set<String> findAllPerms( String username);

    Set<RbacPerm> findOtherByLoginName(String loginName);

    Set<RbacPerm> allRoles();

    int findrolesByName(String role);

    int updatePerm(@Param("roleId") int roleId,@Param("userId") int userId);

    void deleteByUserId(int userId);
}

