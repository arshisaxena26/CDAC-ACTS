package com.app.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TestFlightsPage {

	public static void testFlightsPage(WebDriver driver) {

		new Select(driver.findElement(By.name("departureCity"))).selectByVisibleText("MUMBAI");

		new Select(driver.findElement(By.name("arrivalCity"))).selectByVisibleText("TORONTO");

		driver.findElement(By.name("departureDate")).sendKeys("2021-11-11");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.findElement(By.linkText("select")).click();

	}
}
