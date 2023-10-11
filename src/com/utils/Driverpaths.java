package com.utils;

public interface Driverpaths {
	String ieKey="webdriver.ie.driver";
	String ievalue=System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe";
	
	String firefoxkey="webdriver.gecko.driver";
	String firefoxvalue=System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe";
	
	String chromeKey="webdriver.chrome.driver";
	String chromevalue=System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
	
	String edgeKey="webdriver.edge.driver";
	String edgevalue=System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe";
	

}
