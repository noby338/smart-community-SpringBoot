package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.House;
import com.woniuxy.smart_community.entity.HouseFloor;
import com.woniuxy.smart_community.entity.HouseHold;
import com.woniuxy.smart_community.entity.HouseInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @ClassName -> HouseHoldDaoTset
 * @Author Fiver_Hu
 * @Date 2022/7/5 20:58 ζζδΊ
 * @Version 1.0
 **/
@SuppressWarnings("ALL")
@SpringBootTest
public class HouseHoldDaoTset {
    @Autowired
    HouseHoldDao houseHoldDao;
    @Autowired
    HouseDao houseDao;
    @Test
    public void insertTest(){
        HouseHold houseHold = new HouseHold();
        RandomPhoneNum randomPhoneNum = new RandomPhoneNum();
        RandomUserInfo randomUserInfo = new RandomUserInfo();
        HouseInfo houseInfo = new HouseInfo();
        House house = new House();
        for(int i =1;i<=1920;i++){
            house.setId(i);
            List<HouseFloor> houseFloors = houseDao.selectHouseByFloorId(houseInfo);
            for(HouseFloor houseFloor : houseFloors){
                for(House house1: houseFloor.getHouseList()){
                    if(house1.getHousePeopleNums() != 0){
                        for(int j = 1;j <= house1.getHousePeopleNums();j++){
                            houseHold.setHouseId(house1.getId());
                            houseHold.setAge(randomUserInfo.getAge());
                            boolean sex = randomUserInfo.getSex();
                            houseHold.setGender(sex);
                            houseHold.setName(randomUserInfo.getFamilyName()+randomUserInfo.getFamilyName());
                            houseHold.setTelephone(randomPhoneNum.getPhoneNum());
                            houseHold.setOwner(randomUserInfo.getSex());
                            houseHold.setState(new Random().nextInt(2)+1);
                            houseHoldDao.insert(houseHold);
                        }
                    }

                }
            }

        }
    }

    @Test
    public void select(){
        House house = new House();
        house.setId(2);
        HouseInfo houseInfo = new HouseInfo();
        List<HouseFloor> houseFloors = houseDao.selectHouseByFloorId(houseInfo);
        System.out.println(houseFloors);
    }

    @Test
    public void updateTest(){
        HouseHold houseHold = new HouseHold();
        for(int i =0;i<200;i++){
            houseHold.setId(i);
            houseHold.setAge(i%12);
            houseHold.setHouseId(i%12);
            houseHold.setGender(true);
            houseHold.setName("i");
            houseHold.setTelephone("88888888");
            houseHold.setOwner(true);
            houseHold.setState(i%2);
            houseHoldDao.update(houseHold);
        }

    }

    @Test
    public void selectHouseHoldByHouseHoldInfoTest(){
        HouseHold houseHold = new HouseHold();
        houseHold.setGender(false);
        System.out.println(houseHoldDao.selectHouseHoldByHouseHoldInfo(houseHold));
    }

    @Test
    public void deleteByIdTest(){
        houseHoldDao.deleteById(1);
    }

    @Test
    public void deleteByHouseIdTest(){
        houseHoldDao.deleteByHouseId(1);
    }

    @Test
    public void countByHouseInfoTest(){
        HouseHold houseHold = new HouseHold();
        houseHold.setHouseId(2);
        System.out.println(houseHoldDao.selectHouseHoldByHouseHoldInfo(houseHold));
    }

    @Test
    public void  randomUserInfoTest(){

        RandomUserInfo randomUserInfo = new RandomUserInfo();
        boolean sex = randomUserInfo.getSex();
        System.out.println(sex);
        System.out.println(randomUserInfo.getFamilyName());
        System.out.println(randomUserInfo.getAge());
        System.out.println(randomUserInfo.getName(sex));
    }

    public class RandomUserInfo{
        //ιζΊδΏ‘ζ―
        String familyName1 = "θ΅΅ι±ε­ζε¨ε΄ιηε―ιθ€ε«θζ²ι©ζ¨ζ±η§¦ε°€θ?Έδ½εζ½εΌ ε­ζΉδΈ₯ειι­ιΆε§ζθ°’ιΉε»ζ°΄δΊθζ½θε₯θε½­ιι²ι¦ζι©¬θε€θ±ζΉδΏδ»»θ’ζ³ι²ε²εθ΄Ήε²θι·θ΄Ίεͺζ±€ζ»ζ?·η½ζ―ιε?εΈΈδΉδΊζΆει½εΊ·δΌδ½εει‘Ύε­εΉ³ι»εη©θ§ε°Ήε§ι΅ζΉζ±ͺη₯ζ―η¦Ήη"
                +"η±³θ΄ζθ§θ?‘ζζ΄ε?θεΊηηΊͺθε±ι‘Ήη₯θ£η²±ζι?εΈ­ε­£ιΊ»εΌΊθ΄Ύθ·―ε¨ε±ζ±η«₯ι’ι­ζ’ηζειεΎι±ιͺι«ε€θ‘η°θ‘ειδΈζ―ε’θ«ζΏηΌͺεΉ²θ§£εΊε?δΈε?£ιιεζ­ζ΄ͺεθ―Έε·¦η³ε΄ειΎη¨ι’ζ»θ£΄ιθ£ηΏθηΎηε?Άε°θ?ε¨ι³ι΄ζΎδΊε―δΉη¦ε·΄εΌη§ιε±±θ°·θ½¦δΎ―";
        String girlName = "η§ε¨θ±εζ§ε·§ηΎε¨ιζ·ζ η ηΏ ιθηθηΊ’ε¨₯η²θ¬θ³ηε½©ζ₯θε°ε€ζ΄ζ’η³η΄ δΊθ²ηη―ιͺθ£η±ε¦Ήιι¦ζθΊεͺθ³ηε‘δ½³εηΌε€ηθ΄θζ‘ε¨£εΆη§ηε¨η¦ζΆε¦θη§ηθι¦ι»ιε©ε©·ε§£ε©ε¨΄ηΎι’ι²ηΆζ‘ε©΅ιθηΊ¨δ»ͺθ·δΈΉθηεη΄θθθζ’¦ε²θε©ι¦¨ηη°ι΅θε­θΊεεΏθͺζΎηΊ―ζ―ζ¦ζ­ε°η½η¬θηΎ½εΈε?ζ¬£ι£θ²ζ»’ι¦₯η­ ζη«Ήι­εζζ¬’ιζ«θΈθ²ε―δΌδΊε?ε―ε§¬θε½±θζζδΈ½";
        String boyName = "δΌεεζ―δΏε³°εΌΊεεΉ³δΏδΈζθΎεζζ°Έε₯δΈεΉΏεΏδΉε΄θ―ζ΅·ε±±δ»ζ³’ε?θ΄΅η¦ηιΎεε¨ε½θε­¦η₯₯ζεζ­¦ζ°ε©ζΈι£ε½¬ε―ι‘ΊδΏ‘ε­ζ°ζΆζζεΊ·ζεε€©θΎΎε?ε²©δΈ­θθΏζζεεε½ͺεθ―εζ¬ιζ―ε£?δΌζηΎ€θ±ͺεΏι¦ζΏδΉη»εζΎεεεΊη£ζ°εθ£ζ²³ε²ζ±θΆζ΅©δΊ?ζΏθ°¦δΊ¨ε₯εΊδΉθ½?ηΏ°ζδΌ―ε?θ¨θ₯ιΈ£ζζζ’ζ η»΄ε―εδΌ¦ηΏζ­ιΉζ³½ζ¨θΎ°ε£«δ»₯ε»Ίε?Άθ΄ζ ηεΎ·θ‘ζΆζ³°ηιηι§ε η­θΎζ₯ ζ¦ι£θͺεΌ";

        /**
         * εθ½οΌιζΊδΊ§ηε§ζ°
         *
         * @return
         */
        public String getFamilyName() {
            String str = "";
            int randNum = (int) (Math.random() * 100 + 1);
            int index = new Random().nextInt(randNum);
            str = String.valueOf(familyName1.charAt(index));

            return str;
        }

        /**
         * εθ½οΌδΌ ε₯ζ§ε«εζ°οΌδΎζ?ζ§ε«δΊ§ηεε­
         *
         * @param sex
         * @return
         */
        public String getName(boolean sex) {
            String name = "";
            int randNum = new Random().nextInt(2) + 1;//1,2
            int strLen = (sex) ? boyName.length() : girlName.length();//ε€ζ­η·ε₯³εε­
            int index = (randNum & 1) == 0 ? new Random().nextInt(strLen - 1) :
                    new Random().nextInt(strLen);
            name = (sex) ? boyName.substring(index, index + randNum) :
                    girlName.substring(index, index + randNum);
            return name;
        }


        /**
         * εθ½οΌιζΊδΊ§η18-21ηζ΄ζ°
         *
         * @return
         */
        public int getAge() {
            return (int) (Math.random() * 100 + 1);
        }

        /**
         * εθ½οΌιζΊδΊ§ηζ§ε«
         *
         * @return
         */
        public boolean getSex() {
            int randNum = new Random().nextInt(2) + 1;
            return randNum == 1;
        }
    }

        //δΈ­ε½η§»ε¨
        static String[] CHINA_MOBILE = {
                "134", "135", "136", "137", "138", "139", "150", "151", "152", "157", "158", "159",
                "182", "183", "184", "187", "188", "178", "147", "172", "198"
        };
        //δΈ­ε½θι
        static String[] CHINA_UNICOM = {
                "130", "131", "132", "145", "155", "156", "166", "171", "175", "176", "185", "186", "166"
        };
        //δΈ­ε½η΅δΏ‘
        static String[] CHINA_TELECOME = {
                "133", "149", "153", "173", "177", "180", "181", "189", "199"
        };


    public static class RandomPhoneNum {

        //ε?δΈδΈͺιζζΉζ³οΌδΈι¨ηζεδΈͺηε·η 
        public String getPhoneNum() {
            //η»δΊηε?ηεε§ε·ζ?΅οΌε·ζ?΅ζ―ε¨ηΎεΊ¦δΈι’ζ₯ζΎηηε?ε·ζ?΅
            String[] start = {"133", "149", "153", "173", "177",
                    "180", "181", "189", "199", "130", "131", "132",
                    "145", "155", "156", "166", "171", "175", "176", "185", "186", "166", "134", "135",
                    "136", "137", "138", "139", "147", "150", "151", "152", "157", "158", "159", "172",
                    "178", "182", "183", "184", "187", "188", "198", "170", "171"};

            //ιζΊεΊηε?ε·ζ?΅  δ½Ώη¨ζ°η»ηlengthε±ζ§οΌθ·εΎζ°η»ιΏεΊ¦οΌ
            //ιθΏMath.randomοΌοΌ*ζ°η»ιΏεΊ¦θ·εΎζ°η»δΈζ οΌδ»θιζΊεΊεδΈδ½ηε·ζ?΅
            String phoneFirstNum = start[(int) (Math.random() * start.length)];
            //ιζΊεΊε©δΈη8δ½ζ°
            String phoneLastNum = "";
            //ε?δΉε°Ύε·οΌε°Ύε·ζ―8δ½
            final int LENPHONE = 8;
            //εΎͺη―ε©δΈηδ½ζ°
            for (int i = 0; i < LENPHONE; i++) {
                //ζ―ζ¬‘εΎͺη―ι½δ»0~9ζιδΈδΈͺιζΊζ°
                phoneLastNum += (int) (Math.random() * 10);
            }
            //ζη»ε°ε·ζ?΅εε°Ύζ°θΏζ₯θ΅·ζ₯
            String phoneNum = phoneFirstNum + phoneLastNum;
            return phoneNum;
        }
    }
}