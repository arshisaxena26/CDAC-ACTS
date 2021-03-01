package com.app.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestPassengerFormPage {

	public static void testPassengerFormPage(WebDriver driver) {

		driver.findElement(By.name("name")).sendKeys("TestPassenger");

		driver.findElement(By.name("email")).sendKeys("testpass@gmail.com");

		driver.findElement(By.name("phone")).sendKeys("1234567890");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.findElement(By.name("cardNumber")).sendKeys("1111222233334444");

		driver.findElement(By.id("cardHolder")).sendKeys("TestPassenger");

		driver.findElement(By.name("expiryDate")).sendKeys("2028-11-11");

		driver.findElement(By.name("cvv")).sendKeys("111");

		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
}
