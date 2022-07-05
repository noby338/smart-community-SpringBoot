package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.RbacMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (RbacMenu)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-04 14:57:40
 */
public interface RbacMenuDao {



    /**
     * 统计总行数
     *
     * @param rbacMenu 查询条件
     * @return 总行数
     */
    long count(RbacMenu rbacMenu);

    /**
     * 新增数据
     *
     * @param rbacMenu 实例对象
     * @return 影响行数
     */
    int insert(RbacMenu rbacMenu);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<RbacMenu> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<RbacMenu> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<RbacMenu> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<RbacMenu> entities);

    /**
     * 修改数据
     *
     * @param rbacMenu 实例对象
     * @return 影响行数
     */
    int update(RbacMenu rbacMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

