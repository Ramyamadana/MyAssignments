package week2.day3.homeassignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLead {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
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

		// clicks on the Leads Tab
		WebElement leadsTab = driver.findElement(By.xpath("//a[@href ='/crmsfa/control/leadsMain']"));
		leadsTab.click();

		// clicks on the Create Lead button
		WebElement createLead = driver.findElement(By.xpath("//a[@href='/crmsfa/control/createLeadForm']"));
		createLead.click();

		// Enter company name, first name, last name, title
		WebElement companyName = driver.findElement(By.id("createLeadForm_companyName"));
		companyName.sendKeys("Company 1");

		WebElement firstName = driver.findElement(By.id("createLeadForm_firstName"));
		firstName.sendKeys("Ramya");

		WebElement lastName = driver.findElement(By.id("createLeadForm_lastName"));
		lastName.sendKeys("M");

		WebElement title = driver.findElement(By.id("createLeadForm_generalProfTitle"));
		title.sendKeys("Test title");

		WebElement createLeadBtn = driver.findElement(By.xpath("//input[@type='submit' and @name='submitButton']"));
		createLeadBtn.click();

		Thread.sleep(5000);

		System.out.println("Title: " + driver.getTitle());

		driver.close();

	}

}
