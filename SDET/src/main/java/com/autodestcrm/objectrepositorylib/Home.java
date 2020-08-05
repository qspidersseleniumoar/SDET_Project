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
public class Home extends WebDriverUtils{                      //Rule 1
	WebDriver driver;
	
	public Home(WebDriver driver) {                             //Rule 5
	    this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Contacts")                                 //Rule 2
	private WebElement conatctLink;
	
	
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignLink;

   
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	
	public WebElement getMoreLink() {
		return moreLink;
	}


	public WebElement getLogoutLnk() {
		return logoutLnk;
	}


	public WebElement getAdminImg() {
		return adminImg;
	}

	@FindBy(linkText="Sign Out")
	private WebElement logoutLnk;
	
	@FindBy(linkText="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	public WebElement getConatctLink() {                               //Rule 4
		return conatctLink;
	}


	public WebElement getOrgLink() {
		return orgLink;
	}


	public WebElement getCampaignLink() {
		return campaignLink;
	}
	
	/**
	 * logout from the application
	 */
    public void navigateCampaign() {
    	
    	moveMouseToElemnet(driver, moreLink);
    	waitForElemnetVsibility(driver, campaignLink);
    	campaignLink.click();
    }

}




