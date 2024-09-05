package bookLink;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
	private String url = "jdbc:mysql://localhost:3306/booklink";
	private String username = "root";
	private String password = "";
	
	public Connection con;
	
	
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Database Connection Successfully");
		}catch(Exception e) {
			System.err.println("Failed to Connect");
			e.printStackTrace();
		}
	}
}
