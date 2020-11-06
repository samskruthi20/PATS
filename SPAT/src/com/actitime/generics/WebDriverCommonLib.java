package com.actitime.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
public void waitforpagetoload( WebDriver driver){
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}
public void waitforelement(WebDriver driver,WebElement element) {
 WebDriverWait wait=new WebDriverWait(driver,10);
 wait.until(ExpectedConditions.visibilityOf(element));
 
}
public void CustomWaitForElementIsEnabled(WebElement element){
	int i=0;
	while(i<20) {
		try {
			element.isEnabled();
			break;
		}
		catch(Exception e) {
		i++;
		}
	   }
      }

   }


