package com.example.webguidemo;

import org.apache.bcel.generic.IF_ACMPEQ;
import org.jbehave.web.selenium.WebDriverProvider;

import com.example.webguidemo.pages.NowInTv;
import com.example.webguidemo.pages.Search;
import com.example.webguidemo.pages.Sport;
import com.example.webguidemo.pages.Home;

public class Pages {

	private WebDriverProvider driverProvider;

	// Pages
	private Home home;
	private Sport sport;
	private NowInTv nowInTv;
	private Search search;

	// ...

	public Pages(WebDriverProvider driverProvider) {
		super();
		this.driverProvider = driverProvider;
	}

	public Home home() {
		if (home == null) {
			home = new Home(driverProvider);
		}
		return home;
	}

	public Sport sport() {
		if (sport == null) {
			sport = new Sport(driverProvider);
		}
		return sport;
	}

	public NowInTv nowInTv() {
		if (nowInTv == null) {
			nowInTv = new NowInTv(driverProvider);
		}

		return nowInTv;
	}

	public Search search() {
		if (search == null) {
			search = new Search(driverProvider);
		}

		return search;
	}
}
