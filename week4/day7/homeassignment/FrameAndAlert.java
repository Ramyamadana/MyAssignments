package week4.day7.homeassignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameAndAlert {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		
		//loads the url
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		
		//maximize the window
		driver.manage().window().maximize();
		
		//moves to frame
		driver.switchTo().frame("iframeResult");
		
		//wait for few seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		//clicks on the Try it button
		WebElement tryBtn = driver.findElement(By.xpath("//button[text()='Try it']"));
		tryBtn.click();
		
		//Handling popups
		Alert alertBox = driver.switchTo().alert();
		
		//clicks ok button
		alertBox.accept();
		
		String actualText = driver.findElement(By.id("demo")).getText();
		String expText = "Hello Harry Potter! How are you today?";
		
		if (actualText.equals(expText)) {
			System.out.println("Text are matching");
		} else {
			System.out.println("Text are not matching");
		}
		
		driver.close();

	}

}
