package RegisterdomainName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class newshopcartpage {
	
	//Items in Your Cart page
	public void item(WebDriver driver, int year){
		// wait
		try {
			Thread.sleep(3000);	// wait 10 second
		} catch (InterruptedException e) {
			System.out.println("10 second gone!!");
		}
		
		Select listbox = new Select(driver.findElement(By.xpath("//select")));

		// 1 year default
		if ( year == 1 ){
			
		}else if ( year == 2){							// 2 years
			 listbox.selectByIndex(1);
		}else if ( year == 3){							// 3 years
			 listbox.selectByIndex(2);
		}else if ( year == 5){							// 5 years
			 listbox.selectByIndex(3);
		}else if ( year == 10){							// 10 years
			 listbox.selectByIndex(4);
		}
		
		driver.findElement(By.linkText("Continue")).click(); // 1 year default and continue

		System.out.println("Items in your cart page end");
	}
}
