package week2.day4.homeassignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		
		// Launches the url
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

		// Enter company name, first name, last name, first name local, department,
		// description, email
		WebElement companyName = driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']"));
		companyName.sendKeys("company11");

		WebElement firstName = driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']"));
		firstName.sendKeys("xxxxx");

		WebElement lastName = driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']"));
		lastName.sendKeys("R");

		WebElement firstNameLocal = driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']"));
		firstNameLocal.sendKeys("xxxxlllllll");

		WebElement department = driver.findElement(By.id("createLeadForm_departmentName"));
		department.sendKeys("dept");

		WebElement description = driver.findElement(By.id("createLeadForm_description"));
		description.sendKeys("Edit lead description");

		WebElement email = driver.findElement(By.id("createLeadForm_primaryEmail"));
		email.sendKeys("xxx@gmail.com");

		// selects state province from the drop down

		Select stateProvince = new Select(driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")));
		stateProvince.selectByVisibleText("Arizona");

		// clicks create lead button
		WebElement createLeadBtn = driver.findElement(By.xpath("//input[@type='submit' and @name='submitButton']"));
		createLeadBtn.click();

		// clicks edit button
		WebElement editBtn = driver.findElement(By.xpath("//a[text()='Edit']"));
		editBtn.click();

		// update description and note
		WebElement updateDescription = driver.findElement(By.id("updateLeadForm_description"));
		updateDescription.sendKeys("update description");

		WebElement updateImportantNote = driver.findElement(By.id("updateLeadForm_importantNote"));
		updateImportantNote.sendKeys("note update");

		//// clicks update button
		WebElement updateBtn = driver.findElement(By.xpath("//input[@name='submitButton' and @value='Update']"));
		updateBtn.click();

		System.out.println(driver.getTitle());
		driver.close();

	}

}
