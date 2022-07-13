package com.woniuxy.smart_community.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.entity.*;
import com.woniuxy.smart_community.service.OwnersInfoService;
import com.woniuxy.smart_community.service.ParkingInfoService;
import com.woniuxy.smart_community.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 车位管理访问层
 * @Author LittleCode
 * @Date 2022/7/6 17:50
 */
@CrossOrigin
@RestController
public class ParkingInfoController {
    @Autowired
    ParkingInfoService parkingInfoService;
    @Autowired
    ParkingLotService parkingLotService;


    @PostMapping("/getParkingInfoByPage/{pageNum}/{pageSize}")
    public ResponseEntity<PageInfo<ParkingInfo>> getAllParkingInfoByPage(@PathVariable int pageNum,
                                                        @PathVariable int pageSize,
                                                        @RequestBody ParkingInfo parkingInfo){
        System.out.println("进入getParkingInfoByPage--parkingInfo="+parkingInfo);
        ResponseEntity<PageInfo<ParkingInfo>> responseEntity = null;
        System.out.println("分页查询:pageNum="+pageNum+"--pageSize="+pageSize+"---ParkingInfo="+parkingInfo);
        PageInfo<ParkingInfo> parkingInfoByPage = parkingInfoService.getParkingInfoByPage(pageNum, pageSize, parkingInfo);
        responseEntity=new ResponseEntity<>(200,"success", parkingInfoByPage);
        return responseEntity;
    }

    /**
     * 获取车位实时信息
     * 路径一：parking_lot表---使用中
     * 路径二：parking_info表
     * @return
     */
    @GetMapping("/getRealParkingInfo")
    public ResponseEntity<ParkingLot> getRealtimeParkingInfo(){
        ResponseEntity<ParkingLot> responseEntity=null;
        ParkingLot parkingLot = parkingLotService.getParkingLotById(1);
        System.out.println("查询出的停车场parkingLotById"+parkingLot);
        responseEntity=new ResponseEntity<ParkingLot>(200,"success",parkingLot);
        return responseEntity;
    }


    /**
     * 车位购买/租赁功能
     * @return
     */
    @PostMapping("buyParking")
    public ResponseEntity buyParkingBusiness(@RequestBody ParkingBusiness parkingBusiness){
        System.out.println("车位购买功能："+parkingBusiness);
        ResponseEntity responseEntity=null;
        parkingInfoService.addParkingInfoByParkingBusiness(parkingBusiness.getParkingInfo(), parkingBusiness.getParkingPrice(),parkingBusiness.getPayType(),parkingBusiness.getExpireTime());
        //交易完成---更新parkingLot表数据
        parkingLotService.changeParkingLot(parkingBusiness.getParkingInfo().getParkingLot());
        responseEntity=new ResponseEntity(200,"success",null);
        return responseEntity;
    }

    /**
     * 管理员添加车位
     * @param parkingInfo
     * @return
     */
    @PostMapping("/addParkingInfo")
    public ResponseEntity addParkingInfo(@RequestBody ParkingInfo parkingInfo){
        ResponseEntity responseEntity=null;
        System.out.println("添加车位："+parkingInfo);
        parkingInfoService.addParkingInfo(parkingInfo);
        responseEntity=new ResponseEntity(200,"success",null);
        return responseEntity;
    }


    /**
     * 删除车位信息
     * @param parkId
     * @return
     */
    @DeleteMapping("/deleteParkingInfoByParkId/{parkId}")
    public ResponseEntity delParkingInfoByParkId(@PathVariable("parkId") int parkId){
        ResponseEntity responseEntity=null;
        System.out.println("删除操作 parkId="+parkId);
        parkingInfoService.removeParkingInfoByParkId(parkId);
        responseEntity=new ResponseEntity(200,"success",null);
        return responseEntity;
    }

    /**
     * 管理员过更改车位基本信息
     * @param parkingInfo
     * @return
     */
    @PutMapping("/changeParkingInfo")
    public ResponseEntity changeParkingInfo(@RequestBody ParkingInfo parkingInfo){
        ResponseEntity responseEntity=null;
        parkingInfoService.changeParkingInfo(parkingInfo);
        System.out.println("更改车位信息："+parkingInfo);
        responseEntity=new ResponseEntity(200,"success",null);
        return responseEntity;
    }

}
