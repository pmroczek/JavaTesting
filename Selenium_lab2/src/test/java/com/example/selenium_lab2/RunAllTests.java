package com.example.selenium_lab2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ArticlesTest.class, LoginTest.class, RegisterBlogTest.class })
public class RunAllTests {

}
