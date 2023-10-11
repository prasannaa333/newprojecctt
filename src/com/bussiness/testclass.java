package com.bussiness;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.basetest.Baseclass;
import com.pageobjects.testclasspage;

public class testclass extends Baseclass{
	@Test(priority=2)
	public void sendkey() throws InterruptedException {
		driver.get(p.getProperty("url2"));
		//driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(p.getProperty("sendkeysvalue"));
		
		//driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(p.getProperty("sendkeysvalue"));//here values getting from config.properties
		testclasspage Testpage=new testclasspage(driver);
		Testpage.googlesearchbarr(p.getProperty("sendkeysvalue"));
		Thread.sleep(3000);
		Assert.assertTrue(true);
	}

}
