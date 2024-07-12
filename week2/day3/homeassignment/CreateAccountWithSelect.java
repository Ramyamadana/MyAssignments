package week2.day3.homeassignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountWithSelect {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		//Launches the url
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();

		// Enters user name and password and login into the application
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("Demosalesmanager");

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("crmsfa");

		WebElement login = driver.findElement(By.className("decorativeSubmit"));
		login.click();

		// clicks on the CRM/SFA link
		WebElement crmsfaLink = driver.findElement(By.partialLinkText("CRM/SFA"));
		crmsfaLink.click();

		// clicks on the Accounts Tab
		WebElement accountsTab = driver.findElement(By.xpath("//a[@href ='/crmsfa/control/accountsMain']"));
		accountsTab.click();

		// clicks on the Create Account button
		WebElement createAccount = driver.findElement(By.xpath("//a[@href='/crmsfa/control/createAccountForm']"));
		createAccount.click();

		// Enter Account Name, description, number of employees, site name
		WebElement accountName = driver.findElement(By.id("accountName"));
		accountName.sendKeys("Test Account5");

		WebElement description = driver.findElement(By.name("description"));
		description.sendKeys("Selenium Automation Tester");

		Select industry = new Select(driver.findElement(By.name("industryEnumId")));
		industry.selectByValue("IND_SOFTWARE");

		Select ownership = new Select(driver.findElement(By.name("ownershipEnumId")));
		ownership.selectByVisibleText("S-Corporation");

		Select source = new Select(driver.findElement(By.id("dataSourceId")));
		source.selectByValue("LEAD_EMPLOYEE");

		Select marketingCampaignId = new Select(driver.findElement(By.id("marketingCampaignId")));
		marketingCampaignId.selectByIndex(6);

		Select stateProvince = new Select(driver.findElement(By.id("generalStateProvinceGeoId")));
		stateProvince.selectByValue("TX");

		WebElement createAccountBtn = driver
				.findElement(By.xpath("//input[@type='submit' and @value='Create Account']"));
		createAccountBtn.click();
		

		driver.findElement(By.xpath("//span[text() = 'Account Name']/following::span[contains(text(),'Test Account5')]"));	
		
		
		WebElement logOut = driver.findElement(By.linkText("Logout"));
		logOut.click();
		
		driver.close();

	}

}
