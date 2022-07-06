package com.woniuxy.smart_community.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.dao.ParkingInfoDao;
import com.woniuxy.smart_community.entity.ParkingInfo;
import com.woniuxy.smart_community.service.ParkingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author LittleCode
 * @Date 2022/7/6 17:52
 */
@Service
public class ParkingInfoServiceImpl implements ParkingInfoService {

    @Autowired
    ParkingInfoDao parkingInfoDao;

    @Override
    public List<ParkingInfo> getAllParkingInfo() {
        List<ParkingInfo> parkingInfos = parkingInfoDao.selectAllParkingInfo();
        return parkingInfos;
    }


    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @param parkingInfo
     * @return
     */
    @Override
    public PageInfo<ParkingInfo> getParkingInfoByPage(int pageNum, int pageSize, ParkingInfo parkingInfo) {
        PageHelper.startPage(pageNum,pageSize);
        List<ParkingInfo> parkingInfos = parkingInfoDao.selectParkingInfoByParkingInfo(parkingInfo);
        PageInfo<ParkingInfo> pageInfo=new PageInfo<ParkingInfo>(parkingInfos);
        //将单独查询的总条数赋值给pageInfo
        int total = parkingInfoDao.selectCount(parkingInfo);
        pageInfo.setTotal(total);
        System.out.println("最新total="+total);
        return pageInfo;
    }
}
