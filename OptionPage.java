package RegisterdomainName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OptionPage {
	
	// Upgrade options - private registration
	public void options1(WebDriver driver, int onoff){
		
		// wait
		try {
			Thread.sleep(5000);	// wait 10 second
		} catch (InterruptedException e) {
			System.out.println("10 second gone!!");
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

		// unable Web site Hosting
	    driver.findElement(By.xpath("(//input[@name='domain'])[2]")).click();
//	    driver.findElement(By.name("domain")).click();
	    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		System.out.println("Options2 end");
/*		// wait
		try {
			Thread.sleep(10000);	// wait 10 second
		} catch (InterruptedException e) {
			System.out.println("10 second gone!!");
		}
*/	}
	
	// Upgrade options - SiteLock Web site Security
	public void options3(WebDriver driver){
		// unable Website Hosting
        driver.findElement(By.xpath("(//input[@name='domain'])[3]")).click();
//	    driver.findElement(By.name("domain")).click();
		driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
		// wait
/*		try {
			Thread.sleep(10000);	// wait 10 second
		} catch (InterruptedException e) {
			System.out.println("10 second gone!!");
		}
*/		System.out.println("Options3 end");
	}
}
