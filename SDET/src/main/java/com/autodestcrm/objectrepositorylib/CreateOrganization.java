package com.autodestcrm.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodeskcrm.gerericutils.WebDriverUtils;
/**
 * 
 * @author Deepak
 *
 */
public class CreateOrganization extends WebDriverUtils{
	
	public CreateOrganization(WebDriver driver) {                             //Rule 5
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement ognNameEdt;
	
	
	@FindBy(name="industry")
	private WebElement industiesLst;
	
	
	@FindBy(name="accounttype")
	private WebElement accoutTypeLst;
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
    

	
	/**
	 *  create  organization with mandate details
	 * @param orgName
	 */
	public void creteOrg(String orgName) {
		ognNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	/**
	 * create  organization with below param details
	 * @param orgName
	 * @param orgType
	 * @param orgIndusties
	 */
	public void creteOrg(String orgName , String orgType ,String orgIndusties ) {
		ognNameEdt.sendKeys(orgName);
		select(industiesLst, orgIndusties);
		select(accoutTypeLst, orgType);
		saveBtn.click();
	}
}
