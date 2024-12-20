package com.revature.message_publisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.client.RestTemplate;

import java.io.*;

@SpringBootApplication
public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(Main.class, args);

		BufferedReader text = new BufferedReader(new InputStreamReader(new ClassPathResource("lorem-ipsum.txt").getInputStream()));
		RestTemplate remote = new RestTemplate();

		while(text.ready()) {
			remote.postForEntity("http://localhost:8989/publish", text.readLine(), String.class);
			Thread.sleep(1000);
		}



	}

}
