package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

//停车场车辆信息
@NoArgsConstructor
@AllArgsConstructor
@Data
@Alias("CarInfo")
public class CarInfo {
    private Integer carid;
    private String carno;   //车牌号 8位
    private String carjpg;  //照片 路径

    private int parkid;     //外键 关联车位信息
    private ParkingInfo parkingInfo;

    private int owid;       //外键 关联车主信息
    private OwnersInfo ownersInfo;

    private int state;      //车辆状态  0：失效  1：有效
}
