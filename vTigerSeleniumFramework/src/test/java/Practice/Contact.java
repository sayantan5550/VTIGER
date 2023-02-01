package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;

public class Contact {
	
	public static void main(String[] args) throws Throwable {

		String Key = "webdriver.chrome.driver";
		String Value = "./src/main/resources/chromedriver.exe";
		System.setProperty(Key, Value);
		WebDriver_Utility wlib = new WebDriver_Utility();
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		
		WebDriver driver = new ChromeDriver();
		wlib.maximizeScreen(driver);
		wlib.waitForPageToLoad(driver);
		
		String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		// Creating new Organization
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		// Fetching Date from Excel

		int rand = jlib.getRandomNum();

		String orgName = elib.getExcelData("Organization", 0, 0)+rand;
	
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		
		Thread.sleep(2000);
		// Creating the Contact
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		String contact = "Chatterjee" + rand;
		driver.findElement(By.name("lastname")).sendKeys(contact);
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		
		//Switch Window
		wlib.switchToWindow(driver, "Accounts&action");
		
		// Selecting the Organization
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		Thread.sleep(2000);
		// Switch back the window
		wlib.switchToWindow(driver, "Contacts&action");

		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();  // save 
		
		// Log out
		
		Thread.sleep(2500);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseOverOnElenemt(driver, ele);
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			
	}

}
