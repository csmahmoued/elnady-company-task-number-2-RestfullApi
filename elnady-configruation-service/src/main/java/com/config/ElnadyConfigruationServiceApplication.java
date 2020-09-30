package com.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 	Developer: Mahmoud Ibrahim Ahmed
 	i used (@EnableConfigServer) for config database configs Independent of project
 	i store configrations in my github host https://github.com/csmahmoued/config-repo.git
 	
 		
 */
@SpringBootApplication
@EnableConfigServer
public class ElnadyConfigruationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElnadyConfigruationServiceApplication.class, args);
	}

}
