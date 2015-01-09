package RegisterdomainName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EligibilityDetailsPage {

	public void EligiblityComAU(WebDriver driver) {

		 WebDriverWait wait = new WebDriverWait(driver, 30);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("entityname_input")));

/*		driver.findElement(By.id("entityname_input")).clear();
	    driver.findElement(By.id("entityname_input")).sendKeys("Melbourne IT services");
		System.out.println("test3");

		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i.oicons.abnnumber")));

		driver.findElement(By.cssSelector("i.oicons.abnnumber")).click();
		System.out.println("test4");
	    driver.findElement(By.xpath("//div[@id='abn_results']/ul/li[2]")).click();
		System.out.println("test5");
	    driver.findElement(By.name("submit")).click();
*/	    
	    driver.findElement(By.id("abn_no")).click();
	    driver.findElement(By.id("registrantidnumber_input")).clear();
	    driver.findElement(By.id("registrantidnumber_input")).sendKeys("86156516004");
	    driver.findElement(By.name("organisationinstitution")).clear();
	    driver.findElement(By.name("organisationinstitution")).sendKeys("MELBOURNE IT SERVICES");
		
		new Select(driver.findElement(By.cssSelector("#comau_etype_org"))).selectByVisibleText("Company");
		  
		  //		driver.findElement()w Select(driver.findElement(By.xpath("//select[@id='comau_etype_org']"))).selectByVisibleText("Company");
		
	    driver.findElement(By.name("submit")).click();

	}
}
