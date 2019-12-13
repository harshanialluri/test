package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.WebEventListener;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;
	
	public BaseTest() {
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\VIJAYALAKSHMINAKKA\\eclipse-workspace\\"
					+ "FreeCRMTestAutomation\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop=new Properties();
			prop.load(fis);
		} 
		catch (FileNotFoundException e) {
		  e.printStackTrace();
		} 
		catch (IOException e) {
		  e.printStackTrace();
		}
	}
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			driver=new ChromeDriver();
		}
		if(browserName.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		e_driver=new EventFiringWebDriver(driver);
		eventlistener=new WebEventListener();
		e_driver.register(eventlistener);
		driver=e_driver;
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
}