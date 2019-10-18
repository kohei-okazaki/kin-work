package jp.co.kin.common.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import jp.co.kin.common.test.BaseCommonTest;

public class LoginTest extends BaseCommonTest {

	@Test
	public void test() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\kin-app\\git\\kin-work\\kin-common\\exe\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/kin-dashboard/login/index");
		WebElement loginIdElement = driver.findElement(By.id("loginId"));
		loginIdElement.sendKeys("test");
		WebElement passwordElement = driver.findElement(By.id("password"));
		passwordElement.sendKeys("test");
		WebElement submitButton = driver.findElement(By.id("submit"));
		submitButton.click();
		Thread.sleep(10000);

		// これをやると画面が消える
		driver.quit();
	}
}
