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

public class CreateLead2 extends BaseClassAssign {
	@Test(dataProvider="fetchValues")
	public  void runCreateLead(String cname,String fname, String lname,String phno) {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phno);
		driver.findElement(By.name("submitButton")).click();
		
}
	@DataProvider(name="fetchValues")
	public String[][] testData() throws IOException{ 
			
		
		String[][] leadDatum = ReadExcel.leadDatum(0);
		return leadDatum;

	}
			
}







