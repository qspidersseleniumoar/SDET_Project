package example;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(com.autodeskcrm.gerericutils.ListImgClass.class)
public class ScreenShotTest {

	public static WebDriver driver = new FirefoxDriver();
	
	@Test
	public void createContactTest() throws IOException {
		

		driver.get("http://flipkart.com");
		
        Assert.assertEquals(true, false);
		
	
	}
}
