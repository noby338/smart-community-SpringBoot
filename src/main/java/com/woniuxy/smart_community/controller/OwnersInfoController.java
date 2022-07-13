package com.woniuxy.smart_community.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.entity.OwnersInfo;
import com.woniuxy.smart_community.entity.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OwnersInfoController {

    /**
     * 分页查询用户信息
     * @param pageNum
     * @param pageSize
     * @param ownersInfo
     * @return
     */
    @PostMapping("/getAllOwnersInfo/{pageNum}/{pageSize}")
    public ResponseEntity<PageInfo<OwnersInfo>> getAllOwnersInfoByPage(@PathVariable int pageNum,
                                                                       @PathVariable int pageSize,
                                                                       @RequestBody OwnersInfo ownersInfo){
        ResponseEntity<PageInfo<OwnersInfo>> responseEntity=null;


        return null;


    }


    @GetMapping("/getOwnersInfo")
    public ResponseEntity<OwnersInfo> getOwnersInfoByOwnersInfo(@RequestBody OwnersInfo ownersInfo){

        return null;
    }


}
