package com.woniuxy.smart_community.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.entity.CarInfo;
import com.woniuxy.smart_community.entity.ForSelect;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
public class CarInfoController {

    @Value("${upload.resourceLocations}")
    private String resourceLocations;
    @Autowired
    CarInfoService carInfoService;

    @PostMapping("/cars/{pageIndex}/{pageSize}")
    public ResponseEntity getAllCarInfo(@PathVariable int pageIndex,@PathVariable int pageSize){
        ResponseEntity responseEntity=null;
        try {
            PageInfo<CarInfo> pageInfo = carInfoService.getAllCarInfo(pageIndex,pageSize);
            responseEntity=new ResponseEntity(200,"ok",pageInfo);
        }catch (Exception e){
            responseEntity=new ResponseEntity(401,"无车辆信息",null);
        }
        return responseEntity;
    }

    public ResponseEntity getJpg(){
        ResponseEntity responseEntity=null;
        try{

        }catch (Exception e){

        }
        return responseEntity;
    }

    @PostMapping("/parkNumbersSelect/{id}")
    public ResponseEntity getParkingInfoParkNumbers(@PathVariable int id){
        System.out.println(id);
        ResponseEntity responseEntity=null;
        try{
            List<ForSelect> forSelects=carInfoService.getALLParkingInfoIdAndParkNumber(id);
            responseEntity=new ResponseEntity(200,"ok",forSelects);
        }catch (Exception e){
            responseEntity=new ResponseEntity(401,"无车位信息",null);
        }
        return responseEntity;
    }

    @PostMapping("/uploadImages/{carNumber}")
    public ResponseEntity uploadImages(MultipartFile img,@PathVariable String carNumber){
        ResponseEntity responseEntity=null;
        try{
            String fileName = img.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String finalName = carNumber + suffixName;
            File file=new File(resourceLocations, finalName);
            img.transferTo(file);
            carInfoService.addImgAddress(carNumber,"/"+finalName);
            responseEntity=new ResponseEntity(200,"ok",null);
        }catch(Exception e){
            responseEntity=new ResponseEntity(401,"error",null);
        }
        return responseEntity;
    }
}