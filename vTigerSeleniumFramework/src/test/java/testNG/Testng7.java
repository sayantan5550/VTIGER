package testNG;

import org.testng.annotations.Test;

public class Testng7 {

	@Test
	public void create()
	{
		int[] arr = {1,2,3};
		System.out.println(arr[5]);
	}
	@Test(dependsOnMethods = "create")
	public void modify()
	{
		System.out.println("modified");
	}
	@Test(dependsOnMethods = "modify")
	public void delete()
	{
		System.out.println("deleted");
	}
}
