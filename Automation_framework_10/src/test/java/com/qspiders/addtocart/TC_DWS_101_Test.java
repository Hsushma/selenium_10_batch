package com.qspiders.addtocart;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qspiders.genericutility.BaseClass;
import com.qspiders.genericutility.ListnerUtility;
import com.qspiders.genericutility.WebDriverUtility;
import com.qspiders.objectrepository.ComputersPage;
import com.qspiders.objectrepository.HomePage;
import com.qspiders.objectrepository.ShoppingCartPage;
@Listeners(ListnerUtility.class)
public class TC_DWS_101_Test extends BaseClass
{
	public WebDriverUtility wu;
	@Test
	/**public void mousehoverComputers()
	{
		ExtentTest test = extReport.createTest("mousehoverComputers");
		cp=new ComputersPage(driver);
		cp.getComputers();
		wu.mousehover(cp.getComputers());
	}**/
	public void clicktoComputer()
	{
		ExtentTest test = extReport.createTest("clicktoComputer");
		test.log(Status.INFO, "User logged in sucessfully");
		
		cp=new ComputersPage(driver);
		cp.getComputers().click();
		
	}
	public void clickonDesktop()
	{
		ExtentTest test = extReport.createTest("clickonDesktop");
		test.log(Status.INFO, "clicked sucessfully");
		
		cp=new ComputersPage(driver);
		cp.getDesktops().click();
	}
	public void clicktoProduct()
	{
		ExtentTest test = extReport.createTest("clicktoProduct");
		test.log(Status.INFO, "User logged in sucessfully");
		
		cp=new ComputersPage(driver);
		cp.getAddtocart().click();
	}
	/**public void clickaddtoCart()
	{
		ExtentTest test = extReport.createTest("clickaddtoCart");
		cp= new ComputersPage(driver);
		cp.getDesktops().click();
		
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Simple Computer","Computer page is not displayed");
		test.log(Status.PASS, "Simple Computer Page is Displayed"); HEAD
	}**/
}
