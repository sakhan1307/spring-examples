package com.springexample.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {

	public static void main(String[] args) {
	ApplicationContext context= new ClassPathXmlApplicationContext("hellobeans.xml");
	

		
		HelloWorld hello= (HelloWorld)context.getBean("hello");
		
		System.out.println("--HelloWorld -> "+hello.getGreeting());

	}

}
