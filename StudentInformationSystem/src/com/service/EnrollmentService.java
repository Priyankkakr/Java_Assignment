package com.service;

import java.sql.SQLException;

import com.dao.EnrollmentDao;
import com.dao.EnrollmentDaoImpl;
import com.model.Enrollment;

public class EnrollmentService {
	EnrollmentDao dao = new EnrollmentDaoImpl();

	public int save(Enrollment enrollment) throws SQLException {
		return dao.save(enrollment);
	}


}
