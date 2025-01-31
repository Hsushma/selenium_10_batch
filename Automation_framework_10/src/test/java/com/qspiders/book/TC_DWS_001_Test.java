package com.qspiders.book;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qspiders.genericutility.BaseClass;
import com.qspiders.genericutility.ListnerUtility;
import com.qspiders.objectrepository.HomePage;
@Listeners(ListnerUtility.class)
public class TC_DWS_001_Test extends BaseClass
{
	@Test
	public void clickonBooks()
	{
		ExtentTest test = extReport.createTest("clickOnBooks");
		hp= new HomePage(driver);
		hp.getBookslink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Books","Books page is not displayed");
		test.log(Status.PASS, "Books page is Displayed");
	}

}
