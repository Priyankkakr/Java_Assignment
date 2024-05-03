package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Student;

public interface StudentDao {

	List<Student> findAll() throws SQLException;

	int save(Student student) throws SQLException;

}
