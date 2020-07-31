package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;


import com.mysql.jdbc.Driver;


/**
 * 
 * @author Deepak
 *
 */
public class ExecuteNonSelectQuery {
	
	@Test
	public void createConatct() throws Throwable {
		
     
		//step 1 : register the mysql database-Driver  
		
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		 //step 2 : connect to database 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak_oar", "root", "admin");
		
		//step 3 : create statement
		Statement stat = con.createStatement();
		String query = "insert into employe values(1, 'fn' , 'ln' , 'mn')";
		
		//step 4 : execute Query 
		int result = stat.executeUpdate(query);
		
	     System.out.println(result);       
		

		 //step 5 : close the connection 
		con.close();
	}

}






