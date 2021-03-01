package com.app.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestIndexPage {

	public static void testIndexPage(WebDriver driver) {

		driver.findElement(By.linkText("Sign In")).click();
	}
}
