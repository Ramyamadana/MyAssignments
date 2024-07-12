package week2.day3.homeassignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;  

public class FbRegistration {
	
	//Facebook registration page

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		//Launches the url
		driver.get("https://en-gb.facebook.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		
		WebElement createAccountBtn = driver.findElement(By.xpath("//a[text()='Create new account']"));
		createAccountBtn.click();
		
		//Enter first name, sur name,mobile, password, Date of birth, gender
		
		WebElement firstName = driver.findElement(By.name("firstname"));
		firstName.sendKeys("xxxx");
		
		WebElement surName = driver.findElement(By.name("lastname"));
		surName.sendKeys("R");
		
		WebElement mobile = driver.findElement(By.name("reg_email__"));
		mobile.sendKeys("0123456789");
		
		WebElement password = driver.findElement(By.id("password_step_input"));
		password.sendKeys("*******");
		
		Select day = new Select(driver.findElement(By.id("day")));
		day.selectByValue("1");
		
		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByIndex(0);
		
		Select year = new Select(driver.findElement(By.id("year")));
		year.selectByVisibleText("2000");
		
		WebElement gender = driver.findElement(By.xpath("//span[@data-name='gender_wrapper']//label[text() = 'Female']"));
		gender.click();		
		
		driver.close();
		

	}

}
