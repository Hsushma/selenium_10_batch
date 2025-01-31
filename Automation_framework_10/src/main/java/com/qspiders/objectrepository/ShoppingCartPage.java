package com.qspiders.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage 
{
	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement shoppingcart;
	
	public ShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getShoppingcart() 
	{
		return shoppingcart;
	}
	

}
