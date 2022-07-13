package com.woniuxy.smart_community.service.impl;

import com.woniuxy.smart_community.dao.GradientPriceDao;
import com.woniuxy.smart_community.dao.UtilPriceDao;
import com.woniuxy.smart_community.entity.GradientPrice;
import com.woniuxy.smart_community.entity.UtilPrice;
import com.woniuxy.smart_community.service.GradientPriceService;
import org.apache.coyote.http11.upgrade.UpgradeInfo;
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
    @Autowired
    UtilPriceDao utilPriceDao;

    /**
     * 根据controller传递的gradientPrice对象修改价格梯度
     */
    @Override
    public void updateByGradientPrice(GradientPrice gradientPrice) {
        GradientPrice gradientPrice1 = gradientPriceDao.selectById(gradientPrice.getId());
        Integer id = gradientPrice1.getId();
        String name = gradientPrice1.getName();
        Integer utilId = gradientPrice1.getUtilId();
        Double beginning = gradientPrice1.getBeginning();
        Double end = gradientPrice1.getEnd();
        Double price = gradientPrice1.getPrice();

        Double newBeginning = gradientPrice.getBeginning();
        Double newEnd = gradientPrice.getEnd();

//        gradientPriceDao.updateByGradientPrice(gradientPrice);
        if (end != null) {
            if (end <= beginning) {
                throw new RuntimeException("起始值应小于结束值");
            }
        }
        if (beginning < 0) {
            throw new RuntimeException("起始值应大于等于 0");
        }

        UtilPrice utilPrice = utilPriceDao.selectById(utilId);
        List<GradientPrice> gradientPriceList = utilPrice.getGradientPriceList();
        for (GradientPrice gra : gradientPriceList) {

            if (Objects.equals(gra.getId(), id)) {
                //找到被修改的梯度
                gra = gradientPrice;
            } else if (Objects.equals(gra.getBeginning(), end)) {
                //找到被修改的记录的下一个梯度
                if (gra.getEnd() != null) {
                    if (newEnd >= gra.getEnd()) {
                        throw new RuntimeException("该结束值应小于下一梯度结束值");
                    } else {
                        gra.setBeginning(newEnd);
                    }
                } else {
                    gra.setBeginning(newEnd);
                }
            } else if (gra.getEnd() != null) {
                //找到被修改记录的上一个梯度
                if (Objects.equals(gra.getEnd(), beginning)) {
                    if (newBeginning <= gra.getBeginning()) {
                        throw new RuntimeException("该起始值应大于上一梯度起始值");
                    } else {
                        gra.setEnd(newBeginning);
                    }
                }
            }

            gradientPriceDao.updateByGradientPrice(gra);

        }

    }

    @Override
    public void insert(GradientPrice gradientPrice) {
        Double beginning = gradientPrice.getBeginning();

        Integer utilId = gradientPrice.getUtilId();
        UtilPrice utilPrice = utilPriceDao.selectById(utilId);
        List<GradientPrice> gradientPriceList = utilPrice.getGradientPriceList();
        for (GradientPrice gra : gradientPriceList) {
            if (gra.getEnd() == null) {
                //找到该项目费用的最后一个梯度
                if (gra.getBeginning() >= beginning) {
                    throw new RuntimeException("该起始值应大于上一梯度起始值");
                } else {
                    gra.setEnd(beginning);
                    gradientPriceDao.updateByGradientPrice(gra);
                }
                break;
            }
        }
        gradientPriceDao.insert(gradientPrice);
    }

    @Override
    public void delectById(int id) {
        GradientPrice gradientPrice = gradientPriceDao.selectById(id);
        if (gradientPrice.getEnd() != null) {
            throw new RuntimeException("只能删除最后一个梯度");
        }
        UtilPrice utilPrice = utilPriceDao.selectById(gradientPrice.getUtilId());
        List<GradientPrice> gradientPriceList = utilPrice.getGradientPriceList();
        for (GradientPrice gra : gradientPriceList) {
            //找到倒数第二个梯度，并将其的end设置为null
            if (Objects.equals(gradientPrice.getBeginning(), gra.getEnd())) {
                gra.setEnd(null);
                gradientPriceDao.updateByGradientPrice(gra);
            }
        }
        gradientPriceDao.deleteById(id);
    }

}
