package com.crud.tasks;

import com.crud.tasks.config.TunnerRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TasksApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
		TunnerRunner tunnerRunner = new TunnerRunner();
		tunnerRunner.executeGradleTaskAsynchronously();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TasksApplication.class);
	}
}
