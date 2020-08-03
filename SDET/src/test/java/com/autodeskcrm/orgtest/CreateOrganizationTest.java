package com.autodeskcrm.orgtest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.dfp.Dfp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * 
 * @author Deepak
 *
 */
public class CreateOrganizationTest {
	
	@Test
	public void createORgtest() throws Throwable {
		
		Random ranObj = new Random();
		int randata =ranObj.nextInt(1000);
         
		
		/*read data*/
		String orgName = "SkillRaray_"+randata;
		String org_Type = "customer";
		String org_industry = "Banking";
		
		/*step 1 : launch the browser*/
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		/*step 2 : login*/
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		
		/*step 3 : navigate to Org page*/
		driver.findElement(By.linkText("Organizations")).click();
		
		
		/*step 4 : navigate to create new Org page*/
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		/*step 5 : create Org*/
		driver.findElement(By.name("accountname")).sendKeys(orgName);
	
		
		WebElement  swb1 = driver.findElement(By.name("accounttype"));
		Select sel1 = new Select(swb1);
				sel1.selectByVisibleText(org_Type);
				
		WebElement  swb2 = driver.findElement(By.name("industry"));
		Select sel2 = new Select(swb2);
				sel2.selectByVisibleText(org_industry);
				
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		/*step 6 : verify the Org*/
		String actOrgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		Assert.assertTrue(actOrgName.contains(orgName));
		
		/*step 1 : logout*/
		WebElement wb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(wb).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		
		
		
		
	}

}
