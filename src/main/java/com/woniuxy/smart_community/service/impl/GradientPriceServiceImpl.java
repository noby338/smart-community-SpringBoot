package com.woniuxy.smart_community.service.impl;

import com.woniuxy.smart_community.dao.GradientPriceDao;
import com.woniuxy.smart_community.entity.GradientPrice;
import com.woniuxy.smart_community.service.GradientPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * @Description 价格梯度
 * @Author noby
 * @Date 2022/7/7 19:11
 */
@Service
public class GradientPriceServiceImpl implements GradientPriceService {

    @Autowired
    GradientPriceDao gradientPriceDao;

    /**
     * 根据controller传递的gradientPrice对象修改价格梯度
     */
    @Override
    public void updateByGradientPrice(GradientPrice gradientPrice) {
        gradientPriceDao.updateByGradientPrice(gradientPrice);
    }

    /**
     * 通过单价 Id 和用量计算，该 service 通过数据库中的单价梯度计算价格并返回
     * @param utilId 单价 ID
     * @param quantity 用量
     * @return 价格
     */
    @Override
    public BigDecimal getPriceByUtilIdQuantity(int utilId, double quantity) {
        List<GradientPrice> gradientPrices = gradientPriceDao.selectByUtilId(utilId);
        //横坐标和斜率
        HashMap<Double, Double> xkMap = new HashMap<>();
        for (GradientPrice gradientPrice : gradientPrices) {
            Double beginning = gradientPrice.getBeginning();
            Double price = gradientPrice.getPrice();
            xkMap.put(beginning, price);
        }
        //排序后的坐标和斜率
        ArrayList<Map.Entry<Double, Double>> xkList = new ArrayList(xkMap.entrySet());
        xkList.sort(new Comparator<Map.Entry<Double, Double>>() {
            @Override
            public int compare(Map.Entry<Double, Double> o1, Map.Entry<Double, Double> o2) {
                return (int) (o1.getKey() - o2.getKey());
            }
        });

//        System.out.println("xkList = " + xkList);

        //价格
        BigDecimal money = new BigDecimal(0);

        //分段函数计算价格(根据GradientPrice中的梯度动态计算)
        for (int i = 0; i < xkList.size(); i++) {
            Map.Entry<Double, Double> before = xkList.get(i);
            if (i + 1 < xkList.size()) {
                Map.Entry<Double, Double> after = xkList.get(i + 1);
                if (after.getKey() < quantity) {
                    money = (new BigDecimal(after.getKey() + "").subtract(new BigDecimal(before.getKey() + ""))
                            .multiply(new BigDecimal(before.getValue() + ""))).add(money);
                }else {
                    money = (new BigDecimal(quantity + "").subtract(new BigDecimal(before.getKey() + ""))
                            .multiply(new BigDecimal(before.getValue() + ""))).add(money);
                    break;
                }
            } else {
                money = (new BigDecimal(quantity + "").subtract(new BigDecimal(before.getKey() + ""))
                        .multiply(new BigDecimal(before.getValue() + ""))).add(money);
                break;
            }

        }
        //价格统一保留两位小数
        return money.setScale(2, RoundingMode.HALF_UP);
    }
}
