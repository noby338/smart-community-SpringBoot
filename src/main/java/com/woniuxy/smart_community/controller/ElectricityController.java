package com.woniuxy.smart_community.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.dao.ElectricityDao;
import com.woniuxy.smart_community.entity.Electricity;
import com.woniuxy.smart_community.entity.GradientPrice;
import com.woniuxy.smart_community.entity.HouseInfo;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.ElectricityService;
import com.woniuxy.smart_community.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 电费
 * @Author noby
 * @Date 2022/7/12 19:31
 */
@RestController
@RequestMapping("/electricity")
public class ElectricityController {
    @Autowired
    ElectricityService electricityService;
    @Autowired
    HouseService houseService;


    @PostMapping("/select/{month}/{pageNum}")
    public ResponseEntity<PageInfo<Electricity>> select(
            @RequestBody HouseInfo houseInfo,
            @PathVariable String month,
            @PathVariable int pageNum) {
        ArrayList<Integer> houseIdList = houseService.selectHouseById(houseInfo);
        String _month = null;
        if (!"all".equals(month)) {
            _month = month.replace('-','/');
        }
        List<Electricity> electricityList = electricityService.selectElectricityByHouseIdListAndMonth(houseIdList, _month,pageNum);
        PageInfo<Electricity> page = new PageInfo<>(electricityList);
        return new ResponseEntity<>(200,"y",page);
    }
}
