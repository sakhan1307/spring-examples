package com.springexample.txn;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) throws Throwable {
        ApplicationContext context = new ClassPathXmlApplicationContext("txn-beans.xml");

        final BookShop bookShop = (BookShop) context.getBean("bookShop");

        Thread thread1 = new Thread(new Runnable() {
                    public void run() {
                        bookShop.checkStock("0001");
                    }
                }, "Thread 1");

        Thread thread2 = new Thread(new Runnable() {
                    public void run() {
                        try {
                            bookShop.increaseStock("0001", 5);
                        } catch (RuntimeException e) {
                        }
                    }
                }, "Thread 2");

        thread1.start();
        Thread.sleep(5000);
        thread2.start();
        
        final Cashier cashier = (Cashier) context.getBean("cashier");
        cashier.checkout(Arrays.asList("0001"), "user1");
    }
}
