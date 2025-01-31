package com.qspiders.genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qspiders.objectrepository.ComputersPage;
import com.qspiders.objectrepository.HomePage;
import com.qspiders.objectrepository.LoginPage;
import com.qspiders.objectrepository.ShoppingCartPage;
import com.qspiders.objectrepository.WelcomePage;

public class BaseClass
{
	
	public static ExtentReports extReport;
	public static WebDriver driver;
	public static ExtentTest test;
	
	public JavaUtility jUtil = new JavaUtility();
	public static WebDriverUtility wUtil;
	public FileUtility fUtil = new FileUtility();
	
	public WelcomePage wp;
	public HomePage hp;
	public LoginPage lp;
	public ComputersPage cp;
	public ShoppingCartPage sp;

	@BeforeSuite
	public void configReport()
	{
		ExtentSparkReporter spr = new ExtentSparkReporter("./HTML_Reports/"+jUtil.getSystemdateTime()+".html");
		extReport= new ExtentReports();
		extReport.attachReporter(spr);
	}
	@Parameters("Browser")
	@BeforeClass
	public void openBrowser(@Optional("chrome") String browserName) throws IOException
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		wUtil=new WebDriverUtility(driver);
		wUtil.implicitWait();
		
		driver.get(fUtil.getDataFromProperty("url"));
		
	}
	@BeforeMethod
	public void login() throws IOException
	{
		wp=new WelcomePage(driver);
		wp.getLoginlink().click();
		lp = new LoginPage(driver);
		lp.getEmailTextField().sendKeys(fUtil.getDataFromProperty("email"));
		lp.getPasswordTextField().sendKeys(fUtil.getDataFromProperty("password"));
		lp.getLoginButton().click();
	}
	@AfterMethod
	public void logout()
	{
		hp = new HomePage(driver);
		hp.getLogoutlink().click();
	}
	@AfterClass
	public void closebrowser()
	{
		driver.quit();
	}
	@AfterSuite
	public void reportBackup()
	{
		extReport.flush();
	}

}
