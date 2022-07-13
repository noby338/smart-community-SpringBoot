package com.woniuxy.smart_community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description 用于返回前端的级联查询对象
 * @Author noby
 * @Date 2022/7/12 20:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cascade {
    private String value;
    private String label;
    private List<Cascade> children;
}
