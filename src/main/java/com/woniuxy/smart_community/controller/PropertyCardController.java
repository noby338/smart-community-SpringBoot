package com.woniuxy.smart_community.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.dao.PropertyCardDao;
import com.woniuxy.smart_community.entity.Gas;
import com.woniuxy.smart_community.entity.HouseInfo;
import com.woniuxy.smart_community.entity.PropertyCard;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.GasService;
import com.woniuxy.smart_community.service.HouseService;
import com.woniuxy.smart_community.service.PropertyCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 房卡
 * @Author noby
 * @Date 2022/7/12 19:31
 */
@RestController
@RequestMapping("/propertyCard")
public class PropertyCardController {
    @Autowired
    PropertyCardService propertyCardService;


    @GetMapping("/selectByCardNumber/{cardNumber}")
    public ResponseEntity<PropertyCard> selectByCardNumber(@PathVariable String cardNumber) {
        PropertyCard propertyCard = propertyCardService.selectByCarNumber(cardNumber);
        return new ResponseEntity<>(200,"y",propertyCard);
    }
}
