package com.example.JobSchedular;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

//Study PriorityBlockingQueue
@Component
public class JobsQueue {
    private final PriorityBlockingQueue<Job> quedJobs;
    //why final?

    public JobsQueue() {
        this.quedJobs = new PriorityBlockingQueue<>(
                10,
                new Comparator<Job>() {
                    @Override
                    public int compare(Job o1, Job o2) {
                        return o1.getTriggerTime().compareTo(o2.getTriggerTime());
                    }
                }
        );
    }

    public void addJob(Job job){
//        System.out.println("addJob");
        this.quedJobs.put(job);
    }

    public Job remove() throws InterruptedException {
        return this.quedJobs.take();
    }


}
