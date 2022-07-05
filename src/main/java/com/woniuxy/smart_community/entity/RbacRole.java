package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (RbacRole)实体类
 *
 * @author makejava
 * @since 2022-07-04 14:57:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RbacRole implements Serializable {
    private static final long serialVersionUID = -95406279781393762L;
    
    private Integer id;
    
    private String name;
    
    private String description;
    
    private String status;

}

