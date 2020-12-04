package com.app.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class NewUserTest {

	public static void createNewUser(WebDriver driver) {

		driver.findElement(By.name("firstname")).sendKeys("Selena");

		driver.findElement(By.name("lastname")).sendKeys("Thompson");

		driver.findElement(By.name("reg_email__")).sendKeys("seleniumtestuser111@gmail.com");

		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("seleniumtestuser111@gmail.com");

		driver.findElement(By.name("reg_passwd__")).sendKeys("p@ssWORD");

		new Select(driver.findElement(By.name("birthday_day"))).selectByVisibleText("1");

		new Select(driver.findElement(By.name("birthday_month"))).selectByVisibleText("Jan");

		new Select(driver.findElement(By.name("birthday_year"))).selectByVisibleText("1980");

		driver.findElement(By.id("u_0_5")).click();

		driver.findElement(By.id("u_0_14")).click();
	}
}
