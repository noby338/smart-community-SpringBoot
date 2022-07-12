package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author :  Fiver_Hu
 * @Date : 2022/7/12 17:05 星期二
 * @Project_Name -> smart-community
 * @Package_Name -> com.woniuxy.smart_community.entity
 * @ClassName -> ForSelect
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForSelect {
    private Integer value;
    private String label;
    private boolean disabled;
}
