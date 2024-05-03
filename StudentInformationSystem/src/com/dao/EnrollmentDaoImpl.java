package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.Enrollment;
import com.utility.dbLink;

public class EnrollmentDaoImpl implements EnrollmentDao {

	@Override
	public int save(Enrollment enrollment) throws SQLException {
		Connection con = dbLink.dbConnect();
		String sql = "insert into enrollment (enrollment_id, student_id, course_id, enrollment_date)"
				+ "values(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,enrollment.getEnrollmentId());
		pstmt.setInt(2, enrollment.getStudentId());
		pstmt.setInt(3, enrollment.getCourseId());
		pstmt.setString(4, enrollment.getEnrollmentDate());
		int status = pstmt.executeUpdate(); 
		dbLink.dbClose();
		return status;
		
	}

}
