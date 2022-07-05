package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//----------多个停车场管理信息表
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParkingLot {
    private Integer id;
    private String parking_lot_name;  //停车场名
    private int park_nums;       //车位总数
    private int sell_park_nums;   //已售车位数量
    private int hire_park_nums;     //已租车位数量
    private int now_use_nums;       //当前使用数量
    private int state;              //停车场状态 0暂停使用 1使用中
}
