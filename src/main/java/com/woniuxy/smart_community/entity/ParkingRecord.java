package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

//----------停车场中车辆进出记录表
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParkingRecord {
    private Integer precordid;
    private String precordno;       //进出记录编号  32位
    private String carno;           //车牌号

    private int carid;              //外键 关联车辆信息
    private CarInfo carInfo;

    private int owid;               //外键  关联车主信息
    private OwnersInfo ownersInfo;

    private Date pintime;
    private Date poutime;

    private BigDecimal pcost;       //费用价格
    private String paytype;         //支付方式  后台编写分类
}
