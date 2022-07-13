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

    //修改change
    @Override
    public void changeOwnersInfoByOwnersInfo(OwnersInfo ownersInfo) {
        ownersInfoDao.updateOwnerByOwnerInfo(ownersInfo);
    }
}
