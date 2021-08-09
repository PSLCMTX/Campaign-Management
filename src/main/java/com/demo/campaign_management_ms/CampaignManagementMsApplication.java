package com.demo.campaign_management_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.demo"} )
@EnableMongoRepositories("com.demo.campaign_management_ms_repo")
public class CampaignManagementMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampaignManagementMsApplication.class, args);
	}
	

}
