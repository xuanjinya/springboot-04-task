package com.example.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author huang.beijin
 * @date 2020/3/3 15:40
 * @description
 */
@Service
public class ScheduledService {

    /*
    * second (秒),minute（分）, hour（时）, day of month（日）, month（月）, day of week（周几）
    * {@code "0 * * * * MON-FRI"} 【MON-FRI：周一到周五  * ：任何时间  0：整秒】 周一到周五，每一分钟都启动一次  0--》* 周一到周五，每一分钟每一秒都启动一次
     * */
//    @Scheduled(cron = "0 * * * * MON-SAT")
//    @Scheduled(cron = "0,1,2,3,4,5 * * * * MON-SAT")
//    @Scheduled(cron = "0-4 * * * * MON-SAT")
    @Scheduled(cron = "0/4 * * * * MON-SAT") //每4秒执行一次
    public void hello(){
        System.out.println("hello ... ");
    }

}
