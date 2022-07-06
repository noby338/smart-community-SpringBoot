package com.woniuxy.smart_community.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//停车场管理业主信息
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OwnersInfo {
    private Integer owid;
    private String owname;
    private String owphone;
    private String owtype;  //人员状态
    private Integer id;//外键 关联住址
}
