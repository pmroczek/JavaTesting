package com.example.webguidemo.pages;

import javax.swing.plaf.PanelUI;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Search extends WebDriverPage {

	public Search(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public boolean foundAnyKeys() {
		WebElement element = this.findElement(By
				.xpath(".//*[@id='search-navig']/a[2]/em"));
		String text = element.getText();
		text = text.replace("(", "");
		text = text.replace(")", "");

		return Integer.parseInt(text) > 0;
	}
}
