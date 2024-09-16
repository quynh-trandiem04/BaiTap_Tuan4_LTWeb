package vn.iostar.configs;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBMyconnect {
	public static Connection getConn()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?useSSL=false&useUnicode=true$characterEncoding=UTF-8",
					"root","123456");
			return conn;
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
