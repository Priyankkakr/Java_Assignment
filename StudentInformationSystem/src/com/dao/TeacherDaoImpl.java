package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Course;
import com.model.Teacher;
import com.utility.dbLink;

public class TeacherDaoImpl implements TeacherDao {

	@Override
	public int save(Teacher teacher) throws SQLException {
		Connection con = dbLink.dbConnect();
		String sql = "insert into teacher (teacher_id, first_name, last_name, email)"
				+ "values(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,teacher.getTeacherId());
		pstmt.setString(2, teacher.getFirstName());
		pstmt.setString(3, teacher.getLastName());
		pstmt.setString(4, teacher.getEmail());
		int status = pstmt.executeUpdate(); 
		dbLink.dbClose();
		return status;
	}

	@Override
	public List<Teacher> findAll() throws SQLException {
		Connection con = dbLink.dbConnect();
		String sql = "select * from teacher ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Teacher> tlist = new ArrayList<>();
		while(rst.next()==true) {
			int teacherId = rst.getInt("teacher_id");
			String fname = rst.getString("first_name");
			String lname = rst.getString("last_code");
			String email = rst.getString("email");
			Teacher t = new Teacher(teacherId,fname,lname,email);
			tlist.add(t);
		}
		dbLink.dbClose();
		return tlist;
	}

}
