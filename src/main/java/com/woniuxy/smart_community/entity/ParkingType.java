package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//----------停车场车位状态信息表
//1.自购
//2.租用
//3.自由
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParkingType {
    private Integer ptypeid;
    private String ptype;
}
