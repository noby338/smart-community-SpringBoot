package com.woniuxy.smart_community.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.entity.ParkingRecord;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.ParkingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
