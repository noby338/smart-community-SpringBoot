package com.woniuxy.smart_community.service;

import com.woniuxy.smart_community.entity.HouseInfo;
import com.woniuxy.smart_community.service.impl.HouseServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

/**
 * @Author :  Fiver_Hu
 * @Date : 2022/7/6 14:19 星期三
 * @Project_Name -> smart-community
 * @Package_Name -> com.woniuxy.smart_community.service
 * @ClassName -> HouseServiceTest
 * @Version 1.0
 **/
@SpringBootTest
public class HouseServiceTest {

    @Autowired
    HouseServiceImpl houseService;




//    @Test
//    public void insertHouseTest(){
////        House house= new House(99,4,5,6,"789",10,1);
////        houseService.insertHouse(house);
//    }
//
//    @Test
//    public void deleteHouseByIdTest(){
//        houseService.deleteHouseById(6);
//    }
//
//    @Test
//    public void updateHouseTest(){
////        House house= new House(1,4,5,6,"789",10,1);
////        houseService.updateHouse(house);
//    }
//
//    @Test
//    public void selectHouseByHouseInfoTest(){
//        House house = new House();
////        house.setFloor(1);
//        ResponseEntity response = houseService.selectHouseId()
//        System.out.println(response);
//    }
//
//    @Test
//    public void countHousesTest(){
//        House house = new House();
////        house.setFloor(1);
//
//        if(response.getCode()==200){
//            System.out.println(response.getData());
//        }else {
//            System.out.println(response.getMsg());
//        }
//    }
    @Test
    public void houseId(){
        HouseInfo  houseInfo = new HouseInfo();
        houseInfo.setUnitId(1);
        ArrayList<Integer> integers = houseService.selectHouseId(houseInfo);
        System.out.println(integers);
    }




}
