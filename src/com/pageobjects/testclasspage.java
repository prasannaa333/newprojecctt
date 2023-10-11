package com.pageobjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class testclasspage {
	WebDriver driver;
//objects	
@FindBy(xpath="//textarea[@id='APjFqb']")
	private WebElement googlesearchbar;

public testclasspage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);//here this means cassname
}
//Actions
public void googlesearchbarr(String search) {
	googlesearchbar.sendKeys(search);
}
}
