package com.app.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestLogoutPage {

	public static void testLogoutPage(WebDriver driver) {

		driver.findElement(By.linkText("LOGOUT")).click();
	}
}
