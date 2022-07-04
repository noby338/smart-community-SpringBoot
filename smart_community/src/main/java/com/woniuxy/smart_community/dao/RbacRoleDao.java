package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.RbacRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (RbacRole)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-04 14:57:40
 */
public interface RbacRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RbacRole queryById(Integer id);


    /**
     * 统计总行数
     *
     * @param rbacRole 查询条件
     * @return 总行数
     */
    long count(RbacRole rbacRole);

    /**
     * 新增数据
     *
     * @param rbacRole 实例对象
     * @return 影响行数
     */
    int insert(RbacRole rbacRole);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<RbacRole> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<RbacRole> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<RbacRole> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<RbacRole> entities);

    /**
     * 修改数据
     *
     * @param rbacRole 实例对象
     * @return 影响行数
     */
    int update(RbacRole rbacRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

