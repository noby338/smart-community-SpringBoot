package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.ParkingOrderList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author LittleCode
 * @Date 2022/7/7 23:15
 */
@Mapper
public interface ParkingOrderListDao {
    List<ParkingOrderList> selectParkingOrderListByOrderInfo(
            @Param("parkingOrder")ParkingOrderList parkingOrder);

    int selectParkingOrderListNums(@Param("parkingOrder")ParkingOrderList parkingOrder);

    void insertParkingOrderInfo(@Param("parkingOrder")ParkingOrderList parkingOrder);

    void updateParkingOrderState(@Param("orderState") int orderState,
                                 @Param("orderId") int orderId,
                                 @Param("orderNo") String orderNo);

    void updateParkingOrderInfoByRemark(@Param("ordeRemark") String ordeRemark,
                                @Param("orderId") int orderId,
                                @Param("orderNo") String orderNo);

    void deleteParkingOrderInfoByOrder(@Param("orderId") int orderId,
                                       @Param("orderNo") String orderNo);
}
