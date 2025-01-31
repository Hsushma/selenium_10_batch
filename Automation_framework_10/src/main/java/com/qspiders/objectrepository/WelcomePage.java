package com.qspiders.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage 
{
		@FindBy(linkText = "Register")
		private WebElement registorlink;
		
		@FindBy(xpath  = "//a[text()='Log in']")
		private WebElement loginlink;
		
		public WelcomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		public WebElement getRegistorlink() 
		{
			return registorlink;
		}

		public WebElement getLoginlink() 
		{
			return loginlink;
		}
		
	
}
