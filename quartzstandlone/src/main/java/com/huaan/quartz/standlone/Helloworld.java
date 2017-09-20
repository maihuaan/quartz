package com.huaan.quartz.standlone;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Helloworld {
    public static void main(String[] args) throws SchedulerException {

        JobDetail job = JobBuilder.newJob(HelloJob.class)
                .withIdentity("dummyJobName", "group1").build();

        // Trigger the job to run on the next round minute
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("dummyTriggerName", "group1")
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(5).repeatForever())
                .build();

        // schedule it
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);


    }
}
