package com.woniuxy.smart_community.service;

/**
 * (RbacMenu)表服务接口
 *
 * @author makejava
 * @since 2022-07-04 14:57:40
 */
public interface RbacMenuService {


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
