package com.woniuxy.smart_community.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.entity.ParkingOrderList;

/**
 * @Description
 * @Author LittleCode
 * @Date 2022/7/11 20:07
 */
public interface ParkingOrderListService {

    PageInfo<ParkingOrderList> getParkingOrderListByPage(int pageNum,int pageSize,ParkingOrderList parkingOrderList);

    void changeParkingOrderByState(int orderId ,String orderNo);

    void changeParkingOrderByOrder(ParkingOrderList parkingOrderList);

    void removeParkingOrderInfo(int orderId,String orderNo);

    void orderExpirationCheck();
}
