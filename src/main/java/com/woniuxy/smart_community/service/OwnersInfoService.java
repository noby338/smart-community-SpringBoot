package com.woniuxy.smart_community.service;

import com.woniuxy.smart_community.entity.OwnersInfo;


import java.util.List;

public interface OwnersInfoService {
//    主键查询
    OwnersInfo getOwnameByOwid(int owid);
//    业主名和电话查询
    OwnersInfo getOwnerByOwnameAndOwphone(String owname,String owphone);
//    通过业主所有信息查询
    OwnersInfo getOwnerByOwnerinfo(OwnersInfo ownersInfo);
//    查询所有
    List<OwnersInfo> getAllOwnersinfo();

//    添加用户信息
    void addOwnerinfo(OwnersInfo ownersInfo);

//    修改用户信息
    void changeOwnerinfoByOwnerinfo(OwnersInfo ownersInfo);

//    删除用户 管理员
    void removeOwnerByOwid(int owid);
}
