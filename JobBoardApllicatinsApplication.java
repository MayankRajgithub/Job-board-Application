package com.jobboard.Job.Board.Apllicatins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.jobboard.Job.Board.Apllicatins.entity")
public class JobBoardApllicatinsApplication {

	public static void main(String[] args) {

		SpringApplication.run(JobBoardApllicatinsApplication.class, args);
	}

}
