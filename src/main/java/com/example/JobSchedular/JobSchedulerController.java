package com.example.JobSchedular;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/job")
public class JobSchedulerController {
    @Autowired
    private EmailSender emailSender;

    @Autowired
    private JobsQueue jobsQueue;

    @RequestMapping(method= RequestMethod.POST, path="/email")
    public String scheduleEmail(@RequestBody EmailDetails emailDetails){
//    public String scheduleEmail(@RequestBody Map<String, String> details){
        System.out.println("Received an Email Job");
//        EmailDetails emailDetails = new EmailDetails();
//        emailDetails.setSubject(details.get("subject"));
//        emailDetails.setText(details.get("text"));
//        emailDetails.setDestination(details.get("destination"));
        EmailingJob emailingJob = new EmailingJob(emailSender, emailDetails);
        this.jobsQueue.addJob(emailingJob);
        return "Job added successfully";
    }


}
