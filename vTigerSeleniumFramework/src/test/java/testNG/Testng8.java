 package testNG;

import org.testng.annotations.Test;

public class Testng8 {

	@Test(invocationCount = 2)
	public void create()
	{
		System.out.println("created");
	}
	@Test
	public void modify()
	{
		System.out.println("modified");
	}
	@Test
	public void delete()
	{
		System.out.println("deleted");
	}
}
