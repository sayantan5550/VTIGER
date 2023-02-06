package Practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;

public class Sales {

	public static void main(String[] args) throws Throwable {
		
		String Key = "webdriver.chrome.driver";
		String Value = "./src/main/resources/chromedriver.exe";
		System.setProperty(Key, Value);
		WebDriver driver = new ChromeDriver();
		WebDriver_Utility wlib = new WebDriver_Utility();
		File_Utility flib = new File_Utility();
		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();

		wlib.maximizeScreen(driver);
		wlib.waitForPageToLoad(driver);
		
		String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		// Creating Random Number
		int ranNum = jlib.getRandomNum();	
		// Calling Data from Excel_Utility
		String orgName = elib.getExcelData("Organization",0,0)+ranNum;
	
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		
		Thread.sleep(2000);
		// Creating the Contact
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		String contactName = "Chatterjee"+ranNum;
		
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		
		//Switch to "Accounts&action" window
		wlib.switchToWindow(driver, "Accounts&action");
		
		//////
		
		// Selecting the Organization
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		
		Thread.sleep(2000);
		// Switch back the window to "Contacts&action"
		wlib.switchToWindow(driver, "Contacts&action");
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();  // save
		
		WebElement more = driver.findElement(By.linkText("More"));
		wlib.mouseOverOnElenemt(driver, more);	
		driver.findElement(By.name("Sales Order")).click();
		driver.findElement(By.xpath("//img[@alt='Create Sales Order...']")).click();
		
		String subName = "Automation"+ranNum;
		driver.findElement(By.name("subject")).sendKeys(subName);
		
		driver.findElement(By.xpath("(//img[@alt='Select'])[3]")).click();
		
		//Switch Window to Contacts&action
		wlib.switchToWindow(driver, "Contacts&action");
		
		driver.findElement(By.id("search_txt")).sendKeys(contactName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()=' "+contactName+"']")).click();
		
		wlib.switchToAlertAndAccept(driver);
		
		Thread.sleep(2000);
		//Switch Window back to "SalesOrder&action"
		wlib.switchToWindow(driver, "SalesOrder&action");
		// Log out
		Thread.sleep(2500);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseOverOnElenemt(driver, ele);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
