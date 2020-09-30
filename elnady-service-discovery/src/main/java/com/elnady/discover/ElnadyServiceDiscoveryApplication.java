package com.elnady.discover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/** this service to save all service instances ips locations 
 * Service discovery can be something as simple as maintaining a property file with the addresses of all there mote services used by an application*/
@SpringBootApplication
@EnableEurekaServer
public class ElnadyServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElnadyServiceDiscoveryApplication.class, args);
	}

}
