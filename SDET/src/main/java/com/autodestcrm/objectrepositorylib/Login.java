package com.autodestcrm.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodeskcrm.gerericutils.FileLib;
/**
 * 
 * @author Deepak
 *
 */
public class Login {                //Rule-1 
	
	
	@FindBy(name="user_name")          //Rule 2
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;


	public WebElement getUserNameEdt() {            //Rule 3 : single Element read access
		return userNameEdt;
	}


	public WebElement getPasswordEdt() {
		return passwordEdt;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void loginToApp(String username , String password) {   //Rule 4
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
		
	}
	
	public void loginToApp() throws Throwable {   //Rule 4
		FileLib flib = new FileLib();
		userNameEdt.sendKeys(flib.getPropertyKeyValue("username"));
		passwordEdt.sendKeys(flib.getPropertyKeyValue("password"));
		loginBtn.click();
		
	}
	public Login(WebDriver driver) {                             //Rule 5
		PageFactory.initElements(driver, this);
	}
	

}
