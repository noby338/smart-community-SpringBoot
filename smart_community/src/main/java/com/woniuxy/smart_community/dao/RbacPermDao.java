package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.RbacPerm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (RbacPerm)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-04 14:57:40
 */
public interface RbacPermDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RbacPerm queryById(Integer id);


    /**
     * 统计总行数
     *
     * @param rbacPerm 查询条件
     * @return 总行数
     */
    long count(RbacPerm rbacPerm);

    /**
     * 新增数据
     *
     * @param rbacPerm 实例对象
     * @return 影响行数
     */
    int insert(RbacPerm rbacPerm);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<RbacPerm> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<RbacPerm> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<RbacPerm> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<RbacPerm> entities);

    /**
     * 修改数据
     *
     * @param rbacPerm 实例对象
     * @return 影响行数
     */
    int update(RbacPerm rbacPerm);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

