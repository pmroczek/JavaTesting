package com.example.selenium_lab2;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Configuration {

	public WebDriver driver;

	public void TakeScreenshot(String testName) {
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			Date date = new Date();

			System.out.println(dateFormat.format(date));
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\" + testName
					+ dateFormat.format(date) + ".jpeg"), true);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

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
