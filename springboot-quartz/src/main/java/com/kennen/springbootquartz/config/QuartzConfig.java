package com.kennen.springbootquartz.config;

import com.kennen.springbootquartz.job.MyTimeJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail printMyTimeJobDetail(){
        return JobBuilder.newJob(MyTimeJob.class)// 自定义的一个job类，负责工作内容的具体逻辑
                //  下面两行是定义JobDetail的具体信息，在自定义job类中可以通过context获取该JobDetail
                .withIdentity("MyTimeJob")  //  给JobDetail设置id
                //  每个JobDetail内都有一个Map，包含了关联到这个JobDetail的数据
                .usingJobData("msg", "Hello Springboot and Quartz")
                .storeDurably() //没有Trigger关联时，也保存该JobDetail
                .build();
    }
    
    @Bean
    public Trigger printTimeJobTrigger() {
        //  设置调度器的时间规则
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/1 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(printMyTimeJobDetail())   //  关联上述的JobDetail
                .withIdentity("TimeService")  //  给Trigger起个名字
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}