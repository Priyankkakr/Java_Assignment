package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Teacher;

public interface TeacherDao {

	int save(Teacher teacher) throws SQLException;

	List<Teacher> findAll() throws SQLException;

}
