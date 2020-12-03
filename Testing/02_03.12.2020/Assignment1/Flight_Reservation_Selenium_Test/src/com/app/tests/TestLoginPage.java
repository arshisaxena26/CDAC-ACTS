package com.app.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestLoginPage {

	public static void testLoginPage(WebDriver driver) {

		// Testing with invalid input
		driver.findElement(By.name("email")).sendKeys("abc@gmail.com");

		driver.findElement(By.name("pass")).sendKeys("123456");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		// Testing with Valid input
		WebElement message = driver.findElement(By.xpath("//h2"));

		if (!message.equals(null)) {

			driver.findElement(By.name("email")).sendKeys("testadmin@gmail.com");

			driver.findElement(By.name("pass")).sendKeys("pass");

			driver.findElement(By.xpath("//input[@type='submit']")).click();
		}
	}
}
