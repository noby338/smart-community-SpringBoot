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
    private Integer id;
    //车位编号 10位
    //A1234
    //B1231
    private String parkNumber;

    //外键 关联停车场信息列表
    private ParkingLot parkingLot;

    //车位面积
    private BigDecimal parkArea;

    //外键 关联车位状态表
    private ParkingType parkingType;
    //外键 关联车位所有人信息表
    private OwnersInfo ownersInfo;
}
