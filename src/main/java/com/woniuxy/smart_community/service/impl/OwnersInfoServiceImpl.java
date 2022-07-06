package com.woniuxy.smart_community.service.impl;


import com.woniuxy.smart_community.dao.OwnerInfoDao;
import com.woniuxy.smart_community.entity.OwnersInfo;
import com.woniuxy.smart_community.service.OwnersInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @Author: LittleCode
 * @Date:   2022/7/6  
 * @Descrition:
 */
@Slf4j
@Service
public class OwnersInfoServiceImpl implements OwnersInfoService {

    @Autowired
    OwnerInfoDao ownersInfoDao;
//    查询get
    @Override
    public OwnersInfo getOwnameByOwid(int owid) {
        OwnersInfo ownersInfo = ownersInfoDao.selectOwnameByOwid(owid);
        log.debug("调用getOwnameByOwid方法，根据用户owid查询对象");
        return ownersInfo;
    }


    @Override
    public OwnersInfo getOwnerByOwnameAndOwphone(String owname, String owphone) {
        OwnersInfo ownersInfo = ownersInfoDao.selectOwnerByOwnameAndPhone(owname, owphone);
        return ownersInfo;
    }

    @Override
    public OwnersInfo getOwnerByOwnerinfo(OwnersInfo ownersInfo) {
        OwnersInfo findOwnersInfo = ownersInfoDao.selectOwnerByOwnerinfo(ownersInfo);
        return findOwnersInfo;
    }

    @Override
    public List<OwnersInfo> getAllOwnersinfo() {
        List<OwnersInfo> ownersInfos = ownersInfoDao.selectAll();
        return ownersInfos;
    }

//    添加add
    @Override
    public void addOwnerinfo(OwnersInfo ownersInfo) {
        ownersInfoDao.insertOwnerinfo(ownersInfo);
    }

//    修改change
    @Override
    public void changeOwnerinfoByOwnerinfo(OwnersInfo ownersInfo) {
        ownersInfoDao.updateOwnerByOwnerinfo(ownersInfo);
    }

//    删除 remove
    @Override
    public void removeOwnerByOwid(int owid) {
        ownersInfoDao.deleteOwnerByOwid(owid);
    }
}
