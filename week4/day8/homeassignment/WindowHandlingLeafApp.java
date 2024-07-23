package week4.day8.homeassignment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingLeafApp {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Login into the application
		WebElement username = driver.findElement(By.xpath("//input[@id = 'username']"));
		username.sendKeys("Demosalesmanager");
		WebElement password = driver.findElement(By.xpath("//input[@id = 'password']"));
		password.sendKeys("crmsfa");
		WebElement login = driver.findElement(By.xpath("//input[@value = 'Login']"));
		login.click();

		WebElement crmsfaLink = driver.findElement(By.partialLinkText("CRM/SFA"));
		crmsfaLink.click();

		// Click on the Contacts button
		WebElement contactsTab = driver.findElement(By.linkText("Contacts"));
		contactsTab.click();

		// Click on Merge Contacts tab
		WebElement mergeConatctsTab = driver.findElement(By.linkText("Merge Contacts"));
		mergeConatctsTab.click();

		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window's handle : " + parentWindow);

		// Click on the From Contact button in merge contact screen
		WebElement fromContact = driver.findElement(By.xpath("//input[@id='partyIdFrom']//following::img[1]"));
		fromContact.click();

		Set<String> windows1 = driver.getWindowHandles();
		for (String childWindow1 : windows1) {

			// Switches to newly opened From Contact look up window
			driver.switchTo().window(childWindow1);
			System.out.println("Windows : " + childWindow1);
		}

		// Click on the first resulting contact
		//WebElement firstContactId = driver.findElement(By.xpath("(//div[@class='x-grid3-scroller']//table//tr[1])[1]//td[1]//a"));
		//firstContactId.click();
		
		WebElement firstContactId = driver.findElement(By.xpath("(//a[@class='linktext'])[1]"));
		firstContactId.click();

		Thread.sleep(2000);
		// go back to parent window
		driver.switchTo().window(parentWindow);

		// Click on the To Contact button in merge contact screen

		WebElement toContact = driver.findElement(By.xpath("//input[@id='partyIdFrom']//following::img[2]"));
		toContact.click();

		Set<String> windows2 = driver.getWindowHandles();
		for (String childWindow2 : windows2) {

			// Switches to newly opened To Contact look up window
			driver.switchTo().window(childWindow2);
			System.out.println("Windows : " + childWindow2);
		}

		// Click on the second resulting contact
	   // WebElement secondContactId = driver.findElement(By.xpath("(//div[@class='x-grid3-scroller']//table//tr[1])[2]//td[1]//a"));
	   // secondContactId.click();
		
		WebElement secondContactId = driver.findElement(By.xpath("(//a[@class='linktext'])[6]"));
		secondContactId.click();

		Thread.sleep(2000);

		// go back to parent window
		driver.switchTo().window(parentWindow);

		// Click on Merge button
		WebElement mergeButton = driver.findElement(By.linkText("Merge"));
		mergeButton.click();
		
		//Handling alert popup
		Alert alertMsg = driver.switchTo().alert();
		alertMsg.accept();
		
		System.out.println("Title :" +driver.getTitle());
		driver.close();
	}

}
