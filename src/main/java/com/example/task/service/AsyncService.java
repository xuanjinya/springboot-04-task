package com.example.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author huang.beijin
 * @date 2020/3/3 15:30
 * @description 异步任务
 */

@Service
public class AsyncService {

    //告诉 Spring 这是一个异步方法
    @Async
    public void hello() {
        try {
            //休眠3秒
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("处理数据中。。。");

    }
}
