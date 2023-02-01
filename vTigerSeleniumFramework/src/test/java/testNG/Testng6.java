package testNG;

import org.testng.annotations.Test;

public class Testng6 {
	
	@Test
	public void create()
	{
		System.out.println("created");
	}
	@Test(enabled = false)    // To disable the method from executing
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
