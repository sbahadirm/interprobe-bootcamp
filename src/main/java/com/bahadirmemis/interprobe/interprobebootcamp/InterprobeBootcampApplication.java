package com.bahadirmemis.interprobe.interprobebootcamp;

import com.bahadirmemis.interprobe.interprobebootcamp.springcore.WebService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class InterprobeBootcampApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(InterprobeBootcampApplication.class, args);

		WebService webService = applicationContext.getBean(WebService.class);
		webService.convertResponse();

	}

}
