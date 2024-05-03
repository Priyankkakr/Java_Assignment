package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Course;
import com.model.Student;
import com.utility.dbLink;

public class CourseDaoImpl implements CourseDao{

	@Override
	public List<Course> findAll() throws SQLException {
		Connection con = dbLink.dbConnect();
		String sql = "select * from Course ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Course> courselist = new ArrayList<>();
		while(rst.next()==true) {
			int courseId = rst.getInt("course_id");
			String coursename = rst.getString("course_name");
			String coursecode = rst.getString("course_code");
			String insname = rst.getString("instructor_name");
			Course c = new Course(courseId,coursename,coursecode,insname);
			courselist.add(c);
		}
		dbLink.dbClose();
		return courselist;
	}

}
