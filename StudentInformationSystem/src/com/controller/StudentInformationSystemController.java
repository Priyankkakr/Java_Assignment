package com.controller;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.dto.StudentPaymentDto;
import com.model.Course;
import com.model.Enrollment;
import com.model.Payment;
import com.model.Student;
import com.model.Teacher;
import com.service.CourseService;
import com.service.EnrollmentService;
import com.service.PaymentService;
import com.service.StudentService;
import com.service.TeacherService;

public class StudentInformationSystemController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentService studentService = new StudentService();
		CourseService courseService = new CourseService();
		EnrollmentService enrollmentService = new EnrollmentService();
		PaymentService paymentService = new PaymentService();
		TeacherService teacherService = new TeacherService();

		while(true) {
			System.out.println("1. Enroll Student in a course");
			System.out.println("2. Update a student in student record");
			System.out.println("3. Retrieve a student associated with payment");
			System.out.println("4. Retrieve payment details");
			System.out.println("5. Update teacher info");
			System.out.println("6. Display all teacher info");
			System.out.println("Press 0 to exit !!!");
			int input = sc.nextInt();
			if(input == 0) {
				System.out.println("Exited successfully");
				break;
				}
			switch(input) {
			case 1:
			    try {
			    	Enrollment enrollment = new Enrollment();
			    	Random random = new Random();
					int rN1 = random.nextInt(); 
					int enrollment_id =rN1<0?rN1*-1:rN1;
					enrollment.setEnrollmentId(enrollment_id);
					System.out.println("Enrollment ID: " + enrollment_id);
					
					List<Student> list1 = studentService.findAll();
					for(Student s : list1) {
						System.out.println(s);
					}
					
					System.out.println("Enter the student id :");
					enrollment.setStudentId(sc.nextInt());
					
					List<Course> list2 = courseService.findAll();
					for(Course c : list2) {
						System.out.println(c);
					}
					
					System.out.println("Enter the course id :");
					enrollment.setCourseId(sc.nextInt());
					
					LocalDateTime currentDate = LocalDateTime.now(); // the current date
			        String EnrollmentDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); // "YYYY-MM-DD"
				    System.out.println("Order_date:" + EnrollmentDate);
				    enrollment.setEnrollmentDate(EnrollmentDate);
					enrollmentService.save(enrollment);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    System.out.println("Enrolled successfully......");
			    break;
			    
			case 2:
				
				try {
					Student student = new Student();
					Random random1 = new Random();
					int rN2 = random1.nextInt(); 
					int student_id =rN2<0?rN2*-1:rN2;
					student.setStudentId(student_id);
					System.out.println("Student ID: " + student_id);
					
					System.out.println("Enter your first name ");
					sc.nextLine();
					student.setFirstName(sc.next());
					
					System.out.println("Enter your last name ");
					student.setLastName(sc.next());
					
					System.out.println("Enter your date of birth");
					student.setDateOfBirth(sc.next());
					
					System.out.println("Enter your email");
					student.setEmail(sc.next());
					
					System.out.println("Enter your phone number");
					student.setPhoneNumber(sc.next());
					
					studentService.save(student);
					System.out.println("Updated succesfully......");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			case 3:
			    
				try {
					List<StudentPaymentDto> paylist = paymentService.findAll();
					for(StudentPaymentDto s : paylist) {
				    	System.out.println(s);
				    }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 4:
				try {
					List<Payment> pay = paymentService.findAllDetails();
					for(Payment s : pay) {
				    	System.out.println(s);
				    }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 5:
				
				
				try {
					Teacher teacher = new Teacher();
					Random random2 = new Random();
					int rN3 = random2.nextInt(); 
					int teacher_id =rN3<0?rN3*-1:rN3;
					teacher.setTeacherId(teacher_id);
					System.out.println("Teacher ID: " + teacher_id);
					
					System.out.println("Enter your first name");
					sc.nextLine();
					teacher.setFirstName(sc.next());
					
					System.out.println("Enter your last name ");
					teacher.setLastName(sc.next());
					
					System.out.println("Enter youe email");
					teacher.setEmail(sc.next());
					teacherService.save(teacher);
					System.out.println("Updated teacher successfully......");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 6:
				
				try {
					List<Teacher> tlist = teacherService.findAll();
					for(Teacher t: tlist) {
						System.out.println(t);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			
				
			}
		}
		sc.close();
	}

}
