package com.utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.basetest.Baseclass;



public interface ScreenshotUtility {
	
	public interface ScreenShotUtility{
		public static String takeScreenshot(String tcName) throws IOException 
		{
			 
			Date date=new Date();
			String timestamp= date.toString().replace(" ", "_").replace(":", "_");	
			
			TakesScreenshot takesscreenshot=(TakesScreenshot)Baseclass.driver;
			File file= takesscreenshot.getScreenshotAs(OutputType.FILE);
			String imagepath=System.getProperty("user.dir")+"\\Screenshots\\"+tcName+timestamp+".jpeg";
			FileUtils.copyFile(file, new File(imagepath));
			return imagepath;
		
	}

	}
}
