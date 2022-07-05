package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (RbacMenu)实体类
 *
 * @author makejava
 * @since 2022-07-04 14:57:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RbacMenu implements Serializable {
    private static final long serialVersionUID = 420720355501791756L;
    
    private Integer id;
    
    private String icon;
    
    private String menuname;
    
    private String url;
    
    private Integer fid;



}

