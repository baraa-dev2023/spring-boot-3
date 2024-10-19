package com.baraa.runnerz;

import com.baraa.runnerz.run.Location;
import com.baraa.runnerz.run.Run;
import com.baraa.runnerz.user.User;
import com.baraa.runnerz.user.UserHttpClient;
import com.baraa.runnerz.user.UserRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@SpringBootApplication
public class Application {

	// Logger to trace and record important events or messages during the program execution
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		// Start the Spring Boot application
		SpringApplication.run(Application.class, args);
	}


	@Bean
	UserHttpClient userHttpClient() {
		// Create a RestClient instance pointing to the base URL of the API
		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");

		// Create a HttpServiceProxyFactory using the RestClient
		HttpServiceProxyFactory factory = HttpServiceProxyFactory
				.builderFor(RestClientAdapter.create(restClient))
				.build();

		// Create and return an instance of UserHttpClient
		return factory.createClient(UserHttpClient.class);
	}

	// Define a bean for CommandLineRunner to execute code at startup
	@Bean
	CommandLineRunner runner(UserHttpClient client) {
		return args -> {

			var user =client.findAll();
			System.out.println(user);
		};
	}
}
