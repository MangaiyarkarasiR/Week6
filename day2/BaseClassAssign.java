package week6.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassAssign {
	public RemoteWebDriver driver;//declared globally
	@Parameters({"browser","url","username","password"})
	@BeforeMethod
	public void preConditions(String browser, String url,String username, String password)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) 
		{
			WebDriverManager.chromedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
	}
	@AfterMethod
	public void postConditions()
	{
		driver.close();
	}

}
