package RegisterdomainName;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OptionPage {
	public void oldoption(WebDriver driver){
		
	    driver.findElement(By.linkText("Add to Cart")).click();
	    assertEquals("", driver.findElement(By.cssSelector("a.cta-selected > span.glyphicon.glyphicon-ok")).getText());
	    driver.findElement(By.linkText("remove")).click();
	    assertEquals("Add to Cart", driver.findElement(By.linkText("Add to Cart")).getText());
	    driver.findElement(By.cssSelector("div.footer > div.table > div.cell > a.mit-button")).click();
	    assertEquals("remove", driver.findElement(By.cssSelector("div.footer > div.table > div.cell > a.cta-selected")).getText());
	    driver.findElement(By.cssSelector("div.footer > div.table > div.cell > a.cta-selected")).click();
	    assertEquals("Add to Cart", driver.findElement(By.cssSelector("div.footer > div.table > div.cell > a.mit-button")).getText());
	    driver.findElement(By.cssSelector("div.section.hosting > div.footer > div.table > div.cell > a.mit-button")).click();
	    assertEquals("remove", driver.findElement(By.cssSelector("div.section.hosting > div.footer > div.table > div.cell > a.cta-selected")).getText());
	    driver.findElement(By.cssSelector("div.section.hosting > div.footer > div.table > div.cell > a.cta-selected")).click();
	    assertEquals("Add to Cart", driver.findElement(By.cssSelector("div.section.hosting > div.footer > div.table > div.cell > a.mit-button")).getText());

		driver.findElement(By.cssSelector("button.btn-continue")).click();
	}
	
	// Upgrade options - private registration
	public void options1(WebDriver driver, int onoff){
		
		// wait
		try {
			Thread.sleep(5000);	// wait 10 second
		} catch (InterruptedException e) {
			System.out.println("5 second gone!!");
		}
		// unable Private Registration
		if ( onoff == 0){
		    driver.findElement(By.name("domain")).click();
		    driver.findElement(By.cssSelector("button.btn.red")).click();
		}else{	// able Private Registration
		    driver.findElement(By.cssSelector("button.btn.red")).click();
		}
		System.out.println("Options1 end");
	}
	
	// Upgrade options - Web Hosting
	public void options2(WebDriver driver){

		// untick Web site Hosting
	    driver.findElement(By.xpath("(//input[@name='domain'])[2]")).click();
	    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		System.out.println("Options2 end");
	}
	
	// Upgrade options - SiteLock Web site Security
	public void options3(WebDriver driver){
		// unable Website Hosting
        driver.findElement(By.xpath("(//input[@name='domain'])[3]")).click();
		driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
		System.out.println("Options3 end");
	}
	
	// Upgrade options - Web Hosting for AU domain
	public void options2au(WebDriver driver){

		// wait
		try {
			Thread.sleep(5000);	// wait 5 second
		} catch (InterruptedException e) {
		}
		// untick Web site Hosting
	    driver.findElement(By.cssSelector("div.cell.label")).click();
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Options2AU end");
	}
	
	// Upgrade options - SiteLock Web site Security for AU domain
	public void options3au(WebDriver driver){
		// untick sitelock web site
        driver.findElement(By.xpath("//div[2]/form/div/div[2]/div/div")).click();
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		System.out.println("Options3AU end");
	}
}
