package week2.day3.homeassignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
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
		accountName.sendKeys("Test Account1");

		WebElement description = driver.findElement(By.name("description"));
		description.sendKeys("Selenium Automation Tester");

		WebElement numberEmployees = driver.findElement(By.id("numberEmployees"));
		numberEmployees.sendKeys("10");

		WebElement siteName = driver.findElement(By.id("officeSiteName"));
		siteName.sendKeys("LeafTaps");
		
		WebElement createAccountBtn = driver
				.findElement(By.xpath("//input[@type='submit' and @value='Create Account']"));
		createAccountBtn.click();

		Thread.sleep(5000);
		
		//Prints the web page title

		System.out.println("Title: " + driver.getTitle());

		driver.close();

	}

}
