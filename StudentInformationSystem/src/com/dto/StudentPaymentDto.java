package com.dto;

public class StudentPaymentDto {
	private String firstName;
	private String lastName;
	private double amount;
	private String paymentDate;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public StudentPaymentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentPaymentDto(String firstName, String lastName, double amount, String paymentDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}
	@Override
	public String toString() {
		return "StudentPaymentDto [firstName=" + firstName + ", lastName=" + lastName + ", amount=" + amount
				+ ", paymentDate=" + paymentDate + "]";
	}

}
