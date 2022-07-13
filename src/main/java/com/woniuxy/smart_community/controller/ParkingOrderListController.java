package com.woniuxy.smart_community.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.entity.ParkingOrderList;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.ParkingOrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author LittleCode
 * @Date 2022/7/11 16:22
 */
@CrossOrigin
@RestController
public class ParkingOrderListController {
    @Autowired
    ParkingOrderListService parkingOrderListService;

    /**
     * 分页查询订单
     * @param pageNum
     * @param pageSize
     * @param parkingOrderList
     * @return
     */
    @PostMapping("/getParkingOrderListByPage/{pageNum}/{pageSize}")
    public ResponseEntity<PageInfo<ParkingOrderList>> getParkingOrderListByPage(@PathVariable int pageNum,
                                                                                @PathVariable int pageSize,
                                                                                @RequestBody ParkingOrderList parkingOrderList){
        System.out.println("订单分页查询 parkingOrderList="+parkingOrderList);
        ResponseEntity<PageInfo<ParkingOrderList>> responseEntity=null;
        PageInfo<ParkingOrderList> parkingOrderListByPage = parkingOrderListService.getParkingOrderListByPage(pageNum, pageSize, parkingOrderList);
        responseEntity=new ResponseEntity<>(200,"success",parkingOrderListByPage);
        return responseEntity;
    }


    /**
     * 更改编辑订单信息
     * @param parkingOrderList
     * @return
     */
    @PutMapping("/setParkingOrder")
    public ResponseEntity changeParkingOrderInfo(@RequestBody ParkingOrderList parkingOrderList){
        System.out.println("更改订单表信息"+parkingOrderList);
        ResponseEntity responseEntity=null;
        parkingOrderListService.changeParkingOrderByOrder(parkingOrderList);
        responseEntity=new ResponseEntity(200,"success", null);
        return responseEntity;
    }

    /**
     * 假删除，变更订单状态
     * @param orderId
     * @return
     */
    @DeleteMapping("/deleteParkingOrderState/{orderId}")
    public ResponseEntity deleteParkingOrderByState(@PathVariable  int orderId){
        System.out.println("删除订单表(更改状态) orderId="+orderId);
        ResponseEntity responseEntity=null;
        parkingOrderListService.changeParkingOrderByState(orderId,null);
        responseEntity=new ResponseEntity(200,"success", null);
        return responseEntity;
    }

    /**
     * 真删除
     * @param orderId
     * @return
     */
    @DeleteMapping("/deleteParkingOrder/{orderId}")
    public ResponseEntity deleteParkingOrder(@PathVariable  int orderId){
        System.out.println("删除订单表(更改状态) orderId="+orderId);
        ResponseEntity responseEntity=null;
        parkingOrderListService.removeParkingOrderInfo(orderId,null);
        responseEntity=new ResponseEntity(200,"success", null);
        return responseEntity;
    }
}
