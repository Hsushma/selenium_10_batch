package com.qspiders.computers;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qspiders.genericutility.BaseClass;
import com.qspiders.genericutility.ListnerUtility;
import com.qspiders.objectrepository.HomePage;
@Listeners(ListnerUtility.class)
public class TC_DWS_010_Test extends BaseClass 
{
	@Test
	public void clickOnComputers()
	{
		ExtentTest test = extReport.createTest("clickOnComputers");
		test.log(Status.INFO, "User logged in sucessfully");
		
		hp=new HomePage(driver);
		hp.getComputerslink().click();
		Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Computers","computer page is not displayed");
		test.log(Status.PASS, "computer page is displayed");
	}

}
