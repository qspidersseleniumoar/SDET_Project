package com.autdeskcrm.conatcttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.autodeskcrm.gerericutils.ExcelLib;
import com.autodeskcrm.gerericutils.FileLib;
import com.autodeskcrm.gerericutils.WebDriverUtils;
/**
 * 
 * @author Deepak
 *
 */
public class CreateContacWithOrgNametTest {
	
	@Test
	public void createContactWithOrgtest() throws Throwable {
		

		WebDriverUtils wLib = new WebDriverUtils();
        FileLib fLib = new FileLib();
        ExcelLib excelLib = new ExcelLib();
		

		/* read data from property File */
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String URL = fLib.getPropertyKeyValue("url");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		
		/* read test script specific data*/
		String orgName = excelLib.getExcelData("contact", 1, 2)+ "_"+ wLib.getRamDomNum();
		String org_Type = excelLib.getExcelData("contact", 1, 3);
		String org_industry = excelLib.getExcelData("contact", 1, 4);
		String contactName = excelLib.getExcelData("contact", 1, 5);
		
		/*step 1 : launch the browser*/
		WebDriver driver = null;
		  
		 if(BROWSER.equals("chrome")) {
		   driver= new ChromeDriver();
		 } else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		 }else if(BROWSER.equals("ie")) {
				driver = new InternetExplorerDriver();
	     }else {
	    	 driver = new FirefoxDriver();
	     }
		 
		 
		wLib.waitForPagetoLoad(driver);
		driver.get(URL);
		
		/*step 2 : login*/
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		/*step 3 : navigate to Org page*/
		driver.findElement(By.linkText("Organizations")).click();
		
		
		/*step 4 : navigate to create new Org page*/
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		/*step 5 : create Org*/
		driver.findElement(By.name("accountname")).sendKeys(orgName);
	
		
		WebElement  swb1 = driver.findElement(By.name("accounttype"));
         wLib.select(swb1, org_Type);
				
		WebElement  swb2 = driver.findElement(By.name("industry"));
        wLib.select(swb2, org_industry);
				
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		/*step 6 : verify the Org*/
		String actOrgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		Assert.assertTrue(actOrgName.contains(orgName));
		
		
		/*step 7 : navigate to Contact page*/
		driver.findElement(By.linkText("Contacts")).click();
		
		/*step 8 : navigate to create new Contact page*/
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		/*step 9 : creat new Contact page*/
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		   //open new tab
	      wLib.switchToNewTab(driver, "specific_contact_account_address");
		
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(orgName)).click();
		
		//come back to parent Window
		wLib.switchToNewTab(driver, "Administrator - Contacts");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*step  10: verify the Org*/
		String actconatct = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(actconatct.contains(contactName));
		
		/*step 1 : logout*/
		WebElement wb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        wLib.moveMouseToElemnet(driver, wb);
		driver.findElement(By.linkText("Sign Out")).click();
		
		/*close browse*/
		
		
		
	}

}
