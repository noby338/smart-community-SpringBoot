package com.woniuxy.smart_community.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.entity.CarInfo;
import com.woniuxy.smart_community.entity.ForSelect;
import com.woniuxy.smart_community.entity.House;
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


    @PostMapping("/parkNumbersSelect/{parkId}/{ownerId}")
    public ResponseEntity getParkingInfoParkNumbers(@PathVariable int parkId,@PathVariable int ownerId){
        ResponseEntity responseEntity=null;
        try{
            List<ForSelect> forSelects=carInfoService.getALLParkingInfoIdAndParkNumber(parkId,ownerId);
            responseEntity=new ResponseEntity(200,"ok",forSelects);
        }catch (Exception e){
            responseEntity=new ResponseEntity(401,"无车位信息",null);
        }
        return responseEntity;
    }

    @PostMapping("/carOwnersName/{id}")
    public ResponseEntity getAllCarOwnersName(@PathVariable int id){
        ResponseEntity responseEntity=null;
        try{
            List<ForSelect> forSelects=carInfoService.getAllCarOwnersIdAndName(id);
            responseEntity=new ResponseEntity(200,"ok",forSelects);
        }catch (Exception e){
            responseEntity=new ResponseEntity(401,"无车主信息",null);
        }
        return responseEntity;
    }

    @PostMapping("/getAllHouse")
    public ResponseEntity getAllHouse(){
        ResponseEntity responseEntity=null;
        try{
            List<ForSelect> forSelects=carInfoService.getAllHouse();
            responseEntity=new ResponseEntity(200,"ok",forSelects);
        }catch (Exception e){
            responseEntity=new ResponseEntity(401,"无车主信息",null);
        }
        return responseEntity;
    }

    @PostMapping("/changeParkIdByCarId/{carId}/{parkId}")
    public ResponseEntity changeParkIdByCarId(@PathVariable int carId,@PathVariable int parkId){
        ResponseEntity responseEntity=null;
        try{
            carInfoService.changeParkIdByCarId(carId,parkId);
            responseEntity=new ResponseEntity(200,"ok",null);
        }catch (Exception e){
            responseEntity=new ResponseEntity(401,"改绑失败",null);
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
