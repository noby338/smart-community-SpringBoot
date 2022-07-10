package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 车位购买的请求接收实体类
 * @Author LittleCode
 * @Date 2022/7/9 17:56
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParkingBusiness {
    private ParkingInfo parkingInfo;
    private String payType;
    private String parkingPrice;
    private Integer expireTime;
}
