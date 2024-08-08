package com.example.JobSchedular;


import jakarta.mail.MessagingException;

import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class EmailSender {
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private LatencyRepository latencyRepository;

    public void send(String to, String subject, String text) {
        long startTime = System.currentTimeMillis();
        try{
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true);
            emailSender.send(message);
        }
        catch(MessagingException e){
            e.printStackTrace();
        }

        long endTime=System.currentTimeMillis();
        Latency latency = new Latency();
        latency.setLatencyInMillis(endTime-startTime);
        latency.setTimestamp(new Timestamp(startTime));
        latencyRepository.save(latency);
    }


}
