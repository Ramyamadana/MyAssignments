package week5.day10.homesassignment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

// Program to understand TestNG - Static Parameterization 
public class SalesForceStaticParam {

	@Parameters({"url","username","password"}) // should match will the xml parameter names and order does not matter
	@Test
	public void createLegalEntity(String url, String uname, String pwd) throws InterruptedException {

		// Disable notifications
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(option);
		
		//driver.get("https://login.salesforce.com");
		driver.get(url);    
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions act = new Actions(driver);
		
		//Login into the salesforce application		
		
		WebElement userName = driver.findElement(By.id("username"));  
		//userName.sendKeys("dilip@testleaf.com");
		userName.sendKeys(uname);     
		WebElement password = driver.findElement(By.id("password"));
		//password.sendKeys("testleaf@2024");
		password.sendKeys(pwd);    
		WebElement loginBtn = driver.findElement(By.id("Login"));
		loginBtn.click();			
		
		
		//Click on the 'toggle menu button' from the left corner		
		WebElement toggleBtn = driver.findElement(By.xpath("//button[@title='App Launcher']"));		
		toggleBtn.click();
		
		//Click 'View All' button		
		WebElement viewAllBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='View All']")));
		viewAllBtn.click();
		
		//search 'Legal Entities' in the search app box
		WebElement searchApp = driver.findElement(By.xpath("//input[starts-with(@id,'input-') and contains(@placeholder,'Search apps')]"));
		searchApp.sendKeys("Legal Entities");
		
		//click on the Legal Entity app
		WebElement legalEntity = driver.findElement(By.xpath("//mark[text()='Legal Entities']"));
		legalEntity.click();
		
		//Click on the Dropdown icon in the legal Entities tab
		Thread.sleep(2000); 
		WebElement legalTabDrpIcon = driver.findElement(By.xpath("//div[contains(@class,'slds-p-right_x-small')]"));
		legalTabDrpIcon.click();
		
	//	String parentWindow = driver.getWindowHandle();
		//System.out.println("parentWindow : "+parentWindow);
		
		//Click on New Legal Entity	
		WebElement newLegalEntity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='slds-truncate']/lightning-icon")));
		act.moveToElement(newLegalEntity).click().perform();
		
		/*
		 * Set<String> windows = driver.getWindowHandles(); for (String childWindow :
		 * windows) {
		 * 
		 * // Switches to newly opened new legal entity window
		 * driver.switchTo().window(childWindow); System.out.println("Windows : " +
		 * childWindow); }
		 */	
	
		WebElement companyName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='CompanyName']")));
		companyName.sendKeys("TestLeaf");
		
		WebElement description = driver.findElement(By.xpath("//label[text()='Description']//following::textarea"));
		description.sendKeys("Salesforces");
		
		//scroll down to the page
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		System.out.println("Scroll down to status drop down");
		
		//click on the status drop down
		Thread.sleep(3000);
		WebElement status = driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input-value')]"));	
		//WebElement status = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'slds-combobox__input-value')]")));		
		status.click();
		
		
		/*
		 * JavascriptExecutor js = (JavascriptExecutor)driver;
		 * js.executeScript("arguments[0].click();", status);
		 */
		
		//select the option form the status drop down
		WebElement statusOption = driver.findElement(By.xpath("//span[@class='slds-truncate' and text()='Active']"));	
		statusOption.click();
		
		Thread.sleep(3000);
		//WebElement saveBtn = driver.findElement(By.name("SaveEdit"));	
		WebElement saveBtn = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		saveBtn.click();
		
		//Handling (Non-Modal) sweet alert
		WebElement popup = driver.findElement(By.xpath("//a[text()='Legal Entity Name']"));
		popup.click();
		System.out.println("Clicked on the link inside the sweet alert");
		
		//Verify the Alert message (Complete this field) displayed for Name
		
		//div[starts-with(@id,'help-message-')]
		WebElement reqFieldsMsg = driver.findElement(By.xpath("//div[@class='slds-form-element__help']"));
		String actualMsg = reqFieldsMsg.getText();
		String ExpMsg ="Complete this field.";
		
		Assert.assertEquals(actualMsg, ExpMsg, "Actual Msg and Expected message mismatched");
		
		//close the legal entity window
		driver.findElement(By.xpath("//button[@title='Close this window']")).click();
		
		
		driver.close();
		
	}

}
