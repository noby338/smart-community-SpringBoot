package com.woniuxy.smart_community.quartz;

import com.woniuxy.smart_community.quartz.job.ParkingUpdateStateJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail jobDetail(){
        JobDetail jobDetail= JobBuilder.newJob(ParkingUpdateStateJob.class)
                .withIdentity("job1", "group1")
                .withDescription("job1任务描述：车位过期更改购买状态")
                .storeDurably()
                .build();
        return jobDetail;
    }
    @Bean
    public Trigger trigger(){
        Trigger trigger= TriggerBuilder.newTrigger()
                .forJob(jobDetail())
                .withIdentity("trigger1","group1")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("* 0/1 * * * ? *"))
//                .withSchedule(SimpleScheduleBuilder.repeatHourlyForever(5))
                .build();
        return trigger;
    }


}
