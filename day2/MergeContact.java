package week6.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.Thread;

import io.github.bonigarcia.wdm.WebDriverManager;
import week6.ReadExcel;

public class MergeContact extends BaseClassAssign{
	@Test
	public  void runMergeLead() 
	{
		
	WebElement clickContact = driver.findElement(By.linkText("Contacts"));
	clickContact.click();
	WebElement clickMergeContact = driver.findElement(By.xpath("//a[@href='/crmsfa/control/mergeContactsForm']"));
	clickMergeContact.click();
	WebElement clickFromWidget= driver.findElement(By.xpath("//table[@class='twoColumnForm']/tbody/tr[1]/td[2]/a/img"));
	clickFromWidget.click();
	Set<String> allWindows = driver.getWindowHandles();
	List<String> list = new ArrayList<String>(allWindows);
	 driver.switchTo().window(list.get(2));
	 WebElement findId = driver.findElement(By.xpath("//div[@class='x-grid3-body']/div/table/tbody/tr/td[1]/div/a"));
	 findId.click();
	 driver.switchTo().window(list.get(1));	
	WebElement clickToWidget= driver.findElement(By.xpath("//table[@class='twoColumnForm']/tbody/tr[2]/td[2]/a/img"));
	clickToWidget.click();
	Set<String> windows = driver.getWindowHandles();
	List<String> list2 = new ArrayList<String>(windows);
	 driver.switchTo().window(list2.get(2));
	WebElement findToId = driver.findElement(By.xpath("//div[@class='x-grid3-body']/div[2]/table/tbody/tr/td[1]/div/a"));
	findToId.click();
	driver.switchTo().window(list.get(1));	
	driver.findElement(By.xpath("//table[@class='twoColumnForm']/tbody/tr[4]/td[2]/a")).click();
	 Alert alert = driver.switchTo().alert();
	 alert.accept();
	 String title="View Contact | opentaps CRM";
	 String lastTitle = driver.getTitle();
	 if(title.equals(lastTitle))
	 {
		 System.out.println("Contact Merged Successfullly");
	 }
	 else
		 System.out.println("Contact Merge Unsuccessfull");
	 System.out.println("MergeLead Completed");
	}	
	
}
