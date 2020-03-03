package com.example.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot04TaskApplicationTests {


    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test01(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("通知");
        simpleMailMessage.setText("今晚7：30开会");
        simpleMailMessage.setTo("xuanjinya@gmail.com");
        simpleMailMessage.setFrom("hbj1067998193@qq.com");
        System.out.println(simpleMailMessage);
        mailSender.send(simpleMailMessage);
    }

}
