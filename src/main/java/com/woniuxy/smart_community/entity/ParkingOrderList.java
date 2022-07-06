package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
/**
 * @Author: LittleCode
 * @Date:   2022/7/6
 * @Descrition: 车位交易订单信息表
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParkingOrderList {
    private Integer orderId;
    private String orderNo;     //  订单编号

    private Integer parkId;     //外键  关联订单交易中的车位信息
    private ParkingInfo parkingInfo;

    private Date orderTime;     //下单时间
    private Date orderEndTime;
    private BigDecimal orderCost;       //订单金额

    private Integer owId;       //外键 关联用户信息
    private OwnersInfo ownersInfo;

    private Integer pTypeId;        //外键  关联订单类型  1购买车位 2 租用车位
    private ParkingType parkingType;

    private String payType;     //支付方式
    private Integer orderState;     // 订单状态  0订单失效，历史订单  1订单有效
    private String ordeRemark;  // 备注
}
