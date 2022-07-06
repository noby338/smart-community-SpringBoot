package com.woniuxy.smart_community.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.entity.ParkingInfo;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.ParkingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 车位管理访问层
 * @Author LittleCode
 * @Date 2022/7/6 17:50
 */
@RestController
public class ParkingInfoController {
    @Autowired
    ParkingInfoService parkingInfoService;

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

    @PostMapping("buyParking")
    public ResponseEntity buyParkingBusiness(){
        return null;
    }


}
