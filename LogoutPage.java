package RegisterdomainName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
	public void logout(WebDriver driver, String baseUrl){
		driver.findElement(By.linkText("My Account")).click();		// click my account button
		driver.findElement(By.linkText("Logout")).click();			// click log out button
	}
}
