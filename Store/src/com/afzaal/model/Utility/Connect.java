package com.afzaal.model.Utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	static Connection con;

	public static Connection creatc()  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Store","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return con;
	}
}
