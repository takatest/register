package RegisterdomainName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage extends Page {
	public void logout(WebDriver driver, String baseUrl){
		
		waitForAWhile(5000);
	
		driver.findElement(By.linkText("My Account")).click();		// click my account button
		driver.findElement(By.linkText("Logout")).click();			// click log out button
		
		waitForAWhile(5000);
	}
}
