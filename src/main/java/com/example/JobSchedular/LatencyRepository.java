package com.example.JobSchedular;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface LatencyRepository extends JpaRepository<Latency, Long> {
    @Query("SELECT m FROM Latency m WHERE m.timestamp >= :start AND m.timestamp <= :end")
    List<Latency> findLatenciesInRange(Timestamp start, Timestamp end);
}
