package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Home extends WebDriverPage {

	public Home(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("http://www.teleman.pl");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void Search(String key) {
		WebElement element = this.findElement(By.xpath(".//*[@id='search-form']/input[1]"));
		element.sendKeys(key);
		this.findElement(By.xpath(".//*[@id='search-form']/input[2]")).click();
	}
}
