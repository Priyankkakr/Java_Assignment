package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.CourseDao;
import com.dao.CourseDaoImpl;
import com.model.Course;
public class CourseService {
	CourseDao dao = new CourseDaoImpl();

	public List<Course> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
