package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.PaymentDao;
import com.dao.PaymentDaoImpl;
import com.dto.StudentPaymentDto;
import com.model.Payment;

public class PaymentService {
	PaymentDao dao = new PaymentDaoImpl();

	public List<StudentPaymentDto> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public List<Payment> findAllDetails() throws SQLException {
		return dao.findAllDetails();
	}

}
