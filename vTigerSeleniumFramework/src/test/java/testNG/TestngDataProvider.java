package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import Object_Repo.Home_Page;
import Object_Repo.Login_Page;
import Object_Repo.Organizations_Page;

public class TestngDataProvider {
	
	@Test(dataProvider = "dataProvider_test")
	public void organisationDetails(String name, String phnum, String email) throws Throwable {
	
	String Key = "webdriver.chrome.driver";
	String Value = "./src/main/resources/chromedriver.exe";
	System.setProperty(Key, Value);
	
	WebDriver driver = new ChromeDriver();
	
	// Generic Utilities Objects
	WebDriver_Utility wlib = new WebDriver_Utility();
	File_Utility flib = new File_Utility();
	Java_Utility jlib = new Java_Utility();
	
	Login_Page login = new Login_Page(driver);
	Home_Page hp = new Home_Page(driver);
	Organizations_Page op = new Organizations_Page(driver);

	wlib.maximizeScreen(driver);
	wlib.waitForPageToLoad(driver);
	
	String URL = flib.getKeyAndValue("url");
	String USERNAME = flib.getKeyAndValue("username");
	String PASSWORD = flib.getKeyAndValue("password");
	
	driver.get(URL);
	login.loginToApp(USERNAME,PASSWORD);
	
	hp.organizationButtonClick();
	op.createOrganizationButtonClick();

	driver.findElement(By.name("accountname")).sendKeys(name);
	driver.findElement(By.id("phone")).sendKeys(phnum);
	driver.findElement(By.id("email1")).sendKeys(email);

	op.saveButtonClick();
	driver.quit();
	}
	
	@DataProvider
	public Object[][] dataProvider_test()
	{
		Object[][] objArr = new Object[3][3];
		
		objArr[0][0] = "AAA";
		objArr[0][1] = "9954123456";
		objArr[0][2] = "qwerty@gmail.com";
		
		objArr[1][0] = "BBB";
		objArr[1][1] = "9706123456";
		objArr[1][2] = "asdfgh@gmail.com";
		
		objArr[2][0] = "CCC";
		objArr[2][1] = "9131123456";
		objArr[2][2] = "zxcvbn@gmail.com";
		
		return objArr;
				
	}

}
