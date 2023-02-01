package testNG;

import java.time.LocalDateTime;

public class Test00 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalDateTime now = LocalDateTime.now();  
	    String dateTime = now.toString().replace(" ", "-");
	    System.out.println(dateTime);
	}

}
