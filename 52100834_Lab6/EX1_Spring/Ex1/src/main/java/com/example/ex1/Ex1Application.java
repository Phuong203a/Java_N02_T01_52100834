package com.example.ex1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Ex1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex1Application.class, args);
		ApplicationContext context= new ClassPathXmlApplicationContext("appConfig.xml");
		Product product1 =(Product) context.getBean("product1");
		Product product2 =(Product) context.getBean("product2");
		Product product3 =(Product) context.getBean("product3");

		System.out.println("Name of the bean 1: "+ product1);
		System.out.println("Name of the bean 1: "+ product2);
		System.out.println("Name of the bean 1: "+ product3);
	}

}
