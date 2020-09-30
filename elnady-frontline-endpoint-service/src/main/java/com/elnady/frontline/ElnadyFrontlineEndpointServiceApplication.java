package com.elnady.frontline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
 /**
  * Developer: Mahmoud Ibrahim Ahmed
  * i use feignClient to call /persons endpoints it check the ip of persons service from discovey service 
  * when the frontline service calls persons service it will use Ribbon Algothim to see if the frontline service ips are cached locally
  *   
   */
@SpringBootApplication
@EnableFeignClients
public class ElnadyFrontlineEndpointServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElnadyFrontlineEndpointServiceApplication.class, args);
	}

}
