package com.autodestcrm.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Deepak
 *
 */
public class OrganizationIno {
	public OrganizationIno(WebDriver driver) {                             //Rule 5
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgSucessfullMsgText;

	public WebElement getOrgSucessfullMsgText() {
		return orgSucessfullMsgText;
	}
	
	
	
}
