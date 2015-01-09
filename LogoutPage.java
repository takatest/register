package RegisterdomainName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {
	public void logout(WebDriver driver, String baseUrl){
		
	//	waitForAWhile(5000);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
//		driver.findElement(By.xpath("//a[contains(@href, '/cc/myaccount/menu/')]")).click();
//		driver.findElement(By.xpath("//span[2]/span/a")).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		driver.findElement(By.linkText("My Account")).click();		// click my account button
		driver.findElement(By.linkText("Logout")).click();			// click log out button

	
	}
}
