package week6.day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import week6.BaseClass;
import week6.ReadExcel;

public class DuplicateLead extends BaseClassAssign {
	@Test(dataProvider="fetchValues")

	public void runDuplicateLead(String phNum)throws InterruptedException {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phNum);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.name("submitButton")).click();
		System.out.println("DuplicateLead Completed");
}
	
	@DataProvider(name="fetchValues")
	public String[][] testData() throws IOException{ 
			
		
		String[][] leadDatum = ReadExcel.leadDatum(3);
		return leadDatum;

	}
		
}






