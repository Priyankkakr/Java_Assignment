package com.service;

import java.sql.SQLException;
import java.util.List;

import com.model.Student;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;

public class StudentService {
	StudentDao dao = new StudentDaoImpl();

	public List<Student> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public int save(Student student) throws SQLException {
		// TODO Auto-generated method stub
		return dao.save(student);
	}

}
