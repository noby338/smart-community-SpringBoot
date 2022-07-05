package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.RbacManager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (RbacManager)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-04 14:57:39
 */
public interface RbacManagerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RbacManager queryById(Integer id);


    /**
     * 统计总行数
     *
     * @param rbacManager 查询条件
     * @return 总行数
     */
    long count(RbacManager rbacManager);

    /**
     * 新增数据
     *
     * @param rbacManager 实例对象
     * @return 影响行数
     */
    int insert(RbacManager rbacManager);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<RbacManager> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<RbacManager> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<RbacManager> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<RbacManager> entities);

    /**
     * 修改数据
     *
     * @param rbacManager 实例对象
     * @return 影响行数
     */
    int update(RbacManager rbacManager);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

