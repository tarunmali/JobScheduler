package com.example.JobSchedular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class Worker {
    @Autowired
    private JobsQueue jobsQueue;

    @Scheduled(fixedRate = 5000)
    public void work() throws InterruptedException {
        System.out.println("Worker is running");
        Job job= this.jobsQueue.remove();
        if(job.getTriggerTime().compareTo(new Timestamp(System.currentTimeMillis()))<=0) {
            job.execute();
        }
        else{
            this.jobsQueue.addJob(job);
        }

    }
}
