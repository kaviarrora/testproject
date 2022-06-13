package avactis.testproject;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.sql.Statement;
import java.sql.Connection;

public class JdbcConnection {

	public static void main(String[] args) throws SQLException {
		
		String host="localhost";
		String port="3306";
		
	    Connection con=DriverManager.getConnection("jdbc:mysql://"+host +":"+port +"/qadb", "root", "root");
		
		Statement s= con.createStatement();
		ResultSet rs = s.executeQuery("select*from usercredentials");
		rs.next();
		System.out.println(rs.getString("email"));
		System.out.println(rs.getString("password"));
		con.close();
		
		
		
		

	}

}
