package week2.day3.classassignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeaftApps {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement username = driver.findElement(By.xpath("//input[@id = 'username']"));
		username.sendKeys("Demosalesmanager");
		WebElement password = driver.findElement(By.xpath("//input[@id = 'password']"));
		password.sendKeys("crmsfa");
		WebElement login = driver.findElement(By.xpath("//input[@value = 'Login']"));
		login.click();
		Thread.sleep(5000);
		WebElement crmsfaLink = driver.findElement(By.partialLinkText("CRM/SFA"));
		crmsfaLink.click();
		WebElement accountsTab = driver.findElement(By.xpath("//a[@href ='/crmsfa/control/accountsMain']"));
		accountsTab.click();
				

	}

}
