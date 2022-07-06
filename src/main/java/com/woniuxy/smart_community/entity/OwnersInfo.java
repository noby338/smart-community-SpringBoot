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
    private Integer owId;
    private String owName;
    private String owPhone;
    private String owType;  //人员状态

    private Integer id;//外键 关联住址
    private House house;
}
