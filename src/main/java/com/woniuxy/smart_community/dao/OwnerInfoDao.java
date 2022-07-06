package com.woniuxy.smart_community.dao;

import com.woniuxy.smart_community.entity.OwnersInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OwnerInfoDao {
//  查询区
    OwnersInfo selectOwnameByOwid(int owid);

    OwnersInfo selectOwnerByOwnameAndPhone(@Param("owname") String owname,
                                           @Param("owphone") String owphone);

    OwnersInfo selectOwnerByOwnerinfo(@Param("ownersInfo") OwnersInfo ownersInfo);

    List<OwnersInfo> selectAll();


//  insert添加
    void insertOwnerinfo(@Param("ownersInfo") OwnersInfo ownersInfo);


//   update
    void updateOwnerByOwnerinfo(@Param("ownersInfo") OwnersInfo ownersInfo);

//    delete  管理员使用
    void deleteOwnerByOwid(int owid);

}
