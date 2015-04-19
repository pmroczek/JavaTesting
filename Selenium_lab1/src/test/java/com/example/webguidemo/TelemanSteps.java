package com.example.webguidemo;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class TelemanSteps {

	private final Pages pages;

	public TelemanSteps(Pages pages) {
		this.pages = pages;
	}

	@Given("user is on Home page")
	public void userIsOnHomePage() {
		pages.home().open();
	}

	@When("user opens Sport link")
	public void userClicksOnSportLink() {
		pages.home().findElement(By.linkText("SPORT")).click();
	}

	@Then("Sport page is shown")
	public void sportPageIsShown() {
		assertEquals("Sport w TV",
				pages.sport().getHeader());
	}

	@When("user opens NowInTv link")
	public void userClicksOnNowInTvLink() {
		pages.home().findElement(By.linkText("TERAZ W TV")).click();
	}

	@Then("NowInTv page is shown")
	public void nowInTvPageIsShown() {
		assertEquals("Teraz i za chwilę w TV", pages.nowInTv().getHeader());
	}
	
	@When("user search News")
	public void userSearchNews() {
		pages.home().Search("Wiadomości");
	}

	@Then("News are shown")
	public void newAreShown() {
		assertTrue(pages.search().foundAnyKeys());
	}
}
