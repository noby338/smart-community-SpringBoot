package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (PropertyUser)实体类
 *
 * @author makejava
 * @since 2022-07-06 10:18:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyUser implements Serializable {
    private static final long serialVersionUID = 722980034706566798L;
    
    private Integer id;

    private String loginName;
    
    private String password;
    
    private String name;
    
    private Integer age;
    
    private Integer gender;
    
    private String tellphone;
    
    private Integer state;

    private String rname;

private String token;

}

