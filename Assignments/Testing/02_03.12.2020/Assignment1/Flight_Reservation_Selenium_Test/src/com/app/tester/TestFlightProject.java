package com.app.tester;

import static com.app.tests.TestFlightsPage.testFlightsPage;
import static com.app.tests.TestIndexPage.testIndexPage;
import static com.app.tests.TestLoginPage.testLoginPage;
import static com.app.tests.TestLogoutPage.testLogoutPage;
import static com.app.tests.TestPassengerFormPage.testPassengerFormPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestFlightProject {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "/home/arshi/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080");

		testIndexPage(driver);
		testLoginPage(driver);
		testFlightsPage(driver);
		testPassengerFormPage(driver);
		testLogoutPage(driver);
	}
}
