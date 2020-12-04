package com.app.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTest {

	public static void login(WebDriver driver) {

		driver.findElement(By.linkText("Forgotten password?")).click();

		driver.findElement(By.id("identify_email")).sendKeys("seleniumtestuser111@gmail.com");

		driver.findElement(By.id("u_0_5")).click();

		// Should be logged in with specified email id for the code to work

		driver.findElement(By.id("recover_openid")).click();

		driver.findElement(By.name("reset_action")).click();

		driver.findElement(By.name("ok")).click();

		driver.findElement(By.id("password_new")).sendKeys("anotherPassword");

		driver.findElement(By.id("btn_continue")).click();
	}
}
