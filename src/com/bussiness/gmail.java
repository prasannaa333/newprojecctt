package com.bussiness;

import org.testng.annotations.Test;

import com.basetest.Baseclass;

public class gmail extends Baseclass{
	@Test(priority=1)
	public void gmailtest() throws InterruptedException {
	driver.get(p.getProperty("url"));
	Thread.sleep(3000);

}
}