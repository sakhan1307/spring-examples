package com.springexample.jdbc.dao.hibenate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.GregorianCalendar;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc-hibernate-beans.xml"); 

        CourseDao courseDao = (CourseDao) context.getBean("courseDao");

//        Course course = new Course();
//        course.setTitle("Spring MVC");
//        course.setBeginDate(new GregorianCalendar(2007, 8, 1).getTime());
//        course.setEndDate(new GregorianCalendar(2007, 9, 1).getTime());
//        course.setFee(2000);
//        courseDao.store(course);
         List<Course> courses = courseDao.findAll();
         for(Course c:courses)
             System.out.println("ID="+c.getId());
       Long courseId = courses.get(0).getId();
       System.out.println(courseId);
       Course course = courseDao.findById(courseId);
        System.out.println("Course Title: " + course.getTitle());
       System.out.println("Begin Date: " + course.getBeginDate());
        System.out.println("End Date: " + course.getEndDate());
        System.out.println("Fee: " + course.getFee());

       //courseDao.delete(new Long(1));
    }
}

