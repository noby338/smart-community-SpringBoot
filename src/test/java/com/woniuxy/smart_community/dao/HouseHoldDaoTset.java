package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.House;
import com.woniuxy.smart_community.entity.HouseFloor;
import com.woniuxy.smart_community.entity.HouseHold;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @ClassName -> HouseHoldDaoTset
 * @Author Fiver_Hu
 * @Date 2022/7/5 20:58 星期二
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
        House house = new House();
        for(int i =1;i<=1920;i++){
            house.setId(i);
            HouseFloor houseFloor = houseDao.selectHouseByFloorId(1);
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

    @Test
    public void select(){
        House house = new House();
        house.setId(2);
        HouseFloor houseFloor = houseDao.selectHouseByFloorId(1);
        System.out.println(houseFloor);
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
        houseHold.setAge(1);
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
        //随机信息
        String familyName1 = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻水云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳鲍史唐费岑薛雷贺倪汤滕殷罗毕郝安常乐于时傅齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄"
                +"米贝明臧计成戴宋茅庞熊纪舒屈项祝董粱杜阮席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田胡凌霍万柯卢莫房缪干解应宗丁宣邓郁单杭洪包诸左石崔吉龚程邢滑裴陆荣翁荀羊甄家封芮储靳邴松井富乌焦巴弓牧隗山谷车侯";
        String girlName = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽";
        String boyName = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";

        /**
         * 功能：随机产生姓氏
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
         * 功能：传入性别参数，依据性别产生名字
         *
         * @param sex
         * @return
         */
        public String getName(boolean sex) {
            String name = "";
            int randNum = new Random().nextInt(2) + 1;//1,2
            int strLen = (sex) ? boyName.length() : girlName.length();//判断男女名字
            int index = (randNum & 1) == 0 ? new Random().nextInt(strLen - 1) :
                    new Random().nextInt(strLen);
            name = (sex) ? boyName.substring(index, index + randNum) :
                    girlName.substring(index, index + randNum);
            return name;
        }


        /**
         * 功能：随机产生18-21的整数
         *
         * @return
         */
        public int getAge() {
            return (int) (Math.random() * 100 + 1);
        }

        /**
         * 功能：随机产生性别
         *
         * @return
         */
        public boolean getSex() {
            int randNum = new Random().nextInt(2) + 1;
            return randNum == 1;
        }
    }

        //中国移动
        static String[] CHINA_MOBILE = {
                "134", "135", "136", "137", "138", "139", "150", "151", "152", "157", "158", "159",
                "182", "183", "184", "187", "188", "178", "147", "172", "198"
        };
        //中国联通
        static String[] CHINA_UNICOM = {
                "130", "131", "132", "145", "155", "156", "166", "171", "175", "176", "185", "186", "166"
        };
        //中国电信
        static String[] CHINA_TELECOME = {
                "133", "149", "153", "173", "177", "180", "181", "189", "199"
        };


    public static class RandomPhoneNum {

        //定一个静态方法，专门生成单个的号码
        public String getPhoneNum() {
            //给予真实的初始号段，号段是在百度上面查找的真实号段
            String[] start = {"133", "149", "153", "173", "177",
                    "180", "181", "189", "199", "130", "131", "132",
                    "145", "155", "156", "166", "171", "175", "176", "185", "186", "166", "134", "135",
                    "136", "137", "138", "139", "147", "150", "151", "152", "157", "158", "159", "172",
                    "178", "182", "183", "184", "187", "188", "198", "170", "171"};

            //随机出真实号段  使用数组的length属性，获得数组长度，
            //通过Math.random（）*数组长度获得数组下标，从而随机出前三位的号段
            String phoneFirstNum = start[(int) (Math.random() * start.length)];
            //随机出剩下的8位数
            String phoneLastNum = "";
            //定义尾号，尾号是8位
            final int LENPHONE = 8;
            //循环剩下的位数
            for (int i = 0; i < LENPHONE; i++) {
                //每次循环都从0~9挑选一个随机数
                phoneLastNum += (int) (Math.random() * 10);
            }
            //最终将号段和尾数连接起来
            String phoneNum = phoneFirstNum + phoneLastNum;
            return phoneNum;
        }
    }
}