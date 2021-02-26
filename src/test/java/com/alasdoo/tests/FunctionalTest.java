package com.alasdoo.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FunctionalTest {

	protected static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		WebDriverManager.chromedriver().version("88.0.4324.96").setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@After
	public void cleanUp() {
		driver.manage().deleteAllCookies();
	}

	@AfterClass
	public static void tearDown() {

		driver.close();
	}

}
