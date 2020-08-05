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
public class Contacts {
	
	public Contacts(WebDriver driver) {                             //Rule 5
		   
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement creteContactImg;

	public WebElement getcreteContactImg() {
		return creteContactImg;
	}

}
