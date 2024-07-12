package week2.day4.homeassignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

public class LeafGroundButtons {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		// Launches the url
		driver.get("https://leafground.com/button.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Click on the button with the text ‘Click and Confirm title.’
		driver.findElement(By.xpath("//span[text()='Click']/parent::button")).click();

		String expectedTitle = "Dashboard";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Page Title does not match");

		driver.navigate().back();

		// Check if the button with the text ‘Confirm if the button is disabled’ is
		// disabled.
		boolean btnState = driver.findElement(By.xpath("//span[text()='Disabled']/parent::button")).isEnabled();

		System.out.println("Button state: " + btnState);
		Assert.assertFalse(false, "Button is enabled");

		// prints the position of the button with the text ‘Submit.’
		Point btnPosition = driver
				.findElement(By.xpath("//span[text()='Submit']/parent::button[contains(@id, 'j_idt94')]"))
				.getLocation();
		System.out.println("Submit button Position : " + btnPosition);

		// Prints the background color of the button with the text ‘Find the Save button
		// color.’
		String rgbaActualColor = driver.findElement(By.xpath("//span[text()='Save']/parent::button"))
				.getCssValue("background-color");
		Color btncolor = Color.fromString(rgbaActualColor);
		String actualColor = btncolor.asHex();
		String expectedColor = "#607d8b";

		Assert.assertEquals(actualColor, expectedColor);

		System.out.println("Background color of the Save button : " + actualColor);

		// Prints the height and width of the button with the text ‘Find the height and
		// width of this button.’
		Dimension btnHtWidth = driver
				.findElement(By.xpath("//span[text()='Submit']/parent::button[contains(@id,'j_idt94')]")).getSize();
		System.out.println(btnHtWidth);
		System.out.println("Height : " + btnHtWidth.getHeight());
		System.out.println("Width : " + btnHtWidth.getWidth());

		driver.close();

	}

}
