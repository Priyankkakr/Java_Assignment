package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.StudentPaymentDto;
import com.model.Payment;

public interface PaymentDao {

	List<StudentPaymentDto> findAll() throws SQLException;

	List<Payment> findAllDetails() throws SQLException;

}
