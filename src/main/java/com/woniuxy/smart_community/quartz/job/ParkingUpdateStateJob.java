package com.woniuxy.smart_community.quartz.job;

import com.woniuxy.smart_community.service.ParkingOrderListService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Date;

//注：只可以向后改系统时间，quartz底层可能自带上次时间数字，向前修改无用.
//@Component
//public class ParkingUpdateStateJob extends QuartzJobBean {
//
//    @Autowired
//    DataSource dataSource;
//    @Autowired
//    ParkingOrderListService parkingOrderListService;
//
//    @Override
//    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        parkingOrderListService.orderExpirationCheck();
//    }
//}
