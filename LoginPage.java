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

		// if go to hosting option page, click one step before login to my account
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
	
	// login to my account from Main page on the top right corner
	public void normalloginmyaccount(WebDriver driver, String myaccount, String passsword){
	    driver.findElement(By.linkText("Login")).click();
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys(myaccount);
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(passsword);
	    driver.findElement(By.id("submit")).click();
	}

	public void newlogin(WebDriver driver) {
		// wait
		try {
			Thread.sleep(3000);	// wait 10 second
		} catch (InterruptedException e) {
			System.out.println("10 second gone!!");
		}
		driver.findElement(By.cssSelector("form[name=\"loginForm\"] > div > div.element-group > #username")).clear();
	    driver.findElement(By.cssSelector("form[name=\"loginForm\"] > div > div.element-group > #username")).sendKeys("takaexprice");
	    driver.findElement(By.cssSelector("form[name=\"loginForm\"] > div > div.element-group > #password")).clear();
	    driver.findElement(By.cssSelector("form[name=\"loginForm\"] > div > div.element-group > #password")).sendKeys("password");
	    driver.findElement(By.cssSelector("div > div.element-group.cta > button.btn.red")).click();
	 
		System.out.println("login to my account end");
	}
	public void newloginagain(WebDriver driver){
		// continue
		driver.findElement(By.xpath("//button[@type='button']")).click();
		System.out.println("Returning Customer end");
	}
}
