package com.autdeskcrm.conatcttest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.autodeskcrm.gerericutils.BaseClass;
import com.autodestcrm.objectrepositorylib.CoantctInfoPage;
import com.autodestcrm.objectrepositorylib.Contacts;
import com.autodestcrm.objectrepositorylib.CreateOrganization;
import com.autodestcrm.objectrepositorylib.CreteContacts;
import com.autodestcrm.objectrepositorylib.Home;
import com.autodestcrm.objectrepositorylib.Organization;
/**
 * 
 * @author Deepak
 *
 */
public class CreateContacWithOrgNameTest extends BaseClass{
	
	@Test
	public void createContactWithOrgtest() throws Throwable {	
		/* read test script specific data*/
		String orgName = excelLib.getExcelData("contact", 1, 2)+ "_"+ wLib.getRamDomNum();
		String contactName = excelLib.getExcelData("contact", 1, 5);

		/*step 3 : navigate to Org page*/
        Home hp = new Home(driver);
        hp.getOrgLink().click();
		
		/*step 4 : navigate to create new Org page*/
         Organization orgp = new Organization(driver);
         orgp.getCreteOrgImg().click();
		
		/*step 5 : create Org*/
         CreateOrganization createOrgP = new CreateOrganization(driver);
         createOrgP.creteOrg(orgName);
		
		/*step 6 : navigate to Contact page*/
         Home hp1 = new Home(driver);
         wLib.waitAndClickElement(driver, hp1.getConatctLink());
		
		/*step 7 : navigate to create new Contact page*/
		Contacts cp = new Contacts(driver);
	   cp.getcreteContactImg().click();

		
		/*step 8: create new Contact page*/
		CreteContacts ccnp = new CreteContacts(driver);
		ccnp.creteConatct(contactName, orgName, "Organization Name");

		
		/*step  9: verify the Org*/
		CoantctInfoPage  cip = new CoantctInfoPage(driver);
		String actData = cip.getContSucessfullMsgText().getText();
		Assert.assertTrue(actData.contains(contactName));
		
	}

}
