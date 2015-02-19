package RegisterdomainName;

import org.openqa.selenium.WebDriver;
import ManageDomain.CheckDomainSpace;

public class oldandnewflow {
		
//		private static SearchDomainPage 		searchPage = new SearchDomainPage();			// search domain page
		private static LoginPage 	 			loginPage = new LoginPage();					// login page
	    private static ReviewPage				ReviewPage = new ReviewPage();					// Review page
	    private static PaymentPage				PaymentPage = new PaymentPage();				// Payment page
	    private static CompletePage				CompletePage = new CompletePage();				// Complete page
	    private static LogoutPage				logOutPage = new LogoutPage();					// Log out page
	    private static EligibilityDetailsPage	EligibilPage = new EligibilityDetailsPage();	// Eligibity AU page
	    
	    private static newshopcartpage			newshoppage = new newshopcartpage();			// new shopping cart page
	    private static OptionPage				optionpage	= new OptionPage();					// option page
	    private static CheckDomainSpace			CheckDomainSpace = new CheckDomainSpace();		// check domain space		
	    private static EligibilityDetailsPage	EligibilityDetailsPage = new EligibilityDetailsPage();// Eligiblity AU
	    
	    private static int 						privateregflag = 0; 							// 0 = off, 1 = on for private reg
	    
	public void oldcart(WebDriver driver, String domainName, String baseUrl, String myaccount, String password, int year){
		//login page
		loginPage.loginmyaccount(driver,baseUrl, myaccount, password);
	    System.out.println("log into My account end");

	    // if AU domain
	    if (domainName.indexOf(".com.au") > 0 ||domainName.indexOf(".net.au") > 0 ){
	    	EligibilPage.EligiblityComAU(driver);
		    System.out.println("EligibilityDetails end");
	    }

	    //Review your order 1 year
		ReviewPage.OneYearOrder(driver, domainName, year);
	    System.out.println("Review end");

		// Payment Page
		PaymentPage.PaybyCredit(driver, baseUrl);
	    System.out.println("Payment end");
	     
		// Complete Page
		CompletePage.CompleteSuccess(driver);
		System.out.println("Complete end");
	
		// Log out Page
		logOutPage.logout(driver, baseUrl); 
		System.out.println("log out My account");
		System.out.println("Yeah success!!");
	}
	public void newcart(int number, WebDriver driver, String domainName, String baseUrl, String myaccount, String password, int year){

		// Items in your Cart
		newshoppage.item(driver, year);
		if ( number == 0 ){												// if login to first time
			loginPage.newlogin(driver,myaccount,password);				// login to my account
		}else{
			loginPage.newloginagain(driver);							// if not login to first time, use same my account
		}
		// if AU domain, enter Eligibility details
		if (CheckDomainSpace.audomain(domainName)== true){
			EligibilityDetailsPage.newEligiblityau(driver);
			// option2 Upgrade options - Web Hosting
			optionpage.options2au(driver);
			// option3 SiteLock Web site Security
			optionpage.options3au(driver);
		}else{
			// option1 private registration 0 = off, 1 = on
			optionpage.options1(driver, privateregflag);
			
			// option2 Upgrade options - Web Hosting
			optionpage.options2(driver);
	
			// option3 SiteLock Web site Security
			optionpage.options3(driver);
		}
		// new payment page
		PaymentPage.newpayment(driver);
		// complete page
		CompletePage.newComplete(driver);
	}
}
