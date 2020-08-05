package com.autodestcrm.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Organization {
	
	
	public Organization(WebDriver driver) {                             //Rule 5
	   
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement creteOrgImg;

	public WebElement getCreteOrgImg() {
		return creteOrgImg;
	}
	
	@FindBy(id="search_txt")
	private WebElement searchEdt;
	
	
	@FindBy(name="search_field")
	private WebElement serchInLst;
	
	
	@FindBy(name="search")
	private WebElement searchBtn;

	public WebElement getSearchEdt() {
		return searchEdt;
	}


	public WebElement getSerchInLst() {
		return serchInLst;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
	

	

}
