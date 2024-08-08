package com.example.JobSchedular;
import java.sql.Timestamp;

public interface Job {
    void execute();
    Timestamp getTriggerTime();
}
