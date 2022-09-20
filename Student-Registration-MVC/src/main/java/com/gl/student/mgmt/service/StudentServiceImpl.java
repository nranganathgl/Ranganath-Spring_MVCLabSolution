package com.gl.student.mgmt.service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gl.student.mgmt.entity.Student;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentServiceImpl implements StudentService{
	
	@Autowired
    private SessionFactory sessionFactory;

    private Session session;


    
    @Override
    @Transactional
    public List<Student> findAll() {
    	Session currentSession = sessionFactory.getCurrentSession();
        List<Student> studentsList = currentSession.createQuery("from Student").list();
        return studentsList;
    }
    
    @Override
    @Transactional
    public void save(Student theStudent) {
    	Session currentSession = sessionFactory.getCurrentSession();
    	currentSession.saveOrUpdate(theStudent);
    }

    @Override
    @Transactional
    public void updateById(int studentId) {

        Student student = new Student();
        Session currentSession = sessionFactory.getCurrentSession();
        student = currentSession.get(Student.class, studentId);
        currentSession.saveOrUpdate(student);
    }


    @Override
    @Transactional
    public void deleteById(int studentId) {

    	Session currentSession = sessionFactory.getCurrentSession();
    	Query<Student> createQuery = currentSession.createQuery("delete from Student where id=:student_id");
    	createQuery.setParameter("student_id", studentId);
    	createQuery.executeUpdate();
    }
    
    @Override
    @Transactional
    public Student getStudent(int studentId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Student student = currentSession.get(Student.class, studentId);
        return student;
    }
}
