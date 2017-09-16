package com.springexample.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springexample.sequence.SequenceService;

public class SequenceTest {public static void main(String[] args) {
	ApplicationContext context =
	new ClassPathXmlApplicationContext("beans.xml");
	SequenceService sequenceService =
	(SequenceService) context.getBean("sequenceService");
	System.out.println(sequenceService.generate("IT"));
	System.out.println(sequenceService.generate("IT"));
}
}
