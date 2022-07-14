package com.woniuxy.smart_community.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.dao.OwnerInfoDao;
import com.woniuxy.smart_community.dao.ParkingInfoDao;
import com.woniuxy.smart_community.dao.ParkingOrderListDao;
import com.woniuxy.smart_community.entity.ParkingOrderList;
import com.woniuxy.smart_community.service.ParkingOrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author LittleCode
 * @Date 2022/7/11 20:07
 */
@Service
public class ParkingOrderListServiceImpl implements ParkingOrderListService {
    @Autowired
    ParkingOrderListDao parkingOrderListDao;
    @Autowired
    OwnerInfoDao ownerInfoDao;
    @Autowired
    ParkingInfoDao parkingInfoDao;

    @Override
    public PageInfo<ParkingOrderList> getParkingOrderListByPage(int pageNum,int pageSize,ParkingOrderList parkingOrderList) {
        System.out.println("分页查询订单："+parkingOrderList);
        PageHelper.startPage(pageNum,pageSize);
        List<ParkingOrderList> parkingOrderLists = parkingOrderListDao.selectParkingOrderListByOrderInfo(parkingOrderList);
        PageInfo<ParkingOrderList> pageInfo = new PageInfo<>(parkingOrderLists);
        //将单独查询的总条数赋值给parkingOrderLists
        int total = parkingOrderListDao.selectParkingOrderListNums(parkingOrderList);
        pageInfo.setTotal(total);
        return pageInfo;
    }

    /**
     * 假删除--更改订单状态
     * @param orderId
     */
    @Override
    public void changeParkingOrderByState(int orderId,String orderNo) {
        parkingOrderListDao.updateParkingOrderState(0,orderId,orderNo );
    }

    /**
     * 订单信息更改
     * @param parkingOrderList
     */
    @Override
    public void changeParkingOrderByOrder(ParkingOrderList parkingOrderList) {
        if(parkingOrderList.getOwnersInfo()!=null){
            ownerInfoDao.updateOwnerByOwnerInfo(parkingOrderList.getOwnersInfo());
        }
        parkingOrderListDao.updateParkingOrderInfoByRemark(parkingOrderList.getOrdeRemark(),parkingOrderList.getOrderId(),parkingOrderList.getOrderNo());
    }

    /**
     * 真删除
     * @param orderId
     * @param orderNo
     */
    @Override
    public void removeParkingOrderInfo(int orderId, String orderNo) {
        parkingOrderListDao.deleteParkingOrderInfoByOrder(orderId,orderNo);
    }

    /**
     * 项目启动后每一分钟启动一次--启动了添加配置@EnableScheduling
     */
    @Override
    public void orderExpirationCheck(){
        //System.out.println("启动检查");
        ParkingOrderList ParkingOrderList=new ParkingOrderList();
        //查询过期的信息
        ParkingOrderList.setOrderState(1);
        ParkingOrderList.setOrderEndTime(new Date());
        List<ParkingOrderList> parkingOrderLists = parkingOrderListDao.selectParkingOrderListByOrderInfo(ParkingOrderList);
        System.out.println("查询的过期信息："+parkingOrderLists);
        if(parkingOrderLists.isEmpty()){
            //无过期未改状态信息
            System.out.println("无过期未改状态信息");
            return;
        }
        for(ParkingOrderList parkingOrder:parkingOrderLists){
            parkingOrderListDao.updateParkingOrderState(0,parkingOrder.getOrderId(),parkingOrder.getOrderNo());
        }
    }
}
