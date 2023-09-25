package in.mindcraft.DButils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButils {
	private static Connection cn;
	public static Connection openConnection() throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost/product_schema";
		cn=DriverManager.getConnection(url,"root","root");
		return cn;
		
		
	}
	public static void closeConnection() throws SQLException {
		if(cn!=null) {
			cn.close();
		}
	}
}
