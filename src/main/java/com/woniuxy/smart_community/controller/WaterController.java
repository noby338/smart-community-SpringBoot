package com.woniuxy.smart_community.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.entity.Electricity;
import com.woniuxy.smart_community.entity.HouseInfo;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.entity.Water;
import com.woniuxy.smart_community.service.HouseService;
import com.woniuxy.smart_community.service.WaterService;
import com.woniuxy.smart_community.service.impl.WaterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 水费
 * @Author noby
 * @Date 2022/7/12 19:31
 */
@RestController
@RequestMapping("/water")
public class WaterController {
    @Autowired
    WaterService waterService;
    @Autowired
    HouseService houseService;


    @PostMapping("/select/{month}/{pageNum}")
    public ResponseEntity<PageInfo<Water>> select(
            @RequestBody HouseInfo houseInfo,
            @PathVariable String month,
            @PathVariable int pageNum) {
        ArrayList<Integer> houseIdList = houseService.selectHouseById(houseInfo);
        String _month = null;
        if (!"all".equals(month)) {
            _month = month.replace('-','/');
        }
        List<Water> waterList = waterService.selectWaterByHouseIdListAndMonth(houseIdList, _month,pageNum);
        PageInfo<Water> page = new PageInfo<>(waterList);
        return new ResponseEntity<>(200,"y",page);
    }

    @PostMapping("/selectSum/{month}")
    public ResponseEntity<Double> selectSum(
            @RequestBody HouseInfo houseInfo,
            @PathVariable String month) {
        ArrayList<Integer> houseIdList = houseService.selectHouseById(houseInfo);
        String _month = null;
        if (!"all".equals(month)) {
            _month = month.replace('-','/');
        }
        Double sum = waterService.selectWaterSumByHouseIdListAndMonth(houseIdList, _month);
        return new ResponseEntity<>(200,"y",sum);
    }
}
