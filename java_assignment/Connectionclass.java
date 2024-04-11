package Java_Assignment;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connectionclass {

	 private static Connection con;
	 
	 public static Connection getconnection()
	 {
		 if(con == null)
		 {
			 try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					String dbURL ="jdbc:mysql://localhost:3306/hospital";
					 con = DriverManager.getConnection(dbURL,"root","9988");
				}catch(Exception e)
				{
					System.out.println(e);
				}
		 }
		 return con;
	 }
}
