package week4.day8.homeassignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionSnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// Create a new instance of the ChromeOptions
		ChromeOptions option = new ChromeOptions();

		// Disable notifications
		option.addArguments("--disable-notifications");

		// Create a new instance of the ChromeDriver
		ChromeDriver driver = new ChromeDriver(option);

		// Launches the url
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Mouse hover on "Men's Fashion"
		WebElement topCategory = driver.findElement(By.xpath("//span[contains(text(),\"Men's Fashion\")]"));
		Actions a = new Actions(driver);
		a.moveToElement(topCategory).perform();

		// Mouse hover on "Sports Shoes"
		WebElement sportShoes = driver
				.findElement(By.xpath("//span[@class='headingText']//following::span[text()='Sports Shoes']"));
		a.moveToElement(sportShoes).click().perform();

		// Get the count of sports shoes
		String sportShoesCount = driver
				.findElement(By.xpath("//div[@class='child-cat-name selected']/following-sibling::div")).getText();
		System.out.println("Sport Shoes Count : " + sportShoesCount);

		// Click on "Training Shoes".
		WebElement trainingShoes = driver
				.findElement(By.xpath("//div[@class='child-cat-name ' and text()='Training Shoes']"));
		a.moveToElement(trainingShoes).click().perform();

		// Sort the products by "Low to High".
		driver.findElement(By.xpath("//span[@class='sort-label']")).click();
		driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();

		// Check if the displayed items are sorted correctly
		String fromPriceStr = driver.findElement(By.name("fromVal")).getAttribute("value");
		int fromPriceValue = Integer.parseInt(fromPriceStr);

		String toPriceValueStr = driver.findElement(By.name("toVal")).getAttribute("value");
		int toPriceValue = Integer.parseInt(toPriceValueStr);

		System.out.println("From price Value : " + fromPriceValue + " To price Value : " + toPriceValue);

		if (fromPriceValue < toPriceValue)
			System.out.println(
					"Items are sorted from Low to High in the range of : " + fromPriceValue + " To " + toPriceValue);
		else
			System.out.println("Items are not sorted properly");

		// Select any price range
		WebElement lowPriceSlider = driver.findElement(By.xpath("//a[contains(@class,'price-slider-scroll left-handle')]"));
		Thread.sleep(5000);
		a.dragAndDropBy(lowPriceSlider, 3, 0).perform();
		WebElement highPriceSlider = driver.findElement(By.xpath("//a[contains(@class,'price-slider-scroll right-handle')]"));
		Thread.sleep(5000);
		a.dragAndDropBy(highPriceSlider, -193, 0).perform();
		
		driver.findElement(By.xpath("//div[normalize-space()='GO']")).click();


		// Filter by any colour
		Thread.sleep(2000); 
		WebElement blackColorFilter = driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::label[@for='Color_s-Black']"));		
		a.moveToElement(blackColorFilter).click().perform();

		
		WebElement sizeViewMore = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@data-name='Size_s']/following-sibling::button[text()='View More ']")));
		a.moveToElement(sizeViewMore).click().perform();

		// Click Size filter check box
		Thread.sleep(2000);
		WebElement sizeFilter = driver.findElement(By.xpath("//label[@for='Size_s-6']"));
		a.moveToElement(sizeFilter).click().perform();		

		// Verify all the applied filters
		List<WebElement> filtersSelected = driver.findElements(By.xpath("//div[@class='filters']"));
		for (int i = 1; i <= filtersSelected.size(); i++) {
			System.out.println("Applied filters are: "
					+ driver.findElement(By.xpath("//div[@class='filters']//div[" + i + "]/a")).getText());
		}

		WebElement results = driver.findElement(By.xpath("(//img[@class='product-image wooble'])[1]"));
		a.moveToElement(results).perform();

		WebElement quickViewBtn = driver.findElement(By.xpath("(//div[contains(@class,'center quick-view-bar')])[1]"));
		quickViewBtn.click();

		// Get the cost and the discount percentage.
		Thread.sleep(500);
		System.out.println("Product Cost: " + driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText());		
		System.out.println("The discount percentage: " + driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText());

		// Take screenshot and save it at the specified location
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File("./screenshot/SnapDeal.png"));
		System.out.println("Screenshot taken and saved");

		// Close the current window
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();

		// Close the main window
		driver.close();

	}

}
