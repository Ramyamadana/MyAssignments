package week4.day8.classassignment;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebTableInteractions {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();

		// loads the url
		driver.get("https://erail.in/");

		// maximize the window
		driver.manage().window().maximize();

		// wait for few seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MAS" + Keys.ENTER);
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("MDU" + Keys.ENTER);

		// driver.findElement(By.xpath("//label[text()='Sort on Date']")).click();
		driver.findElement(By.id("chkSelectDateOnly")).click();

		int rowCount = driver.findElements(By.xpath("//table[contains(@class,'TrainList')]//tr")).size();

		System.out.println("Total Table Row Count : " + rowCount);

		for (int i = 2; i <= rowCount; i++) {
			String trainName = driver
					.findElement(By.xpath("//table[contains(@class,'TrainList')]//tr[" + i + "]/td[2]")).getText();
			System.out.println(trainName);
		}
		
		Set<String> trainNames = new LinkedHashSet<String>();
		for (int i = 2; i <= rowCount; i++) {
			String trainName = driver
					.findElement(By.xpath("//table[contains(@class,'TrainList')]//tr[" + i + "]/td[2]")).getText();
			trainNames.add(trainName);
		}

		int setRowCount = trainNames.size();
		System.out.println("Row Count of elements after adding in Set: " + setRowCount); 
																							
		System.out.println(trainNames);

		int duplicateRecCount = ((rowCount - 1) - setRowCount);

		if ((rowCount - 1) == setRowCount) {
			System.out.println("No. are no duplicate train names ");
		} else
			System.out.println("No. of duplicate train names: " + duplicateRecCount);

		driver.close();

	}

}
