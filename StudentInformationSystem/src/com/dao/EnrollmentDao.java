package com.dao;

import java.sql.SQLException;

import com.model.Enrollment;

public interface EnrollmentDao {

	int save(Enrollment enrollment) throws SQLException;



}
