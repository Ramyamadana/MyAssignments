package week5.day10.homesassignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SalesForceDynamicParam extends ProjectSpecificMethod {

	@Test(dataProvider = "sendData")
	public void createLegalEntity(String name) throws InterruptedException {
		System.out.println("Test Case Execution Starts.....");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions act = new Actions(driver);

		Thread.sleep(2000);
		WebElement toggleBtn = driver.findElement(By.xpath("//button[@title='App Launcher']"));
		toggleBtn.click();

		// Click 'View All' button
		WebElement viewAllBtn = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='View All']")));
		viewAllBtn.click();

		// search 'Legal Entities' in the search app box
		WebElement searchApp = driver
				.findElement(By.xpath("//input[starts-with(@id,'input-') and contains(@placeholder,'Search apps')]"));
		searchApp.sendKeys("Legal Entities");

		// click on the Legal Entity app
		Thread.sleep(3000);
		WebElement legalEntity = driver.findElement(By.xpath("//mark[text()='Legal Entities']"));
		legalEntity.click();

		// Click on the Dropdown icon in the legal Entities tab
		Thread.sleep(2000);
		WebElement legalTabDrpIcon = driver.findElement(By.xpath("//div[contains(@class,'slds-p-right_x-small')]"));
		legalTabDrpIcon.click();

		// Click on New Legal Entity
		WebElement newLegalEntity = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='slds-truncate']/lightning-icon")));
		act.moveToElement(newLegalEntity).click().perform();

		
		WebElement entityName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Name']")));
		entityName.sendKeys("Salesforce Automation by " + name);

		Thread.sleep(3000);		
		WebElement saveBtn = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		saveBtn.click();

		Thread.sleep(3000);
		 WebElement legalEntityName = driver.findElement(By.xpath("(//span[text()='Legal Entity Name']//following::lightning-formatted-text[@data-output-element-id='output-field'])[1]"));	

		String readEntityName = legalEntityName.getText();
		System.out.println("Entity name retrieved from UI :" + readEntityName);
		
		int lastSpaceIndex  = readEntityName.lastIndexOf(" ");
		String modifiedEntityName = readEntityName.substring(lastSpaceIndex+1);
		
		System.out.println("Entity name  : " + modifiedEntityName);
		if (modifiedEntityName.equals(name))
			System.out.println("Legal Entity Name verified");
		else
			System.out.println("Legal Entity Name not verified");

	}

	// Passing different sets of data to test cases.
	@DataProvider
	public String[][] sendData() {
		String[][] data = new String[2][1];
		data[0][0] = "Ramya";

		data[1][0] = "Tom";

		return data;
	}

}
