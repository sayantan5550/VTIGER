package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	
	@Test(dataProvider="dataProvider_test")
	public void bookTickets(String source, String destination)
	{
		System.out.println("Book Tickets from "+source+" to "+destination);
	}
	
	@DataProvider
	public Object[][] dataProvider_test()
	{
		Object[][] objArr = new Object[4][2];
		
		objArr[0][0] = "Bangalore";
		objArr[0][1] = "GOA";
		
		objArr[1][0] = "Bangalore";
		objArr[1][1] = "Kolkata";
		
		objArr[2][0] = "Bangalore";
		objArr[2][1] = "Guwahati";
		
		objArr[3][0] = "Bangalore";
		objArr[3][1] = "Hyderabad";
		
		return objArr;
		
	}

}
 