package com.autodeskcrm.orgtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.autodeskcrm.gerericutils.BaseClass;
import com.autodestcrm.objectrepositorylib.CreateOrganization;
import com.autodestcrm.objectrepositorylib.Home;
import com.autodestcrm.objectrepositorylib.Organization;
import com.autodestcrm.objectrepositorylib.OrganizationIno;
/**
 * 
 * @author Deepak
 *
 */
public class CreateOrganizationTest extends BaseClass{
	@Test
	public void createORgWithTypeTest() throws Throwable {

		
		/* read test script specific data*/
		String orgName = excelLib.getExcelData("org", 1, 2)+ "_"+ wLib.getRamDomNum();
		String org_Type = excelLib.getExcelData("org", 1, 3);
		String org_industry = excelLib.getExcelData("org", 1, 4);

		
		/*step 3 : navigate to Org page*/
        Home hp = new Home(driver);
        hp.getOrgLink().click();
		
		/*step 4 : navigate to create new Org page*/
         Organization orgp = new Organization(driver);
         orgp.getCreteOrgImg().click();
		
		/*step 5 : create Org*/
         CreateOrganization createOrgP = new CreateOrganization(driver);
         createOrgP.creteOrg(orgName, org_Type, org_industry);
        		 
		/*step 6 : verify the Org*/
         OrganizationIno orgInfoP = new OrganizationIno(driver);
         String actMdg = orgInfoP.getOrgSucessfullMsgText().getText();

		Assert.assertTrue(actMdg.contains(orgName));
        		 
		
	}
	
	@Test
	public void createOrgTest() throws Throwable {
		/* read test script specific data*/
		String orgName = excelLib.getExcelData("org", 4 ,2)+ "_"+ wLib.getRamDomNum();
		/*step 3 : navigate to Org page*/
        Home hp = new Home(driver);
        hp.getOrgLink().click();
		
		/*step 4 : navigate to create new Org page*/
         Organization orgp = new Organization(driver);
         orgp.getCreteOrgImg().click();
		
		/*step 5 : create Org*/
         CreateOrganization createOrgP = new CreateOrganization(driver);
         createOrgP.creteOrg(orgName);
        		 
		/*step 6 : verify the Org*/
         OrganizationIno orgInfoP = new OrganizationIno(driver);
         String actMdg = orgInfoP.getOrgSucessfullMsgText().getText();

		Assert.assertTrue(actMdg.contains(orgName));
		

	}
	
	

}







