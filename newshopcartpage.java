package RegisterdomainName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class newshopcartpage {
	
	//Items in Your Cart page
	public void item(WebDriver driver, int year){
	
		// wait
		try {
			Thread.sleep(3000);	// wait 10 second
		} catch (InterruptedException e) {
			System.out.println("10 second gone!!");
		}

		driver.findElement(By.linkText("Continue")).click();
		System.out.println("Items in your cart page end");
	}
}
