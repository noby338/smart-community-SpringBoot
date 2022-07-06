package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
/**
 * @Author: LittleCode
 * @Date:   2022/7/6
 * @Descrition: 停车场中车辆进出记录表
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParkingRecord {
    private Integer pRecordId;
    private String pRecordNo;       //进出记录编号  32位
    private String carNo;           //车牌号

    private Integer carId;              //外键 关联车辆信息
    private CarInfo carInfo;

    private Integer owId;               //外键  关联车主信息
    private OwnersInfo ownersInfo;

    private Date pIntime;
    private Date pOutime;

    private BigDecimal pCost;       //费用价格
    private String payType;         //支付方式  后台编写分类
}
