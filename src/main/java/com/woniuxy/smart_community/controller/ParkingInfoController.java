package com.woniuxy.smart_community.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.entity.ParkingInfo;
import com.woniuxy.smart_community.entity.ParkingLot;
import com.woniuxy.smart_community.entity.ResponseEntity;
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
     * 车位购买功能
     * @return
     */
    @PostMapping("buyParking")
    public ResponseEntity buyParkingBusiness(){
        return null;
    }

    /**
     * 变更车位所有人信息
     * 变更前判断车位状态是否不为自由状态
     * @return
     */

    public ResponseEntity changeParkingInfoByOwnersInfo(){
        return null;
    }


    /**
     *
     * @return
     */

    public ResponseEntity changeParkingInfo(){
        return null;
    }


}
