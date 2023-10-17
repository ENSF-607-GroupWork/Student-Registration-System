// This code is for establishing connection with MySQL
// database and retrieving data
// from db Java Database connectivity

/*
*1. import --->java.sql
*2. load and register the driver ---> com.jdbc.
*3. create connection
*4. create a statement
*5. execute the query
*6. process the results
*7. close
*/

import java.io.*;
import java.sql.*;

class SQLConnection {
	public static void main(String[] args) throws Exception
	{
		try {
			String url= "jdbc:mysql://localhost:3306/607_assignment3"; // URL for database location
			Class.forName("com.mysql.cj.jdbc.Driver"); // Driver name
			
			//MySQL Credentials
			String username = "root"; //username credentials
			String password = "WxIZz9vVrEH9"; //password credentials
			
			String query1 = "select *from student"; //QUERY Number 1 - Get all students
			String query2 = "select *from course"; //QUERY Number 2 - Get all courses
			String query3 = "select *from registration"; //QUERY Number 3 - Get all registrations
			
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established successfully"); //prints if the connection was successful
			Statement st1 = con.createStatement(); //create statement for students database
			Statement st2 = con.createStatement(); //create statement for courses database
			Statement st3 = con.createStatement(); //create statement for registrations database
			
			ResultSet rs1 = st1.executeQuery(query1); //Query the students database for all students 
			ResultSet rs2 = st2.executeQuery(query2); //Query the courses database for all courses 
			ResultSet rs3 = st3.executeQuery(query3);//Query the registration atabase for all registrations 
			

			//EXECUTE and print results for Query #1 - Students Table
	        System.out.println("PRINTING ENTIRE STUDENT TABLE BELOW");
			while ( rs1.next() ) {
	            String studentId = rs1.getString("studentId");
	            String FirstName = rs1.getString("FirstName");
	            String LastName = rs1.getString("LastName");
	            String Location = rs1.getString("Location");

	            System.out.println("Student ID: " + studentId + " | First Name: " + FirstName + " | Last Name: " + LastName +  " | Location: " + Location);
			}
	        System.out.println("-----------------------"); //delimeter between tables

	        
			//EXECUTE and print results for Query #2 - Course Table
	        System.out.println("PRINTING ENTIRE COURSE TABLE BELOW");
			while ( rs2.next() ) {
	            String CourseId = rs2.getString("courseId");
	            String CourseName = rs2.getString("CourseName");
	            String CourseTitle = rs2.getString("CourseTitle");

	            System.out.println("Course ID: " + CourseId + " | Course Name: " + CourseName + " | Course Title: " + CourseTitle);
			}
	        System.out.println("-----------------------"); //delimeter between tables

			
			//EXECUTE and print results for Query #3 - Registration Table
	        System.out.println("PRINTING ENTIRE REGISTRATION TABLE BELOW");
			while ( rs3.next() ) {
	            String RegistrationId = rs3.getString("RegistrationId");
	            String StudentId = rs3.getString("StudentId");
	            String CourseId = rs3.getString("CourseId");

	            System.out.println("Registration ID: " + RegistrationId + " | Student ID: " + StudentId + " | Course ID: " + CourseId);
			} 
	        System.out.println("-----------------------"); //delimeter between tables

			st1.close(); // close statement 1
			st2.close(); // close statement 2
			st3.close(); // close statement 3
			con.close(); // close connection with the database
			System.out.println("Connection Closed...."); //print that the connection has been closed

		} catch (SQLException e) {

			e.printStackTrace(); //print error message if the connection was not established successfully
		}
	
	} 
} 
