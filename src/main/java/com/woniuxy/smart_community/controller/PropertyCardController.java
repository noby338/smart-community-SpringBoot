package com.woniuxy.smart_community.controller;

import com.woniuxy.smart_community.entity.PropertyCard;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.PropertyCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        PropertyCard propertyCard = propertyCardService.selectByCardNumber(cardNumber);
        return new ResponseEntity<>(200,"y",propertyCard);
    }

    @PostMapping("/charge/{addMoney}")
    public ResponseEntity<String> charge(@RequestBody PropertyCard propertyCard,@PathVariable Double addMoney) {
        propertyCardService.updateLastMoneyAndState(propertyCard.getId(),addMoney);
        return new ResponseEntity<>(200,"y",null);
    }
}
