package com.example.JobSchedular;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobSchedulerController {
    @Autowired
    private EmailSender emailSender;


}
