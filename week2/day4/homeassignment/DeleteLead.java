package week2.day4.homeassignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
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

		// clicks on the Find Leads button
		WebElement findLeadsBtn = driver.findElement(By.xpath("//a[@href ='/crmsfa/control/findLeads']"));
		findLeadsBtn.click();

		// clicks on the Phone Tab
		WebElement phoneTab = driver.findElement(By.xpath("//a[@class='x-tab-right']//span[text()='Phone']"));
		phoneTab.click();

		// Enter phone number
		WebElement phoneNumber = driver.findElement(By.name("phoneNumber"));
		phoneNumber.sendKeys("1");

		// clicks find leads button
		WebElement findLeads = driver.findElement(By.xpath("//button[text()='Find Leads']"));
		findLeads.click();

		// clicks the first element from the grid
		Thread.sleep(5000);

		WebElement findFirstID = driver.findElement(
				By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]//a"));
		String firstID = findFirstID.getText();

		System.out.println("firstID : " + firstID);
		findFirstID.click();

		// clicks delete button
		WebElement delBtn = driver.findElement(By.xpath("//a[text()='Delete']"));
		delBtn.click();

		// clicks on the Find Leads button again
		WebElement findLeadsButton = driver.findElement(By.xpath("//a[@href ='/crmsfa/control/findLeads']"));
		findLeadsButton.click();

		// Enters ID in the search box
		WebElement id = driver.findElement(By.name("id"));
		id.sendKeys(firstID);

		WebElement fLeadButton = driver.findElement(By.xpath("//button[text()='Find Leads']"));
		fLeadButton.click();

		Thread.sleep(5000);

		// Verifies the presence of the message
		WebElement delSuccessMsg = driver.findElement(By.className("x-paging-info"));
		String actDelMSg = delSuccessMsg.getText();
		String expDelMSg = "No records to display";

		System.out.println("Messgae : " + actDelMSg);

		if (expDelMSg.equals(expDelMSg)) {
			System.out.println("Record deleted");
		}

		driver.close();

	}

}
