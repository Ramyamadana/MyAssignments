package week4.day8.homeassignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ActionBigBasket {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("(//span[text()='Shop by'])[2]")).click();

		// Mouse hover "Foodgrains, Oil & Masala".
		Thread.sleep(2000);
		WebElement category1 = driver.findElement(By.partialLinkText("Foodgrains"));
		Actions a = new Actions(driver);
		a.moveToElement(category1).perform();

		// Mouse hover "Rice & Rice Products".
		WebElement subCategory1 = driver.findElement(By.linkText("Rice & Rice Products"));
		a.moveToElement(subCategory1).perform();

		// Mouse hover and Click on "Boiled & Steam Rice".
		WebElement subCategory2 = driver.findElement(By.linkText("Boiled & Steam Rice"));
		a.moveToElement(subCategory2).click().perform();

		// Filter the results by selecting the brand "bb Royal".
		WebElement filterBrand = driver.findElement(By.id("i-BBRoyal"));
		a.moveToElement(filterBrand).click().perform();
		Thread.sleep(2000);

		// Gets the parent window address
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window's handle : " + parentWindow);

		// Click on "Tamil Ponni Boiled Rice".
		WebElement filteredResults = driver
				.findElement(By.xpath("//span[text()='bb Royal']//following::h3[text()='Tamil Ponni Boiled Rice']"));
		a.moveToElement(filteredResults).click().perform();

		//switching to child window
		Set<String> windows = driver.getWindowHandles();
		for (String childWindow : windows) {
			driver.switchTo().window(childWindow);
			System.out.println("Child Window opened on clicking the Product : " + childWindow);
		}

		// Select the 5 Kg bag.
		Thread.sleep(2000);
		WebElement packSize = driver.findElement(By.xpath("//span[text()='5 kg']"));
		a.moveToElement(packSize).click().perform();

		// Get the price of the rice.
		WebElement price = driver.findElement(By
				.xpath("//span[text()='5 kg']/following::span[contains(text(), '₹75 / kg')]/preceding-sibling::span"));
		String RicePrice = price.getText();
		System.out.println("Rice Price : " + RicePrice);

		driver.findElement(By.xpath("//button[text()='Add to basket']")).click();

		// Gets the add to cart message and verify
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement addToCartMsg = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='mx-4 flex-1']")));
		String actualMsg = addToCartMsg.getText();
		System.out.println("Message after clicking the add button:" + actualMsg);
		String expectedMsg = "An item has been added to your basket successfully";

		Assert.assertEquals(actualMsg, expectedMsg, "Success message not matching");

		// Take Screenshot
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Copy the file to a location and use try catch block to handle exception
		try {
			FileUtils.copyFile(screenShot, new File("D:\\TestLeaf\\AutoScreenShots\\BigBasketScreenshot.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		driver.quit();		
	}	

}
