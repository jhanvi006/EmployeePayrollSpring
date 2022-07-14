package com.bridgelabz.EmployeePayrollApp;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class EmployeePayrollAppApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(EmployeePayrollAppApplication.class, args);
		log.info("Welcome to Employee Payroll App.");
		log.info("Employee Payroll App started in {} Environment",
				context.getEnvironment().getProperty("environment"));
	}

}
