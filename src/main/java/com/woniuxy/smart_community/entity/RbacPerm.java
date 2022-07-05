package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (RbacPerm)实体类
 *
 * @author makejava
 * @since 2022-07-04 14:57:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RbacPerm implements Serializable {
    private static final long serialVersionUID = 969141580443477519L;
    
    private Integer id;
    
    private String name;
    
    private String code;
    
    private String link;
    
    private Integer parentId;
    
    private String type;
    
    private String status;


}

