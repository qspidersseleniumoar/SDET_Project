package com.autodeskcrm.gerericutils;

import java.awt.Desktop.Action;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author Deepak
 *
 */
public class WebDriverUtils {
	
	/**
	 * wait for all element to load in DOM document
	 * @param driver
	 */
	public void waitForPagetoLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * wait for  visibility of specific element in GUI
	 * @param driver
	 */
	public void waitForElemnetVsibility(WebDriver driver, WebElement expElemnet) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(expElemnet));
	}
	
	/**
	 * wait for  page title to be available
	 * @param driver
	 */
	public void waitForPageTitleVsibility(WebDriver driver, String pageTitle) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(pageTitle));
	}
	
	/**
	 * wait for  any element
	 * @param driver
	 * @throws InterruptedException 
	 */
	public boolean waitForAnyElement(WebDriver driver, WebElement expElement) throws InterruptedException {
		boolean flag = false;
		int count =0;
		while(count < 30) {
		      try {
		    	  expElement.isDisplayed();
		    	  flag=true;
		    	  break;
		      }catch(Throwable t) {
		    	  count++;
		    	  Thread.sleep(500);
		      }
		}
		return flag;
	}
	
	/**
	 * wait and click an element
	 * @param driver
	 * @throws InterruptedException 
	 */
	public boolean waitAndClickElement(WebDriver driver, WebElement expElement) throws InterruptedException {
		boolean flag = false;
		int count =0;
		while(count < 30) {
		      try {
		    	  expElement.click();
		    	  flag=true;
		    	  break;
		      }catch(Throwable t) {
		    	  count++;
		    	  Thread.sleep(1000);
		      }
		}
		return flag;
	}
	
	/**
	 * select the value from the dropdown based on visibleText
	 * @param dropDwonElemnet
	 * @param text
	 */
	public void select(WebElement dropDwonElemnet , String text) {
		Select sel = new Select(dropDwonElemnet);
		sel.selectByVisibleText(text);
		
	}
	
	/**
	 * select the value from the dropdown based on index
	 * @param dropDwonElemnet
	 * @param text
	 */
	public void select(WebElement dropDwonElemnet , int index) {
		Select sel = new Select(dropDwonElemnet);
		sel.selectByIndex(index);
		
	}
	
	/**
	 * switch to new Window
	 * @param driver
	 * @param pageTitle
	 */
	
	public void switchToNewTab(WebDriver driver, String pageTitle) {
		 Set<String> set = driver.getWindowHandles();
		 Iterator<String> it = set.iterator();
		 
		 while (it.hasNext()) {
			 String winID = it.next();
			 driver.switchTo().window(winID);
		      String currentPageTitle = driver.getTitle();
		      if(currentPageTitle.contains(pageTitle)) {
		    	  break;
		      }
			
		}
	}
	
	public void alertOk(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void alertCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		
	}
	
     public void moveMouseToElemnet(WebDriver driver , WebElement element) {
    	 Actions act= new Actions(driver);
    	 act.moveToElement(element).perform();
    			 
     }
     
     public void doubleClcik(WebDriver driver , WebElement element) {
    	 Actions act= new Actions(driver);
    	 act.doubleClick(element).perform();
    			 
     }
     public void rightClcik(WebDriver driver , WebElement element) {
    	 Actions act= new Actions(driver);
    	 act.contextClick(element).perform();
    			 
     }
     
     public int getRamDomNum() {
 		Random ranObj = new Random();
 		int randata =ranObj.nextInt(1000);
		return randata;
     }
     
     public void switchToFrame(WebDriver drver , String att) {
           drver.switchTo().frame(att);
     }
     public void switchToFrame(WebDriver drver , int index) {
         drver.switchTo().frame(index);
   }
     public void switchToFrame(WebDriver drver , WebElement elemnent) {
         drver.switchTo().frame(elemnent);
   }
     
     public void executeJavaScript(WebDriver driver  , String javaScript) {
    	 JavascriptExecutor js = (JavascriptExecutor)driver;
    	 js.executeScript(javaScript);
     }
     
}







