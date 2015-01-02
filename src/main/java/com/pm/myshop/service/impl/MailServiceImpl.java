package com.pm.myshop.service.impl;


import com.pm.myshop.service.MailService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    @Async
    public void sendMail(String to, String subject, String body) {
        try
        {
            MimeMessage message = mailSender.createMimeMessage();
            
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom("pm.myshop@gmail.com");
            helper.setSubject(subject);
            helper.setTo(to);
            helper.setText(body,true);
            
            mailSender.send(message);
            
        } catch (MessagingException ex)
        {
            Logger.getLogger(MailServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
