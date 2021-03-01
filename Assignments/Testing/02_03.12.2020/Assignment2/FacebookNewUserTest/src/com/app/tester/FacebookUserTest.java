package com.app.tester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static com.app.tests.NewUserTest.createNewUser;
import static com.app.tests.LoginTest.login;

public class FacebookUserTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "/home/arshi/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/reg/");
		createNewUser(driver);
		
		driver.get("https://www.facebook.com");
		login(driver);
	}
}
