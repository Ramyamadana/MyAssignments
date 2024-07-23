package week4.day7.classassignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrameAndAlert {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();		
		
		//loads the url
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		
		//maximize the window
		driver.manage().window().maximize();
		
		//wait for few seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//moves to frame
		driver.switchTo().frame("iframeResult");
		
		//clicks on the Try it button
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		//Handling popups
		Alert alertBox = driver.switchTo().alert();
		
		//clicks ok button
		alertBox.accept();
		
		//validates the message printed in the web page
		String actualText = driver.findElement(By.id("demo")).getText();
		System.out.println("Actual Text :" +actualText);

		String expText = "You pressed OK!";
		
		if (actualText.equals(expText)) {
			System.out.println("Text are matching");
		} else {
			System.out.println("Text are not matching");
		}

		//moves back to web page
		driver.switchTo().defaultContent();
		driver.close();		

	}

}
