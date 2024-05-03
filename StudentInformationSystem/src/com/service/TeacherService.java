package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.TeacherDao;
import com.dao.TeacherDaoImpl;
import com.model.Teacher;

public class TeacherService {
	TeacherDao dao = new TeacherDaoImpl();

	public int save(Teacher teacher) throws SQLException {
		// TODO Auto-generated method stub
		return dao.save(teacher);
	}

	public List<Teacher> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
