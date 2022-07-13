package com.woniuxy.smart_community.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.entity.ForSelect;
import com.woniuxy.smart_community.entity.ParkingRecord;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.ParkingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParkingRecordController {
    @Autowired
    ParkingRecordService parkingRecordService;

    @PostMapping("/getParkingRecordsToPage/{pageIndex}/{pageSize}")
    public ResponseEntity getParkingRecordsToPage(@PathVariable int pageIndex,
                                                  @PathVariable int pageSize,
                                                  @RequestBody ParkingRecord queryParkingRecord){

        ResponseEntity responseEntity=null;
        try {
            PageInfo<ParkingRecord> pageInfo=parkingRecordService.getParkingRecordsToPage(pageIndex,pageSize,queryParkingRecord);
            responseEntity=new ResponseEntity(200,"ok",pageInfo);
        }catch (Exception e){

            responseEntity=new ResponseEntity(401,"error",null);
        }
        return responseEntity;
    }

    @PostMapping("/getCarsInParkingRecord")
    public ResponseEntity getCarsInParkingRecord(){
        ResponseEntity responseEntity=null;
        try {
            List<ForSelect> forSelects=parkingRecordService.getCarsInParkingRecord();
            responseEntity=new ResponseEntity(200,"ok",forSelects);
        }catch (Exception e){
            responseEntity=new ResponseEntity(401,"error",null);
        }
        return responseEntity;
    }

    @PostMapping("/getCarsInCarInfo")
    public ResponseEntity getCarsInCarInfo(){
        ResponseEntity responseEntity=null;
        try {
            List<ForSelect> forSelects=parkingRecordService.getCarsInCarInfo();
            responseEntity=new ResponseEntity(200,"ok",forSelects);
        }catch (Exception e){
            responseEntity=new ResponseEntity(401,"error",null);
        }
        return responseEntity;
    }

    @PostMapping("/addCarInRecord/{carId}")
    public ResponseEntity addCarInRecord(@PathVariable int carId){
        ResponseEntity responseEntity=null;
        try {
            int state=parkingRecordService.addRecord(carId);
            if(state==2){
                responseEntity=new ResponseEntity(200,"ok",null);
            }else if(state==1){
                responseEntity=new ResponseEntity(505,"该车正在小区中，请勿添加",null);
            } else {
                responseEntity=new ResponseEntity(505,"该车无车主，请添加车主",null);
            }
        }catch (Exception e){
            responseEntity=new ResponseEntity(401,"error",null);
        }
        return responseEntity;
    }

    @PostMapping("/changeCarOutRecord/{id}")
    public ResponseEntity changeCarOutRecord(@PathVariable int id){
        ResponseEntity responseEntity=null;
        try {
            System.out.println(id);
            parkingRecordService.changeCarOutRecord(id);
            responseEntity=new ResponseEntity(505,"车辆出去成功",null);
        }catch (Exception e){
            responseEntity=new ResponseEntity(401,"error",null);
        }
        return responseEntity;
    }
}
