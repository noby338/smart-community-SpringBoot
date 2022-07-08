package com.woniuxy.smart_community.controller;

import com.woniuxy.smart_community.entity.House;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.HouseService;
import com.woniuxy.smart_community.service.impl.HouseServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author :  Fiver_Hu
 * @Date : 2022/7/6 11:28 星期三
 * @Project_Name -> smart-community
 * @Package_Name -> com.woniuxy.smart_community.controller
 * @ClassName -> HouseController
 * @Version 1.0
 **/
//@CrossOrigin
@ResponseBody
@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    HouseService houseService  = new HouseServiceImpl();

    /**
     * 新增房间数据
     */
    @PostMapping("/insertHouse")
    public ResponseEntity insertHouse(@Param("house") House house){
        return houseService.insertHouse(house);
    }


    /**
     * 通过主键删除房间信息数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @PostMapping("/deleteHouse")
    public ResponseEntity deleteHouseById(@Param("id") Integer id){
        return houseService.deleteHouseById(id);
    }

    /**
     * 通过主键修改房间信息数据
     *
     * @param house 实例对象
     * @return 影响行数
     */
     public ResponseEntity updateHouse(@Param("house") House house){
         ResponseEntity response = houseService.updateHouse(house);
         System.out.println(response);
         return response;
     }

    /**
     * 通过房间信息查询相关数据
     *
     * @param house 房间号
     * @return 实例对象
     */
    @GetMapping("/selectAllHouse")
    public ResponseEntity selectHouseByHouseInfo(
            @Param("house") House house,
            @Param("pageNum")  int pageNum,
            @Param("pageSize")  int pageSize){
        ResponseEntity response = houseService.selectHouseByHouseInfo(house, pageNum, pageSize);
        System.out.println(response);
        return response;
    }

    /**
     * 根据房间信息统计总行数
     *
     * @param house 查询条件
     * @return 总行数
     */
    public ResponseEntity countHouses(@Param("house") House house){
        return houseService.countHouses(house);
    }

}
