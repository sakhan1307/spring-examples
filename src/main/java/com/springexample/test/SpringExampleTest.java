package com.springexample.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springexample.hello.HelloWorld;
import com.springexample.sequence.Address;
import com.springexample.sequence.Employee;
import com.springexample.sequence.SequenceGenerator;
import com.springexample.util.BeanScope;
import com.springexample.util.EventCallBack;
import com.springexample.util.UtilClass;

public class SpringExampleTest {public static void main(String[] args) {
	// TODO Auto-generated method stub
	ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
	
	HelloWorld hello= (HelloWorld)context.getBean("hello");
	
	System.out.println("--HelloWorld -> "+hello.getGreeting());
	
	

	SequenceGenerator sequence= (SequenceGenerator)context.getBean("sequence");
	
	System.out.println("--SequenceGenerator-> "+sequence.getSequence());
	System.out.println("--SequenceGenerator-> "+sequence.getSequence());
	
	Employee employee= (Employee)context.getBean("employee");
	
	Address addr = employee.getAddr();
	
	System.out.println("City name->"+addr.getCity());
	System.out.println("Addr1->"+addr.getAddr1());
	
	UtilClass util= (UtilClass)context.getBean("util");
	
	System.out.println("Merge name->"+util.getMerge());
	
	BeanScope scope= (BeanScope)context.getBean("scope");
	
	List<String> list = scope.getList();

	list.add("Mumbai");
	list.add("Pune");
	
	System.out.println("List size->"+list.size());
	
	BeanScope scope1= (BeanScope)context.getBean("scope");
	List<String> list1 = scope1.getList();	
	System.out.println("List size1->"+list1.size());
	
	
	EventCallBack event= (EventCallBack)context.getBean("event");
	event.process();
	
}
}
