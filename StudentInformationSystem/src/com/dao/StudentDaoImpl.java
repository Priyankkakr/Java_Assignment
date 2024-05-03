package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Student;
import com.utility.dbLink;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> findAll() throws SQLException {
		Connection con = dbLink.dbConnect();
		String sql = "select * from Student ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Student> listapp = new ArrayList<>();
		while(rst.next()==true) {
			int studentId = rst.getInt("student_id");
			String fname = rst.getString("first_name");
			String lname = rst.getString("last_name");
			String dob = rst.getString("date_of_birth");
			String email = rst.getString("email");
			String Phone = rst.getString("Phone_number");
			Student stu = new Student(studentId,fname,lname,dob,email,Phone);
			listapp.add(stu);
		}
		dbLink.dbClose();
		return listapp;
	}

	@Override
	public int save(Student student) throws SQLException {
		Connection con = dbLink.dbConnect();
		String sql = "insert into student (student_id, first_name,last_name,Date_of_birth,email,phone_number)"
				+ "values(?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,student.getStudentId());
		pstmt.setString(2, student.getFirstName());
		pstmt.setString(3, student.getLastName());
		pstmt.setString(4, student.getDateOfBirth());
		int status = pstmt.executeUpdate(); 
		dbLink.dbClose();
		return status;
	}

	

}
