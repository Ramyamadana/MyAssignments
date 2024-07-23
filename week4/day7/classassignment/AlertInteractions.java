package week4.day7.classassignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertInteractions {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//h5[text() =' Alert (Prompt Dialog)']//following::span[text()='Show'][1]"))
				.click();

		Alert prompt = driver.switchTo().alert();
		prompt.sendKeys("Ramya");
		prompt.dismiss();

		String actualText = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();

		String expText = "User cancelled the prompt.";

		if (actualText.equals(expText)) {
			System.out.println("Text are matching");
		} else {
			System.out.println("Text are not matching");
		}

		driver.close();

	}

}
