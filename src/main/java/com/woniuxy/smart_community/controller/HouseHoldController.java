package com.woniuxy.smart_community.controller;

import com.woniuxy.smart_community.entity.HouseHold;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.HouseHoldService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author :  Fiver_Hu
 * @Date : 2022/7/11 19:13 星期一
 * @Project_Name -> smart-community
 * @Package_Name -> com.woniuxy.smart_community.controller
 * @ClassName -> HouseHoldController
 * @Version 1.0
 **/
@ResponseBody
@RestController
@RequestMapping("/houseHold")
public class HouseHoldController {

    @Autowired
    HouseHoldService houseHoldService;

    @GetMapping("/selectHouseHold")
    public ResponseEntity selectHouseHold(
            @Param("houseHold")HouseHold houseHold,
            @Param("pageNum") int pageNum,
            @Param("pageSize") int pageSize){
        ResponseEntity responseEntity;
        List<HouseHold> houseHolds = houseHoldService.selectHouseHoldByHouseHoldInfo(houseHold,pageNum,pageSize);
        if(houseHolds != null){
            responseEntity = new ResponseEntity(200,"获取成功！",houseHolds);
        }else {
            responseEntity = new ResponseEntity(401,"获取失败！",null);
        }
        return  responseEntity;
    }

    @PostMapping("/insertHouseHold")
    public ResponseEntity insertHouseHold(
            @Param("houseHold")HouseHold houseHold ){
        ResponseEntity responseEntity;
        int houseHolds = houseHoldService.insert(houseHold);
        if(houseHolds != 0){
            return new ResponseEntity(200,"添加成功！",null);
        }else {
            return new ResponseEntity(401,"添加失败！",null);
        }
    }

    @PostMapping("/updateHouseHold")
    public ResponseEntity updateHouseHold(
            @Param("houseHold")HouseHold houseHold ){
        ResponseEntity responseEntity;
        int houseHolds = houseHoldService.update(houseHold);
        if(houseHolds != 0){
            return new ResponseEntity(200,"修改成功！",null);
        }else {
            return new ResponseEntity(401,"修改失败！",null);
        }
    }

    @PostMapping("/deleteHouseHold")
    public ResponseEntity deleteHouseHold(
            @Param("houseHold")HouseHold houseHold ){
        ResponseEntity responseEntity;
        int houseHolds = houseHoldService.deleteById(houseHold.getId());
        if(houseHolds != 0){
            return new ResponseEntity(200,"删除成功！",null);
        }else {
            return new ResponseEntity(401,"删除失败！",null);
        }
    }
    
}
