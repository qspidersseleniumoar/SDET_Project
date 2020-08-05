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
public class CoantctInfoPage {
	
	public CoantctInfoPage(WebDriver driver) {                             //Rule 5
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contSucessfullMsgText;

	public WebElement getContSucessfullMsgText() {
		return contSucessfullMsgText;
	}



}
