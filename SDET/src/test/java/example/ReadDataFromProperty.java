package example;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;


/**
 * 
 * @author Deepak
 *
 */
public class ReadDataFromProperty {
	
	@Test
	public void createConatct() throws Throwable {
		
			/* step 1 : create java representation object of the physical File  */
			 FileInputStream fis = new FileInputStream("./resourse/commondata.properties");
			 
			/* step 2 : using properties class load all the Key in to java Object*/
			 Properties pObj = new Properties();
			 pObj.load(fis);
			 
			 /* step-3:read data from properties file */
			String value = pObj.getProperty("url");
			System.out.println(value);

	}

}






