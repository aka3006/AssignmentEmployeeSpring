package com.cognizant.AssignmentEmployeeSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan(basePackageClasses = com.aka.Employee.EmployeeController.class)
public class AssignmentEmployeeSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentEmployeeSpringApplication.class, args);
		System.out.println("Spring Boot Application launched successfully");
	}

}
