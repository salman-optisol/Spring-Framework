package com.sallu.spring.gameapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GameApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(GameApplication.class, args);

		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();

		EmployeeConfiguration configuration = context.getBean(EmployeeConfiguration.class);
		System.out.println(configuration.getName() + " + " + configuration.getPassword());

	}

}
