package com.springexample.jdbc.dao.hibenate;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;


@Repository("courseDao")
public class HibernateCourseDao implements CourseDao {
    private SessionFactory sessionFactory;
    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory=sessionFactory;
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public void store(Course course) {
        hibernateTemplate.saveOrUpdate(course);
    }

  
    public void delete(Long courseId) {
        Course course = (Course)hibernateTemplate.get(Course.class, courseId);
       hibernateTemplate.delete(course);
    }


    public Course findById(Long courseId) {
        return (Course) hibernateTemplate.get(Course.class, courseId);
    }


  
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Course");

        return query.list();
    }
}

