package com.example.selenium_lab2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.github.mirreck.FakeFactory;

public class AddArticleTest extends Configuration {

	@Before
	public void Login() {
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("email")).sendKeys("pmroczek@outlook.com");
		driver.findElement(By.id("password")).sendKeys("123");
		driver.findElement(By.name("commit")).click();
	}

	@Test
	public void success_add_new_article() {
		driver.findElement(By.linkText("Add new article")).click();
		FakeFactory factory = new FakeFactory();
		String title = factory.paragraph();
		String content = factory.paragraph(10);

		driver.findElement(By.id("article_title")).sendKeys(title);
		driver.findElement(By.id("article_text")).sendKeys(content);
		driver.findElement(By.name("commit")).click();

		Assert.assertEquals(title,
				driver.findElement(By.xpath("html/body/div[2]/div[1]/h1"))
						.getText());
		Assert.assertEquals(content,
				driver.findElement(By.xpath("html/body/div[2]/p")).getText());
	}

	@Test
	public void new_article_is_displayed_on_user_dashboard() {
		driver.findElement(By.linkText("Add new article")).click();
		FakeFactory factory = new FakeFactory();
		String title = factory.paragraph();
		String content = factory.paragraph(10);

		driver.findElement(By.id("article_title")).sendKeys(title);
		driver.findElement(By.id("article_text")).sendKeys(content);
		driver.findElement(By.name("commit")).click();
		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/ul/li[2]/a"))
				.click();

		Assert.assertTrue(driver.findElement(
				By.xpath("//td[contains(text(), \"" + title + "\")]"))
				.isDisplayed());
	}

	@Test
	public void edit_article_displayed_new_title() {
		driver.findElement(By.linkText("Add new article")).click();
		FakeFactory factory = new FakeFactory();
		String title = factory.paragraph();
		String content = factory.paragraph(10);

		// Add new article
		driver.findElement(By.id("article_title")).sendKeys(title);
		driver.findElement(By.id("article_text")).sendKeys(content);
		driver.findElement(By.name("commit")).click();
		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/ul/li[2]/a"))
				.click();
		driver.findElement(
				By.xpath("//td[contains(text(), \"" + title
						+ "\")]/following::a[1]")).click();

		title = factory.paragraph();
		driver.findElement(By.id("article_title")).sendKeys(title);
		driver.findElement(By.name("commit")).click();

		Assert.assertTrue(driver.findElement(
				By.xpath("//td[contains(text(), \"" + title + "\")]"))
				.isDisplayed());
	}

	@Test
	public void add_new_article_to_short_title_return_message() {
		driver.findElement(By.linkText("Add new article")).click();
		FakeFactory factory = new FakeFactory();
		String title = "str1";
		String content = factory.paragraph(10);

		driver.findElement(By.id("article_title")).sendKeys(title);
		driver.findElement(By.id("article_text")).sendKeys(content);
		driver.findElement(By.name("commit")).click();

		Assert.assertEquals(
				"Title is too short (minimum is 5 characters)",
				driver.findElement(
						By.xpath(".//*[@id='error_explanation']/ul/li/p"))
						.getText());
	}

	@Test
	public void add_new_article_blank_title_return_message() {
		driver.findElement(By.linkText("Add new article")).click();
		FakeFactory factory = new FakeFactory();
		String title = "";
		String content = factory.paragraph(10);

		driver.findElement(By.id("article_title")).sendKeys(title);
		driver.findElement(By.id("article_text")).sendKeys(content);
		driver.findElement(By.name("commit")).click();

		Assert.assertEquals(
				"Title can't be blank",
				driver.findElement(
						By.xpath(".//*[@id='error_explanation']/ul/li[1]/p"))
						.getText());

		Assert.assertEquals(
				"Title is too short (minimum is 5 characters)",
				driver.findElement(
						By.xpath(".//*[@id='error_explanation']/ul/li[2]/p"))
						.getText());
	}

	@Test
	public void add_new_article_blank_content_return_message() {
		driver.findElement(By.linkText("Add new article")).click();
		FakeFactory factory = new FakeFactory();
		String title = factory.paragraph();
		String content = "";

		driver.findElement(By.id("article_title")).sendKeys(title);
		driver.findElement(By.id("article_text")).sendKeys(content);
		driver.findElement(By.name("commit")).click();

		Assert.assertEquals(
				"Text can't be blank",
				driver.findElement(
						By.xpath(".//*[@id='error_explanation']/ul/li/p"))
						.getText());
	}

	@Test
	public void add_new_article_no_fill_form_return_message() {
		driver.findElement(By.linkText("Add new article")).click();

		driver.findElement(By.name("commit")).click();

		Assert.assertEquals(
				"Title can't be blank",
				driver.findElement(
						By.xpath(".//*[@id='error_explanation']/ul/li[1]/p"))
						.getText());

		Assert.assertEquals(
				"Title is too short (minimum is 5 characters)",
				driver.findElement(
						By.xpath(".//*[@id='error_explanation']/ul/li[2]/p"))
						.getText());

		Assert.assertEquals(
				"Text can't be blank",
				driver.findElement(
						By.xpath(".//*[@id='error_explanation']/ul/li[3]/p"))
						.getText());
	}

	@After
	public void Logout() {
		driver.findElement(By.linkText("Logout")).click();
	}
}
