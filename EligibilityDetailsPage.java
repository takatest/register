package RegisterdomainName;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EligibilityDetailsPage {

	public void EligiblityComAU(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("entityname_input")));

		driver.findElement(By.id("abn_no")).click();
	    driver.findElement(By.id("registrantidnumber_input")).clear();
	    driver.findElement(By.id("registrantidnumber_input")).sendKeys("86156516004");
	    driver.findElement(By.name("organisationinstitution")).clear();
	    driver.findElement(By.name("organisationinstitution")).sendKeys("MELBOURNE IT SERVICES");
		
		new Select(driver.findElement(By.cssSelector("#comau_etype_org"))).selectByVisibleText("Company");
	    driver.findElement(By.name("submit")).click();
	}
	// AU Eligibility page for new shopping cart 
	public void newEligiblityau(WebDriver driver) {
		
		// wait
		try {
			Thread.sleep(5000);	// wait 3 second
		} catch (InterruptedException e) {
		}
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.id("busName")).clear();
	    driver.findElement(By.id("busName")).sendKeys("MELBOURNE IT SERVICES");
	    driver.findElement(By.id("busNoValue")).clear();
	    driver.findElement(By.id("busNoValue")).sendKeys("86156516004");
	    new Select(driver.findElement(By.id("busType"))).selectByVisibleText("Partnership");
	    driver.findElement(By.id("busCert")).click();
	    driver.findElement(By.cssSelector("button.btn.red")).click();
		System.out.println("AU Eligibility end");
	}	
}