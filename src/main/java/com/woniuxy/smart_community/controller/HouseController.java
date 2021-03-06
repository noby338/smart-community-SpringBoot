package com.woniuxy.smart_community.controller;

import com.woniuxy.smart_community.entity.Cascade;
import com.woniuxy.smart_community.entity.HouseBuilding;
import com.woniuxy.smart_community.entity.House;
import com.woniuxy.smart_community.entity.HouseBuilding;
import com.woniuxy.smart_community.entity.HouseInfo;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.HouseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :  Fiver_Hu
 * @Date : 2022/7/6 11:28 星期三
 * @Project_Name -> smart-community
 * @Package_Name -> com.woniuxy.smart_community.controller
 * @ClassName -> HouseController
 * @Version 1.0
 **/

@ResponseBody
@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    HouseService houseService;


    /**
     * 通过房间信息查询相关数据
     *
     * @param houseInfo 房间号
     * @return 实例对象
     */
    @GetMapping("/selectHouse")
    public ResponseEntity selectHouse(
            @Param("houseInfo") HouseInfo houseInfo){
        ArrayList<House> houses= houseService.selectHouse(houseInfo);
        return new ResponseEntity<>(200, "获取成功！", houses);
    }

    /**
     * 通过主键修改房间信息数据
     *
     * @param  houseInfo 实例对象
     * @return 影响行数
     */
    @PostMapping("/updateHouse")
     public ResponseEntity updateHouse(@Param("houseInfo") HouseInfo houseInfo){
         ResponseEntity response = houseService.updateHouse(houseInfo);
         System.out.println(response);
         return response;
     }

    /**
     * 获取所有的 houseBuilding 对象集合
     * @return houseBuilding 对象集合
     */
    @GetMapping("/selectAllHouseBuilding")
    public ResponseEntity selectAllHouseBuilding(){
        List<Cascade> houseBuildingList = houseService.selectAllHouseBuilding();
        System.out.println("houseBuildingList = " + houseBuildingList);
        return new ResponseEntity(200,"y",houseBuildingList);
    }

}
