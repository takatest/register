package RegisterdomainName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page {

	private String baseUrl;
	private String url;

	public void loginmyaccount(WebDriver driver, String baseUrl, String myaccount, String password) {
		//https://www.melbourneit.com.au/domain-search/available/
		url= driver.getCurrentUrl();
		
		String url2 = baseUrl+"domain-search/available/";			// prod
	//	String url2 = baseUrl+"domain-search/";						// stage
		if (url.equals(url2)){
			System.out.println("Enter Hosting page");
			driver.findElement(By.cssSelector("button.btn-continue")).click();
		}
		 WebDriverWait wait = new WebDriverWait(driver, 50);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("log_username")));
			
		driver.findElement(By.id("log_username")).clear();
		driver.findElement(By.id("log_username")).sendKeys(myaccount);
		driver.findElement(By.id("log_password")).clear();
		driver.findElement(By.id("log_password")).sendKeys(password);
	    driver.findElement(By.cssSelector("div.midWrapperForm1.midWrapperForm1-override > div.divGroup > span.account-nform-frame > span.form-button.submit > button[name=\"submit\"]")).click();
	}
	
}
