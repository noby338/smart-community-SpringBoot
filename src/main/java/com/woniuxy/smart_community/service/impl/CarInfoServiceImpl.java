package com.woniuxy.smart_community.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.dao.CarInfoDao;
import com.woniuxy.smart_community.dao.HouseDao;
import com.woniuxy.smart_community.dao.OwnerInfoDao;
import com.woniuxy.smart_community.dao.ParkingInfoDao;
import com.woniuxy.smart_community.entity.*;
import com.woniuxy.smart_community.service.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author LittleCode
 * @Date 2022/7/6 17:57
 */
@Service
public class CarInfoServiceImpl implements CarInfoService {
    @Autowired
    CarInfoDao carInfoDao;
    @Value("${view.carJpg}")
    private String carJpgPre;

    @Autowired
    ParkingInfoDao parkingInfoDao;
    @Autowired
    OwnerInfoDao ownerInfoDao;
    @Autowired
    HouseDao houseDao;

    @Override
    public PageInfo<CarInfo> getAllCarInfo(int pageIndex,int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<CarInfo> carInfos=carInfoDao.selectAllCarInfos();
        for(CarInfo carInfo:carInfos){
            String carJpg = carInfo.getCarJpg();
            if(carJpg!=null){
                carInfo.setCarJpg(carJpgPre+carJpg);
            }
        }
        PageInfo<CarInfo> pageInfo=new PageInfo<>(carInfos);
        int total=carInfoDao.selectCountCarInfo();
        pageInfo.setTotal(total);
        return pageInfo;
    }

    @Override
    public List<ForSelect> getALLParkingInfoIdAndParkNumber(int parkId,int ownerId) {
        List<ForSelect> forSelects=new ArrayList<ForSelect>();
        List<ParkingInfo> parkingInfos=parkingInfoDao.selectParkingListByOwnerId(ownerId);

        for(ParkingInfo parkingInfo:parkingInfos){
            ForSelect forSelect=new ForSelect();
            forSelect.setValue(parkingInfo.getId());
            forSelect.setLabel(parkingInfo.getParkNumber());
            if(parkingInfo.getId()==parkId){
                forSelect.setLabel(parkingInfo.getParkNumber()+"(当前使用)");
                forSelect.setDisabled(true);
            }
            CarInfo carInfo=carInfoDao.selectCarByParkId(parkingInfo.getId());
            if(carInfo!=null && parkingInfo.getId()!=parkId){
                forSelect.setLabel(parkingInfo.getParkNumber()+"(已被使用)");
                forSelect.setDisabled(true);
            }
            forSelects.add(forSelect);
        }
        return forSelects;
    }
    @Override
    public List<ForSelect> getAllCarOwnersIdAndName(int id) {
        List<ForSelect> forSelects=new ArrayList<ForSelect>();
        List<OwnersInfo> ownersInfos=ownerInfoDao.selectAllOwners();
        for(OwnersInfo ownersInfo:ownersInfos){
            ForSelect forSelect=new ForSelect();
            forSelect.setValue(ownersInfo.getId());
            forSelect.setLabel(ownersInfo.getName()+"("+ownersInfo.getTelephone()+")");
            if(ownersInfo.getId()==id){
                forSelect.setLabel(ownersInfo.getName()+"(当前使用)");
                forSelect.setDisabled(true);
            }
            forSelects.add(forSelect);
        }
        return forSelects;
    }

    @Override
    public List<ForSelect> getAllHouse() {
        List<ForSelect> forSelects=new ArrayList<ForSelect>();
        List<House> houseList=houseDao.selectAllHouseForCarShow();
        for(House house:houseList){
            ForSelect forSelect=new ForSelect();
            forSelect.setValue(house.getId());
            forSelect.setLabel(house.getHouseNum());
            forSelects.add(forSelect);
        }
        return forSelects;
    }

    @Override
    public void changeParkIdByCarId(int carId, int parkId) {
        carInfoDao.updateCarInfoByIdAndParkId(carId,parkId);
    }

    @Override
    public void changeOwnerIdByCarId(int ownerId, int carId) {
        carInfoDao.updateCarInfoByIdAndOwnerId(carId,ownerId);
    }

    @Override
    public int changeCarNumber(int carId, String carNumber) {
        CarInfo carInfo=carInfoDao.selectCarIfoByCarNumber(carNumber);
        if(carInfo!=null){
            return 1;
        }else {
            carInfoDao.updateCarNumberById(carNumber,carId);
            return 0;
        }
    }


    @Override
    public void addImgAddress(String carNumber, String imgAddress) {
        carInfoDao.updateImgByCarNumber(carNumber,imgAddress);
    }

}
