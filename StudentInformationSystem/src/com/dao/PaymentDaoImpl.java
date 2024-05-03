package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.StudentPaymentDto;
import com.model.Payment;
import com.utility.dbLink;

public class PaymentDaoImpl implements PaymentDao {

	@Override
	public List<StudentPaymentDto> findAll() throws SQLException {
		Connection con = dbLink.dbConnect();
		String sql = "select s.first_name,s.last_name,p.amount,p.payment_date from payment p join student s on p.student_id = s.student_id;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<StudentPaymentDto> list= new ArrayList<>();
		while(rst.next()==true) {
			String fname = rst.getString("first_name");
			String lname = rst.getString("last_name");
			double amount = rst.getDouble("amount");
			String paymentDate = rst.getString("payment_date");
			StudentPaymentDto s = new StudentPaymentDto(fname,lname,amount,paymentDate);
			list.add(s);
		}
		dbLink.dbClose();
		return list;
	}


	@Override
	public List<Payment> findAllDetails() throws SQLException {
		Connection con = dbLink.dbConnect();
		String sql = " select * from payment ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Payment> list= new ArrayList<>();
		while(rst.next()==true) {
			int paymentid = rst.getInt("payment_id");
			int studentid = rst.getInt("student_id");
			double amount = rst.getDouble("amount");
			String paymentDate = rst.getString("payment_date");
			Payment p = new Payment(paymentid,studentid,amount,paymentDate);
			list.add(p);
		}
		dbLink.dbClose();
		return list;
	}

}
