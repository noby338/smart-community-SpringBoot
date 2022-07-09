package com.woniuxy.smart_community.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.dao.OwnerInfoDao;
import com.woniuxy.smart_community.dao.ParkingInfoDao;
import com.woniuxy.smart_community.entity.OwnersInfo;
import com.woniuxy.smart_community.entity.ParkingInfo;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.OwnersInfoService;
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

    @Autowired
    OwnerInfoDao ownerInfoDao;
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

    /**
     * 管理员更改车位信息
     * @param parkingInfo
     */
    @Override
    public void changeParkingInfo(ParkingInfo parkingInfo) {
        //车位信息更改可能也是用户信息更改
        System.out.println("修改车位信息--changeParkingInfo--impl");
        if(parkingInfo.getOwnersInfo()!=null){
            OwnersInfo ownersInfoUpdate=parkingInfo.getOwnersInfo();
//            OwnersInfo ownersInfo = ownerInfoDao.selectOwnerNameById(parkingInfo.getOwnersInfo().getId());
//            ownersInfoUpdate.setHouse(ownersInfo.getHouse());
            ownerInfoDao.updateOwnerByOwnerInfo(ownersInfoUpdate);
        }
        parkingInfoDao.updateParkingInfo(parkingInfo);
    }

    /**
     * 管理员删除车位信息
     * @param parkId
     */
    @Override
    public void removeParkingInfoByParkId(int parkId) {
        parkingInfoDao.deleteParkingInfoById(parkId);
    }

    /**
     * 管理员添加车位信息
     * @param parkingInfo
     */
    @Override
    public void addParkingInfo(ParkingInfo parkingInfo) {

        //判断没有必要，前端做传递验证不为空，
        //parkingType==1时，必须要有OwnersInfo
        //只有parkingType==3 or 4时，没有OwnersInfo
        if(parkingInfo.getParkingType().getId()==1 && parkingInfo.getOwnersInfo()==null){
            parkingInfo.getParkingType().setId(3);
        }
        parkingInfoDao.insertParkingInfo(parkingInfo);
    }
}
