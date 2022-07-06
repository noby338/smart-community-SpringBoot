package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LittleCode
 * @Date:   2022/7/6
 * @Descrition: 停车场车辆信息
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarInfo {
    private Integer carId;
    private String carNo;   //车牌号 8位
    private String carJpg;  //照片 路径

    private Integer parkId;     //外键 关联车位信息
    private ParkingInfo parkingInfo;

    private Integer owId;       //外键 关联车主信息
    private OwnersInfo ownersInfo;

    private Integer carState;      //车辆状态  0：失效  1：有效
}
