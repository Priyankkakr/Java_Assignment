package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Course;

public interface CourseDao {

	List<Course> findAll() throws SQLException;

}
