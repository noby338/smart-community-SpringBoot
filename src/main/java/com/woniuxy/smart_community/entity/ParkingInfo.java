package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
/**
 * @Author: LittleCode
 * @Date:   2022/7/6
 * @Descrition: 停车场车位信息表
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParkingInfo {
    private Integer parkId;
    private String parkNo;      //车位编号 5位

    private Integer parkLotId;
    private ParkingLot parkingLot; //外键 关联停车场信息列表

    private BigDecimal parkArea;    //车位面积

    private Integer pTypeId;        //外键
    private ParkingType parkingType;    //外键 关联车位状态表

    private Integer owId;               //外键 关联车位所有人信息表
    private OwnersInfo ownersInfo;
}
