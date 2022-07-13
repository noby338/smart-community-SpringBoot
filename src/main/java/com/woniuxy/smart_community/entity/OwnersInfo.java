package com.woniuxy.smart_community.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @Author: LittleCode
 * @Date:   2022/7/6
 * @Descrition: 停车场管理业主信息
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OwnersInfo {
    private Integer id;
    private String name;
    private String telephone;
    //外键对应房间
    private House house;
    //人员状态 0注销 1车主(非业主) 2车主(业主)
    private Integer state;
}
