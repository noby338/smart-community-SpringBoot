package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

//----------停车场车位信息表
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParkingInfo {
    private int parkid;
    private String parkno;      //车位编号 5位

    private int parklotid;
    private ParkingLot parkingLot; //外键 关联停车场信息列表

    private BigDecimal parkarea;    //车位面积

    private int ptypeid;        //外键
    private ParkingType parkingType;    //外键 关联车位状态表

    private int owid;               //外键 关联车位所有人信息表
    private OwnersInfo ownersInfo;
}
