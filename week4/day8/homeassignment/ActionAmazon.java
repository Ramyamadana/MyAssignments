package week4.day8.homeassignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ActionAmazon {

	public static void main(String[] args) throws InterruptedException {
		// Launch Chrome
		ChromeDriver driver = new ChromeDriver();

		String searchTerm = "oneplus 9 pro";

		// Launches the url
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Enters the items to search
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys(searchTerm + Keys.ENTER);
		
		//Gets the price of the first product			
		String price = driver.findElement(By.xpath("//span[@class = 'a-price-whole']")).getText();
		String productPrice = price.replace(",", "");		
		System.out.println("Price : " + productPrice);	
				
		//Prints the number of customer ratings for the first displayed product.
		WebElement starRatings = driver.findElement(By.xpath("(//i[contains(@class,'a-icon-star-small')])[1]"));
		Actions a = new Actions(driver);
		a.moveToElement(starRatings).click().perform();
		
		Thread.sleep(1000);
		String startRatingsPopup = driver.findElement(By.xpath("//span[contains(@data-hook,'acr-average-stars-rating-text')]")).getText();
		System.out.println("Star Ratings : " + startRatingsPopup);
		
		String globalRatings = driver.findElement(By.xpath("(//span[@data-hook = 'total-review-count'])[1]")).getText();
		System.out.println("Global Ratings : " + globalRatings);	
		
		
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window's handle : " + parentWindow);
		
		//Clicks the first text link of the first image
		WebElement productLink = driver.findElement(By.xpath("(//a[@class='a-link-normal s-no-outline'])[1]"));
		productLink.click();
		
		Set<String> windows1 = driver.getWindowHandles();      //I am using two sets here to move to child window. Can we make it as one?
		for (String openProductWindow : windows1) {
			driver.switchTo().window(openProductWindow);
			System.out.println("Child Window opened on clicking the Product : " + openProductWindow);
		}
		
		//Take Screenshot
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//Copy the file to a location and use try catch block to handle exception
        try {
            FileUtils.copyFile(screenShot, new File("D:\\TestLeaf\\AutoScreenShots\\ProductPageScreenshot.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
		
		WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
		addToCart.click();
		
		Set<String> windows2 = driver.getWindowHandles();
		for (String cartSubTotal : windows2) {
			driver.switchTo().window(cartSubTotal);
			System.out.println("Child Window opened on clicking the Add to Cart button :  : " + cartSubTotal);
		}
	
		//Adding some wait here
		WebElement cartSubtotal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("attach-accessory-cart-subtotal")));		
		String cartSubtotalTxt = cartSubtotal.getText();
		
		//Removing currency symbol
		String str1 = cartSubtotalTxt.replace(",", "");	
		String subtotal = str1.substring(1, str1.length()-3);     
		
	
		System.out.println("Cart Subtotal : " + subtotal);      
		
		Assert.assertEquals(productPrice, subtotal, "Mismatch in the Cart Sub total");
		
		driver.quit();
		
	}

}
