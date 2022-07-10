package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @Author: LittleCode
 * @Date:   2022/7/6
 * @Descrition: 多个停车场管理信息表
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParkingLot {
    private Integer id;
    private String name;  //停车场名
    private Integer parkNums;           //车位总数
    private Integer sellParkNums;   //已售车位数量
    private Integer hireParkNums;     //已租车位数量
    private Integer nowUseNums;       //当前使用数量
    private Integer state;              //停车场状态 0暂停使用 1使用中
}
