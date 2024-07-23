package week4.day8.classassignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandling {

	public static void main(String[] args) {

		// Handles windows notifications
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(option);

		// loads the url
		driver.get("https://www.irctc.co.in/");

		// maximize the window
		driver.manage().window().maximize();

		// wait for few seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Gets the current window
		String parentWindow = driver.getWindowHandle();

		System.out.println("Parent window's handle : " + parentWindow);
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();

		
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String childWindow : allWindowHandles) {
		
			driver.switchTo().window(childWindow);
			System.out.println("Windows : " + childWindow);

		}

		//current focus is in child window. Gets the title of it. 
		System.out.println(driver.getTitle());		
		
		driver.switchTo().window(parentWindow);
		driver.close();

	}

}
