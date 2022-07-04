package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (RbacManager)实体类
 *
 * @author makejava
 * @since 2022-07-04 14:57:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RbacManager implements Serializable {
    private static final long serialVersionUID = -45311291184195475L;
    
    private Integer id;
    
    private String account;
    
    private String password;
    
    private String status;
    
    private Integer roleId;
    /**
     * 角色集合
     */
    private String roles;



}

