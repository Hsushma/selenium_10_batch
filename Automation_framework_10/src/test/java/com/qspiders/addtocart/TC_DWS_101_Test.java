package com.qspiders.addtocart;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qspiders.genericutility.BaseClass;
import com.qspiders.genericutility.ListnerUtility;
import com.qspiders.objectrepository.ComputersPage;
import com.qspiders.objectrepository.HomePage;
import com.qspiders.objectrepository.ShoppingCartPage;
@Listeners(ListnerUtility.class)
public class TC_DWS_101_Test extends BaseClass
{
	@Test
	public void addtoCart()
	{
		ExtentTest test = extReport.createTest("addtoCart");
		cp= new ComputersPage(driver);
		cp.getDesktops().click();
		
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Simple Computer","Computer page is not displayed");
		test.log(Status.PASS, "Simple Computer Page is Displayed");
	}
	public void clickOnShoppingcart()
	{
		ExtentTest test = extReport.createTest("clickOnShoppingcart");
		sp=new ShoppingCartPage(driver);
		sp.getShoppingcart().click();
		
	}
}
