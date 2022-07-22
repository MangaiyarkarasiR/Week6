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

public class EditLead extends BaseClassAssign {
@Test(dataProvider="fetchValues")
	public  void runEditLead(String phonum,String Cname) throws InterruptedException {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phonum);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(Cname);
		driver.findElement(By.name("submitButton")).click();
		System.out.println("EditLead Completed");
	
}

@DataProvider(name="fetchValues")
public String[][] testData() throws IOException{ 
		
	
	String[][] leadDatum = ReadExcel.leadDatum(1);
	return leadDatum;
	
	
	/*String[][] values =new String[2][4];
		values[0][0]="Testleaf";
		values[0][1]="Hari";
		values[0][2]="R";
		values[0][3]="090";
		values[1][0]="Testleaf";
		values[1][1]="Vidhya";
		values[1][2]="R";
		values[1][3]="090";
		return values;*/
}
	
}






