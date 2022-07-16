package com.woniuxy.smart_community.service.impl;

import com.woniuxy.smart_community.dao.UtilPriceDao;
import com.woniuxy.smart_community.entity.GradientPrice;
import com.woniuxy.smart_community.entity.UtilPrice;
import com.woniuxy.smart_community.service.UtilPriceService;
import net.sf.jsqlparser.statement.select.Limit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * @Description 单价serviceImpl
 * @Author noby
 * @Date 2022/7/7 10:24
 */
@Service
public class UtilPriceServiceImpl implements UtilPriceService {
    @Autowired
    UtilPriceDao utilPriceDao;

    /**
     * 查询所有单价
     * @return 单价对象集合
     */
    @Override
    public List<UtilPrice> selectAll() {
        return utilPriceDao.selectAll();
    }
    /**
     * 通过单价 Id 和已存在的用量梯度计算价格
     * @param utilId 单价 ID
     * @param quantity 用量
     * @return 价格
     */
    @Override
    public BigDecimal getPriceByUtilIdQuantity(int utilId, double quantity) {
        UtilPrice utilPrice = utilPriceDao.selectById(utilId);
        List<GradientPrice> gradientPrices = utilPrice.getGradientPriceList();
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

    /**
     * 获取某项费用的用量价格二维数组
     * @return
     */
    @Override
    public List<double[]> getQuantityAndCostArray(int utilId) {
        Double maxBeginning = utilPriceDao.selectMaxBeginningByUtilId(utilId);
        ArrayList<double[]> doubleArray = new ArrayList<>();
        double limit;
        if (maxBeginning == 0) {
            limit = 300;
        } else {
            limit = maxBeginning*1.5;
        }
        for (int i = 0; i < limit; i++) {
            double[] doubles = {i,this.getPriceByUtilIdQuantity(utilId,i).doubleValue()};
            doubleArray.add(doubles);
        }
        return doubleArray;
    }
}
