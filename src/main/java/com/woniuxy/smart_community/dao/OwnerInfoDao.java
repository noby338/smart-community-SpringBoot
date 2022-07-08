package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.OwnersInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OwnerInfoDao {
//  查询区
    OwnersInfo selectOwnerNameById(int id);

    OwnersInfo selectOwnerByNameAndTelephone(@Param("name") String name,
                                           @Param("telephone") String telephone);

    OwnersInfo selectOwnerByOwnerInfo(@Param("ownersInfo") OwnersInfo ownersInfo);

    List<OwnersInfo> selectAllOwners();


//  insert添加车主
    //车主有房间信息就添加house_id
    //车主无房间信息就为空
    void insertOwnerInfo(@Param("ownersInfo") OwnersInfo ownersInfo);


//   update修改车主
    //车主有房间信息就添加house_id
    //车主无房间信息就为空
    void updateOwnerByOwnerInfo(@Param("ownersInfo") OwnersInfo ownersInfo);

//    delete  管理员使用
    //假删除
    //将车主信息状态置为0s
    void deleteOwnersById(int id);

}
