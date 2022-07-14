package com.woniuxy.smart_community.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.entity.Electricity;
import com.woniuxy.smart_community.entity.Gas;
import com.woniuxy.smart_community.entity.HouseInfo;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.ElectricityService;
import com.woniuxy.smart_community.service.GasService;
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
@RequestMapping("/gas")
public class GasController {
    @Autowired
    GasService gasService;
    @Autowired
    HouseService houseService;


    @PostMapping("/select/{month}/{pageNum}")
    public ResponseEntity<PageInfo<Gas>> select(
            @RequestBody HouseInfo houseInfo,
            @PathVariable String month,
            @PathVariable int pageNum) {
        ArrayList<Integer> houseIdList = houseService.selectHouseById(houseInfo);
        String _month = null;
        if (!"all".equals(month)) {
            _month = month.replace('-','/');
        }
        List<Gas> gasList = gasService.selectGasByHouseIdListAndMonth(houseIdList, _month,pageNum);
        PageInfo<Gas> page = new PageInfo<>(gasList);
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
        Double sum = gasService.selectGasSumByHouseIdListAndMonth(houseIdList, _month);
        return new ResponseEntity<>(200,"y",sum);
    }
}
