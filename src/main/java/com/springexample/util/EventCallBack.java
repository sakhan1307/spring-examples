package com.springexample.util;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;



public class EventCallBack {

	@PostConstruct
	public void open(){
		System.out.println("--Open--");
	}
	
	public void process(){
		System.out.println("--process--");
	}
	
	@PreDestroy
	public void close(){
		System.out.println("--Close--");
	}
}
