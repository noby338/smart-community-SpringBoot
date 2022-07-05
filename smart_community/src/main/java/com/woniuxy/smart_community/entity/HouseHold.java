package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName -> HouseHold
 * @Author Fiver_Hu
 * @Date 2022/7/5 9:45 星期二
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor

public class HouseHold {
    private Integer id;
    private String name;
    private Integer age;
    private boolean gender;
    private String telephone;
    private Integer house_id;
    private boolean is_owner;
    private Integer state;
}
