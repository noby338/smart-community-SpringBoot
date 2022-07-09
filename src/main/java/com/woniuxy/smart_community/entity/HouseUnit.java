package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author noby
 * @Date 2022/7/8 18:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseUnit {
    private Integer id;
    private String name;
    private Integer buildingId;
}
