package com.example.JobSchedular;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class Latency {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    private Long id;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    private Timestamp timestamp;

    public long getLatencyInMillis() {
        return latencyInMillis;
    }

    public void setLatencyInMillis(long latencyInMillis) {
        this.latencyInMillis = latencyInMillis;
    }

    private long latencyInMillis;





}
