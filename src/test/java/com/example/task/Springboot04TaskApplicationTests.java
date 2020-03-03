package com.example.task;

import com.sun.deploy.uitoolkit.ui.ModalityHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot04TaskApplicationTests {


    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
    }

    //创建一个简单的邮件模板发送
    @Test
    public void test01() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("通知");
        simpleMailMessage.setText("今晚7：30开会");
        simpleMailMessage.setTo("xuanjinya@gmail.com");
        simpleMailMessage.setFrom("hbj1067998193@qq.com");
        System.out.println(simpleMailMessage);
        mailSender.send(simpleMailMessage);
    }

    //创建一个复杂的邮件发送
    @Test
    public void test02() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setSubject("通知--今晚开会！");
        mimeMessageHelper.setText("<b style='color:red'>今天7：30开会</b>",true);
        mimeMessageHelper.setTo("xuanjinya@gmail.com");
        mimeMessageHelper.setFrom("hbj1067998193@qq.com");

        //上传文件
        mimeMessageHelper.addAttachment("1.jpg", new File("H:\\资料\\照片头像\\炫金\\1.jpg"));
        mimeMessageHelper.addAttachment("2.jpg", new File("H:\\资料\\照片头像\\炫金\\2.jpg"));
        mailSender.send(mimeMessage);
    }

}
