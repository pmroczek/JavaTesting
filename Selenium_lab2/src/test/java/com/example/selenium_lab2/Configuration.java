package com.example.selenium_lab2;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Configuration {

	public WebDriver driver;

	@Before
	public void GoToHomePage() {
		System.setProperty("webdriver.chrome.driver",
				"c:\\tmp\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://blogpmroczek.herokuapp.com");
	}

	@After
	public void CloseDriver() {
		driver.close();
	}
}
