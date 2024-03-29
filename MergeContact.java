package testcase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.lang.Thread;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact extends BaseClassAssign{
	@Test
	public  void runMergeLead() 
	{
		
	//Click on Contacts
	WebElement clickContact = driver.findElement(By.linkText("Contacts"));
	clickContact.click();
	
	//	click on Merge Contacts
	WebElement clickMergeContact = driver.findElement(By.xpath("//a[@href='/crmsfa/control/mergeContactsForm']"));
	clickMergeContact.click();
	
	//Click on From Widget
	WebElement clickFromWidget= driver.findElement(By.xpath("//table[@class='twoColumnForm']/tbody/tr[1]/td[2]/a/img"));
	clickFromWidget.click();
	
	//New window opens with contact List. 
	//get uique Id for all Opened Windows
	
	Set<String> allWindows = driver.getWindowHandles();
	List<String> list = new ArrayList<String>(allWindows);
	
	//switch the context to the New Window
	
	 driver.switchTo().window(list.get(2));
	 //select the first contact
	 
	 WebElement findId = driver.findElement(By.xpath("//div[@class='x-grid3-body']/div/table/tbody/tr/td[1]/div/a"));
	 findId.click();
	 
	//switch the context back to the main Window
	 
	 driver.switchTo().window(list.get(1));	 
	 //click on To widget
	 
	WebElement clickToWidget= driver.findElement(By.xpath("//table[@class='twoColumnForm']/tbody/tr[2]/td[2]/a/img"));
	clickToWidget.click();
	
	//new window handling
	
	Set<String> windows = driver.getWindowHandles();
	List<String> list2 = new ArrayList<String>(windows);
	
	//switch the context to the new window
	
	 driver.switchTo().window(list2.get(2));
	 
	 //select the second contact from the list
	 
	WebElement findToId = driver.findElement(By.xpath("//div[@class='x-grid3-body']/div[2]/table/tbody/tr/td[1]/div/a"));
	findToId.click();
	
	//switch the context back to the main window
	
	driver.switchTo().window(list.get(1));	
	
	//Click on Merge
	
	 driver.findElement(By.xpath("//table[@class='twoColumnForm']/tbody/tr[4]/td[2]/a")).click();
	 
	 //switch the context to alert and accept it 
	 
	 Alert alert = driver.switchTo().alert();
	 alert.accept();
	 
	 //verify the title of the resulting page
	 
	 String title="View Contact | opentaps CRM";
	 String lastTitle = driver.getTitle();
	 if(title.equals(lastTitle))
	 {
		 System.out.println("Contact Merged Successfullly");
	 }
	 else
		 System.out.println("Contact Merge Unsuccessfull");
	}
}
