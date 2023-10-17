// SQLConnection.java
import java.sql.*;

/**
 * This Java program demonstrates connecting to a MySQL database,
 * executing queries, and retrieving data from the database.
 */
public class SQLConnection {
    public static void main(String[] args) throws Exception {
        try {
            // Define the URL of the MySQL database
            String url = "jdbc:mysql://localhost:3306/607_assignment3"; // Database URL

            // Load and register the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Set MySQL database credentials
            String username = "root"; // Database username
            String password = "WxIZz9vVrEH9"; // Database password

            // Define SQL queries
            String query1 = "SELECT * FROM student"; // Query #1: Get all students
            String query2 = "SELECT * FROM course"; // Query #2: Get all courses
            String query3 = "SELECT * FROM registration"; // Query #3: Get all registrations

            // Establish a connection to the database
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully"); // Print connection status

            // Create statements for executing SQL queries
            Statement st1 = con.createStatement(); // Statement for the students table
            Statement st2 = con.createStatement(); // Statement for the courses table
            Statement st3 = con.createStatement(); // Statement for the registrations table

            // Execute SQL queries and retrieve result sets
            ResultSet rs1 = st1.executeQuery(query1); // Execute Query #1: Students table
            ResultSet rs2 = st2.executeQuery(query2); // Execute Query #2: Courses table
            ResultSet rs3 = st3.executeQuery(query3); // Execute Query #3: Registrations table

            // Print results for Query #1 - Students Table
            System.out.println("PRINTING ENTIRE STUDENT TABLE BELOW");
            while (rs1.next()) {
                String studentId = rs1.getString("studentId");
                String firstName = rs1.getString("FirstName");
                String lastName = rs1.getString("LastName");
                String location = rs1.getString("Location");

                System.out.println("Student ID: " + studentId + " | First Name: " + firstName + " | Last Name: " + lastName + " | Location: " + location);
            }
            System.out.println("-----------------------"); // Delimiter between tables

            // Print results for Query #2 - Course Table
            System.out.println("PRINTING ENTIRE COURSE TABLE BELOW");
            while (rs2.next()) {
                String courseId = rs2.getString("courseId");
                String courseName = rs2.getString("CourseName");
                String courseTitle = rs2.getString("CourseTitle");

                System.out.println("Course ID: " + courseId + " | Course Name: " + courseName + " | Course Title: " + courseTitle);
            }
            System.out.println("-----------------------"); // Delimiter between tables

            // Print results for Query #3 - Registration Table
            System.out.println("PRINTING ENTIRE REGISTRATION TABLE BELOW");
            while (rs3.next()) {
                String registrationId = rs3.getString("RegistrationId");
                String studentId = rs3.getString("StudentId");
                String courseId = rs3.getString("CourseId");

                System.out.println("Registration ID: " + registrationId + " | Student ID: " + studentId + " | Course ID: " + courseId);
            }
            System.out.println("-----------------------"); // Delimiter between tables

            // Close statements and the database connection
            st1.close(); // Close statement 1
            st2.close(); // Close statement 2
            st3.close(); // Close statement 3
            con.close(); // Close the database connection
            System.out.println("Connection closed...."); // Print that the connection has been closed

        } catch (SQLException e) {
            e.printStackTrace(); // Print an error message if the connection was not established successfully
        }
    }
}

