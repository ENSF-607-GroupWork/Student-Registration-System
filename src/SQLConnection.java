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
		String url= "jdbc:mysql://localhost:3306/607_assignment3"; // table details
		
		//MySQL Credentials
		String username = "root";
		String password = "WxIZz9vVrEH9";
		
		
		
		
		
		
		
		
		String query = "select *from student"; // query to be run
		Class.forName("com.mysql.cj.jdbc.Driver"); // Driver name
		
		Connection con = DriverManager.getConnection( url, username, password);
		System.out.println("Connection Established successfully");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query); // Execute query
		while ( rs.next() ) {
			
            int studentId = rs.getInt("studentId");

            System.out.println("Student ID: " + studentId);

            System.out.println("-----------------------");
        
		//String name = rs.getString("name"); // Retrieve name from db
		}

		st.close(); // close statement
		con.close(); // close connection
		System.out.println("Connection Closed....");
	
	}
}
