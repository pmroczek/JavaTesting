package com.example.selenium_lab2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.mirreck.FakeFactory;

public class RegisterBlogTest extends Configuration {

	public RegisterBlogTest() {
		super();
	}

	@Test
	public void go_to_register_page() {
		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/ul/li[2]/a")).click();

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.xpath("html/body/div[2]/div[1]/h1"))
						.getText().toLowerCase().startsWith("register");
			}
		});
	}

	@Test
	public void success_register_new_user() throws InterruptedException {
		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/ul/li[2]/a"))
				.click();
		FakeFactory fakeFactory = new FakeFactory();

		driver.findElement(By.id("user_name")).sendKeys(
				fakeFactory.firstName() + fakeFactory.lastName());
		driver.findElement(By.id("user_email")).sendKeys(fakeFactory.email());
		driver.findElement(By.id("user_password")).sendKeys("zaq1@WSX");
		driver.findElement(By.id("user_password_confirmation")).sendKeys(
				"zaq1@WSX");
		driver.findElement(By.name("commit")).click();

		WebElement result = driver.findElement(By
				.xpath("html/body/div[2]/div[1]"));

		Assert.assertTrue(result.isDisplayed());
	}

	@Test
	public void search_some_text() {
		WebElement element = driver.findElement(By.id("search"));
		element.sendKeys("lorem");
		element.submit();
		WebElement result = driver.findElement(By
				.xpath("html/body/div[2]/div[2]/h1/span"));

		Assert.assertTrue(result.isDisplayed());
		Assert.assertNotNull(result.getText());
	}

	@Test
	public void register_with_no_pass_confirm_should_display_error_message() {
		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/ul/li[2]/a"))
				.click();
		FakeFactory fakeFactory = new FakeFactory();

		driver.findElement(By.id("user_name")).sendKeys(
				fakeFactory.firstName() + fakeFactory.lastName());
		driver.findElement(By.id("user_email")).sendKeys(fakeFactory.email());
		driver.findElement(By.id("user_password")).sendKeys("zaq1@WSX");

		driver.findElement(By.name("commit")).click();

		Assert.assertEquals(
				"Password confirmation doesn't match Password",
				driver.findElement(
						By.xpath(".//*[@id='new_user']/div[1]/ul/li[1]"))
						.getText());
		Assert.assertEquals("Password confirmation can't be blank", driver
				.findElement(By.xpath(".//*[@id='new_user']/div[1]/ul/li[2]"))
				.getText());
	}

	@Test
	public void register_with_exists_email_should_display_error_message() {
		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/ul/li[2]/a"))
				.click();
		FakeFactory fakeFactory = new FakeFactory();

		driver.findElement(By.id("user_name")).sendKeys(
				fakeFactory.firstName() + fakeFactory.lastName());
		driver.findElement(By.id("user_email"))
				.sendKeys("pmroczek@outlook.com");
		driver.findElement(By.id("user_password")).sendKeys("zaq1@WSX");
		driver.findElement(By.id("user_password_confirmation")).sendKeys(
				"zaq1@WSX");
		driver.findElement(By.name("commit")).click();

		Assert.assertEquals(
				"Email has already been taken",
				driver.findElement(
						By.xpath(".//*[@id='new_user']/div[1]/ul/li[1]"))
						.getText());
	}
}
