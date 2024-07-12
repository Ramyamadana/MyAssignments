package week2.day4.homeassignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckBoxInteractions {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		// Launches the url
		driver.get("https://leafground.com/checkbox.xhtml");

		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Click on the Basic checkbox
		WebElement basicChkBox = driver.findElement(By.xpath("//span[text() ='Basic']"));
		basicChkBox.click();

		// Click on the Ajax checkboxes
		WebElement notificationChkBox = driver.findElement(By.xpath("//span[text() ='Ajax']"));
		notificationChkBox.click();

		WebElement notificationPopup = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[./span[text()='Checked']]")));
		String actualPopupText = notificationPopup.getText();
		String expPopupText = "Checked";

		System.out.println(actualPopupText);
		Assert.assertEquals(actualPopupText, expPopupText, "Notification message : Not as Expected");

		// click on the favourite language checkbox
		WebElement javaLang = driver.findElement(By.xpath("//label[text()='Java']"));
		javaLang.click();
		WebElement csharpLang = driver.findElement(By.xpath("//label[text()='C-Sharp']"));
		csharpLang.click();

		// Click the tri State checkbox and print the state based on the selection
		
		WebElement triStateChkBox = driver
				.findElement(By.xpath("//div[contains(@id,'ajaxTriState')]//div[contains(@class, 'ui-chkbox-box')]"));
		triStateChkBox.click();
		WebElement triStatePopup = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[./span[text()='State has been changed.']]/p")));
		String Status = triStatePopup.getText();

		if (Status.equals("State = 0")) {
			System.out.println("TriState checkbox has been changed to empty");
		} else if (Status.equals("State = 1")) {
			System.out.println("TriState checkbox has been changed to checked");
		} else if (Status.equals("State = 2")) {
			System.out.println("TriState checkbox has been changed to crossed");
		}

		// Click on the toggle switch
		WebElement toggleSwitch = driver.findElement(By.className("ui-toggleswitch-slider"));
		toggleSwitch.click();
		Thread.sleep(2000);

		WebElement toggleSwitchPopup = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[./span[text()='Checked']]")));
		String actualToggleSwitchPopupText = toggleSwitchPopup.getText();
		String expToggleSwitchPopupText = "Checked";

		Assert.assertEquals(actualToggleSwitchPopupText, expToggleSwitchPopupText,
				"Toggle Switch Popup Message : Not as Expected");

		// Verify the status of the checkbox
		WebElement checkBox = driver.findElement(By.id("j_idt87:j_idt102_input"));

		if (checkBox.getAttribute("disabled") != null)

		{
			System.out.println("The check box is disabled");
		}

		// select cities from dropdown
		WebElement cityDrpDown = driver
				.findElement(By.xpath("//div[contains(@id, 'multiple') and @role = 'combobox']"));
		cityDrpDown.click();

		driver.findElement(By.xpath("//label[text()='London']/preceding-sibling::div")).click();
		driver.findElement(By.xpath("//label[text()='Rome']/preceding-sibling::div")).click();
		driver.findElement(By.xpath("//label[text()='Brasilia']/preceding-sibling::div")).click();

		driver.findElement(By.xpath("//a[@aria-label='Close']")).click();
		driver.close();

	}

}
