package com.qspiders.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputersPage 
{
	@FindBy(partialLinkText = "Computers")
	private WebElement computers;
	
	@FindBy(partialLinkText = "Desktops")
	private WebElement desktops;
	
	@FindBy(xpath="//a[text()='Simple Computer']/../..//input[@value='Add to cart']")
	private WebElement addtocart;
	
	public ComputersPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getComputers() 
	{
		return computers;
	}
	public WebElement getDesktops() 
	{
		return desktops;
	}
	public WebElement getAddtocart() 
	{
		return addtocart;
	}
}
