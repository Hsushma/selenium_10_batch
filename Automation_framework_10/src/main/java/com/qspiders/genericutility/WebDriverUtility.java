package com.qspiders.genericutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility 
{
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public WebDriver driver;
	public WebDriverUtility(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void mousehover(WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}	
	public void dobleClick(WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void dragDrop(WebElement elementsrc,WebElement elementdest)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(elementsrc, elementdest).perform();
	}
	public void clickAndHold(WebElement element)
	{
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}	
	public void rightclick(WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	//SELECT 
	public void selectDropdownByIndex(WebElement dropele,int index)
	{
		Select slct = new Select(dropele);
		slct.selectByIndex(index);
	}
	public void selectDropdownByValue(WebElement dropele,String value)
	{
		Select slct = new Select(dropele);
		slct.selectByValue(value);
	}
	public void selectDropdownByVisibletext(WebElement dropele,String visibletext)
	{
		Select slct = new Select(dropele);
		slct.selectByVisibleText(visibletext);
	}
	
	//Switch to
	public void switchtoframe(int frmindex)
	{
		driver.switchTo().frame(frmindex);
	}
	public void switchtoframe(String nameORid)
	{
		driver.switchTo().frame(nameORid);
	}
	public void manageWindow(WebElement frameele)
	{
		driver.switchTo().frame(frameele);
	}
	//alerts
	public Alert switchtoAlert()
	{
		return driver.switchTo().alert();
	}
	public void switchtoAlertAndAccept()
	{
		driver.switchTo().alert().accept();
	}
	public void switchtoAlertAndCancel()
	{
		driver.switchTo().alert().dismiss();
	}
	//switch to window
	public void switchtoWindow(String expUrl)
	{
		Set<String> allwindowId = driver.getWindowHandles();
		for(String id:allwindowId)
		{
			driver.switchTo().window(id);
			String acturl = driver.getCurrentUrl();
			if(acturl.contains(expUrl))
			{
				break;
			}
		}
	}
	//WaitTime
	public Timeouts implicitWait()
	{
		return driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	public WebDriverWait explictWait()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait;
	}
	public void maximizeWindow()
	{
		driver.manage().window().maximize();
	}
	public void minimizeWindow()
	{
		driver.manage().window().minimize();
	}
	//to Take ScreenShot
	public void takeScreenshot() throws IOException
	{
		JavaUtility jutil = new JavaUtility();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShots/"+jutil.getSystemdateTime()+".png");
		FileHandler.copy(temp,dest);
	}
	//Scroll Webpage
}
