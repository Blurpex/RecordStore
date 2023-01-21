package edu.psu.oneupgames;

import org.h2.server.web.WebServlet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.servlet.http.HttpServlet;
import java.util.Arrays;

@SpringBootApplication
public class OneupgamesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneupgamesApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println(">>> beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}


	//
	// need to expose H2
	@Bean
	public ServletRegistrationBean<HttpServlet> h2ServletRegistrationBean() {
		var registrationBean = new ServletRegistrationBean<HttpServlet>(new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}
}
