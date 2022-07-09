package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @Author: LittleCode
 * @Date:   2022/7/6
 * @Descrition: 停车场车辆信息
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Alias("CarInfo")
public class CarInfo {
    private Integer id;
    private String carNumber;   //车牌号 8位
    private String carJpg;  //照片 路径

    //外键 关联车位信息
    private ParkingInfo parkingInfo;

    //外键 关联车主信息
    private OwnersInfo ownersInfo;

    //车辆状态  0：失效  1：有效
    private Integer state;
}
