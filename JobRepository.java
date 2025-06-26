package com.jobboard.Job.Board.Apllicatins.repository;

import com.jobboard.Job.Board.Apllicatins.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
