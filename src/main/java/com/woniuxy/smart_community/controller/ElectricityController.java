package com.woniuxy.smart_community.controller;

import com.woniuxy.smart_community.dao.ElectricityDao;
import com.woniuxy.smart_community.entity.GradientPrice;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.ElectricityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/select")
    public ResponseEntity<String> select(@RequestBody GradientPrice gradientPrice) {
        return new ResponseEntity<>(200,"y",null);
    }
}
