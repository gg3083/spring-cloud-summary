package com.gg.backend.task;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Scheduler来调度Trigger和JobDetil
 * JobDetail来实例化Job类并可以传值
 */
@Configuration
public class MyScheduler {

    @Bean(name = "JobDetail")
    public JobDetail simpleJobDetail(){

        JobDetail jobDetail = JobBuilder.newJob(QuartzTaskJob.class).withIdentity("eclipse")
                .usingJobData("key","value").storeDurably().build();
        return jobDetail;
    }

    @Bean(name = "trigger")
    public Trigger simpleJobTrigger(){

        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInHours(1).repeatForever();

        return TriggerBuilder.newTrigger().forJob(simpleJobDetail())
                .withIdentity("sampleTrigger").withSchedule(scheduleBuilder).build();
    }
}