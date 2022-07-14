package com.woniuxy.smart_community.controller;

import com.woniuxy.smart_community.entity.GradientPrice;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.GradientPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 价格梯度
 * @Author noby
 * @Date 2022/7/7 19:14
 */
@RestController
@RequestMapping("/gradientPrice")
public class GradientPriceController {
    @Autowired
    private GradientPriceService gradientPriceService;

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody GradientPrice gradientPrice) {
        gradientPriceService.updateByGradientPrice(gradientPrice);
        return new ResponseEntity<>(200,"y",null);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        gradientPriceService.delectById(id);
        return new ResponseEntity<>(200,"y",null);
    }

    @PostMapping("insert")
    public ResponseEntity<String> insert(@RequestBody GradientPrice gradientPrice) {
        gradientPriceService.insert(gradientPrice);
        return new ResponseEntity<>(200,"y",null);
    }
}
