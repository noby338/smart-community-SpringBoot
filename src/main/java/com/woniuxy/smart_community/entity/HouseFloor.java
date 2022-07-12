package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description
 * @Author noby
 * @Date 2022/7/8 17:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseFloor {
    private Integer id;
    private String name;
    private Integer unitId;
    private List<House> houseList;
}
