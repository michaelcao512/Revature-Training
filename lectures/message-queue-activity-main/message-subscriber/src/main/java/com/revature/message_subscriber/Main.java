package com.revature.message_subscriber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Main.class, args);
		Environment env = context.getBean(Environment.class);

		RestTemplate remote = new RestTemplate();
		SubscriptionDto sub = new SubscriptionDto("http://localhost", env.getProperty("server.port"), "/processMessage");
		ResponseEntity<String> response = remote.postForEntity("http://localhost:8989/subscribe", sub, String.class);
		System.out.println("Subscribing...\nQueue response: " + response.getBody());

	}

}
