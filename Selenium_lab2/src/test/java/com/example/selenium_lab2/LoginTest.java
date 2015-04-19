package com.example.selenium_lab2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends Configuration {

	@Test
	public void login_with_valid_creds_shound_display_dashboad() {
		driver.findElement(By.linkText("Login")).click();

		driver.findElement(By.id("email")).sendKeys("pmroczek@outlook.com");
		driver.findElement(By.id("password")).sendKeys("123");
		driver.findElement(By.name("commit")).click();

		Assert.assertEquals(
				"Przemek Mroczek".toLowerCase(),
				driver.findElement(
						By.xpath("html/body/div[1]/div/div[2]/ul/li[2]/a"))
						.getText().toLowerCase());
	}

	@Test
	public void login_with_empty_email_shound_display_error_message() {
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("password")).sendKeys("123");
		driver.findElement(By.name("commit")).click();

		Assert.assertTrue(driver.findElement(
				By.xpath("html/body/div[2]/div[1]")).isDisplayed());
	}

	@Test
	public void login_with_invalid_email_shound_display_error_message() {
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("email")).sendKeys("blabla@outlook.com");
		driver.findElement(By.id("password")).sendKeys("123");
		driver.findElement(By.name("commit")).click();

		Assert.assertTrue(driver.findElement(
				By.xpath("html/body/div[2]/div[1]")).isDisplayed());
	}

	@Test
	public void login_with_wrong_pass_shound_display_error_message() {
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("email")).sendKeys("pmroczek@outlook.com");
		driver.findElement(By.id("password")).sendKeys("321");
		driver.findElement(By.name("commit")).click();

		Assert.assertTrue(driver.findElement(
				By.xpath("html/body/div[2]/div[1]")).isDisplayed());
	}

	@Test
	public void login_with_empty_pass_shound_display_error_message() {
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("email")).sendKeys("pmroczek@outlook.com");
		driver.findElement(By.name("commit")).click();

		Assert.assertTrue(driver.findElement(
				By.xpath("html/body/div[2]/div[1]")).isDisplayed());
	}
}
