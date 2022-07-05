package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

//----------车位交易订单信息表
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParkingOrderList {
    private Integer orderid;
    private String orderno;     //  订单编号

    private int parkid;     //外键  关联订单交易中的车位信息
    private ParkingInfo parkingInfo;

    private Date ordertime;     //下单时间
    private Date orderendtime;
    private BigDecimal ordercost;       //订单金额

    private int owid;       //外键 关联用户信息
    private OwnersInfo ownersInfo;

    private int ptypeid;        //外键  关联订单类型  1购买车位 2 租用车位
    private ParkingType parkingType;

    private String paytype;     //支付方式
    private int orderstate;     // 订单状态  0订单失效，历史订单  1订单有效
    private String orderemark;  // 备注
}
