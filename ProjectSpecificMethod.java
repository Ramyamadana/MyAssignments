package week5.day10.homesassignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethod {

	public ChromeDriver driver;

	@Parameters({ "url", "username", "password" })
	@BeforeMethod
	public void preCondition(String url, String uname, String pwd) {
		
		System.out.println("Before method");
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		driver = new ChromeDriver(option);

		driver.get(url);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
	

		// Login into the salesforce application

		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys(uname);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(pwd);
		WebElement loginBtn = driver.findElement(By.id("Login"));
		loginBtn.click();
		
	}

	@AfterMethod
	public void postCondition() {
		driver.close();
		System.out.println("After method");
	}
}
