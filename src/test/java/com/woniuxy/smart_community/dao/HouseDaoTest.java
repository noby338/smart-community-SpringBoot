package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.House;
import com.woniuxy.smart_community.entity.HouseFloor;
import com.woniuxy.smart_community.entity.HouseUnit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;
import java.util.Stack;

/**
 * @ClassName -> HouseDaoTest
 * @Author Fiver_Hu
 * @Date 2022/7/5 16:43 星期二
 * @Version 1.0
 **/
@SpringBootTest
public class HouseDaoTest {
    @Autowired
    HouseDao houseDao;
    @Autowired
    HouseUnitDao houseUnitDao;
    @Autowired
    HouseFloorDao houseFloorDao;

    @Test
    public void insertHouse(){
        House house = new House();
        for (int i = 1; i <= 480; i++) {//楼层id
            for (int i2 = 1; i2 <= 4; i2++) {//门牌号
                house.setFloorId(i);

                HouseFloor houseFloor = houseFloorDao.selectById(i);
                String floorNum = houseFloor.getName().substring(0,houseFloor.getName().length()-1);
                Integer unitId = houseFloor.getUnitId();

                HouseUnit houseUnit = houseUnitDao.selectById(unitId);
                String unitNum = houseUnit.getName().substring(0, houseUnit.getName().length()-2);

                Integer buildingId = houseUnit.getBuildingId();

                int unit = zh2arbaNum(unitNum);
                System.out.println(buildingId);
                System.out.println(unit);
                System.out.println(floorNum);

                house.setHouseNum(String.format("%02d%02d%02d%02d",buildingId ,unit,Integer.parseInt(floorNum), i2));

                house.setHousePeopleNums(new Random().nextInt(10));
                house.setHouseState(new Random().nextInt(5)+1);
                houseDao.insertHouse(house);
            }
        }


    }
//
//    @Test
//    public  void  selectHouseByHouseInfoTest(){
//        House house = new House();
//        house.setFloor(1);
//        System.out.println(houseDao.selectHouseByHouseInfo(house));
//    }
//
//    @Test
//    public void updateHouse(){
//        House house = new House();
//        for(int i = 0 ;i<100;i++){
//            house.setId(i);
//            house.setBuilding(i%2);
//            house.setUnit(i%2);
//            house.setFloor(i%2);
//            house.setHouseNum("12131415");
//            house.setHousePeopleNums(i%2);
//            house.setHouseState(i%2);
//            houseDao.updateHouse(house);
//        }
//    }
//
//    @Test
//    public void deleteByIdTest(){
//        houseDao.deleteHouseById(1);
//    }
//
//    @Test
//    public void count(){
//        House house = new House();
//        house.setFloor(2);
//        System.out.println(houseDao.countHouses(house));
//    }

    public static int zh2arbaNum(String zhNumStr) {
        Stack<Integer> stack = new Stack<>();
        String numStr = "一二三四五六七八九";
        String unitStr = "十百千万亿";

        String[] ssArr = zhNumStr.split("");
        for (String e : ssArr ) {
            int numIndex = numStr.indexOf(e);
            int unitIndex = unitStr.indexOf(e);
            if (numIndex != -1 ) {
                stack.push(numIndex + 1);
            } else if (unitIndex != -1) {
                int unitNum = (int)Math.pow(10, unitIndex + 1);
                if (stack.isEmpty()) {
                    stack.push(unitNum);
                } else {
                    stack.push( stack.pop() * unitNum);
                }
            }
        }

        return stack.stream().mapToInt(s-> s).sum();
    }
}
