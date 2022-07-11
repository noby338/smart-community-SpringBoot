package com.woniuxy.smart_community.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.dao.OwnerInfoDao;
import com.woniuxy.smart_community.dao.ParkingInfoDao;
import com.woniuxy.smart_community.dao.ParkingOrderListDao;
import com.woniuxy.smart_community.entity.*;
import com.woniuxy.smart_community.service.OwnersInfoService;
import com.woniuxy.smart_community.service.ParkingInfoService;
import com.woniuxy.smart_community.util.GetUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
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
    @Autowired
    ParkingOrderListDao parkingOrderListDao;

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


    /**
     * 添加车位交易订单信息
     * @param parkingInfo
     * @param parkingPrice
     * @param payType
     * @param expireTime
     */
    @Override
    public void addParkingInfoByParkingBusiness(ParkingInfo parkingInfo,String parkingPrice,String payType,int expireTime) {
        //1.将用户添加
        OwnersInfo ownersInfo=new OwnersInfo();
        ownersInfo=parkingInfo.getOwnersInfo();
        ownersInfo.setState(1);  //ownersInfo中用户类型不能为空，购买车位的都是小区业主=1
        ownerInfoDao.insertOwnerInfo(ownersInfo);
        int owId=ownersInfo.getId();
        //2.用户id和车位状态id--》更改车位信息
        //parkingInfoDao.updateParkingInfo(parkingInfo.getPTypeId(),owId,parkingInfo.getParkId());
        parkingInfoDao.updateParkingInfo(parkingInfo);
        //3.创建订单表信息
        String orderNo= GetUUID.UUID();
        BigDecimal price=new BigDecimal(parkingPrice);
        System.out.println("工具类中获取UUID编码"+orderNo+"----size="+orderNo.length());

        //判断是购买还是租用
        Calendar calendarEndTime=Calendar.getInstance();
        if(parkingInfo.getParkingType().getId()==1){
            calendarEndTime.add(calendarEndTime.YEAR,expireTime);
            System.out.println("车位有效期截至时间："+calendarEndTime);
        }else if(parkingInfo.getParkingType().getId()==2){
            calendarEndTime.add(calendarEndTime.MONTH, expireTime+1);
            System.out.println("车位有效期截至时间："+calendarEndTime);
        }
        Date date=calendarEndTime.getTime();
        ParkingOrderList parkingOrderList = new ParkingOrderList(null, orderNo, parkingInfo, new Date(), date, price, ownersInfo, parkingInfo.getParkingType(), payType, 1, null);
        //ParkingOrderList parkingOrderList = new ParkingOrderList(null,orderNo,parkingInfo.getId(),null,new Date(),date,price,owId,null,parkingInfo.getParkingType().getId(),null,payType,1,null);
        parkingOrderListDao.insertParkingOrderInfo(parkingOrderList);

    }
}
