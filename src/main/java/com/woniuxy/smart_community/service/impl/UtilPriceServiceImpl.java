package com.woniuxy.smart_community.service.impl;

import com.woniuxy.smart_community.dao.UtilPriceDao;
import com.woniuxy.smart_community.entity.UtilPrice;
import com.woniuxy.smart_community.service.UtilPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
