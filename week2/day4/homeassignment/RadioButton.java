package week2.day4.homeassignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		// Launches the url
		driver.get("https://www.leafground.com/radio.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Click the favourite browser option
		WebElement favBrowser = driver
				.findElement(By.xpath("//table[contains(@id, 'j_idt87:console1')]//label[text()='Chrome']"));
		favBrowser.click();

		// Click on 'Chennai' radio button and again click on the same to verify it
		// becomes ‘unselected’.
		WebElement city = driver.findElement(
				By.xpath("//label[text()='Chennai']/preceding-sibling::div//span[contains(@class,'radiobutton')]"));
		city.click();

		WebElement citySelect = driver.findElement(
				By.xpath("//label[text()='Chennai']/preceding-sibling::div/div/input[@id='j_idt87:city2:0']"));
		System.out.println(city.getText() + " Radio button is selected : " + citySelect.isSelected());

		city.click();
		System.out.println(city.getText() + " Radio button is unselected : " + citySelect.isSelected());

		// Identify the radio button that is initially selected by default.
		WebElement defaultSelectedRadio = driver.findElement(By.xpath("//input[contains(@id, 'console2') and @checked]"));
		WebElement defaultSelectedLabel = defaultSelectedRadio.findElement(By.xpath("./ancestor::div/following-sibling::label"));
		System.out.println("Default selected radio button : " + defaultSelectedLabel.getText());

		// select the age group (21-40 Years)
		WebElement ageGroup = driver.findElement(By.xpath("//input[@value='21-40 Years']"));
		
		if (ageGroup.isSelected()) {
			System.out.println(" Age group (21-40 Years) is already selected");
		} else {
			ageGroup.click();
			System.out.println(" Selecting the option age group (21-40 Years)");
		}

		driver.close();

	}

}
