package RegisterdomainName;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import ManageDomain.CheckDomainSpace;


public class RetailWebTest {

	private int 							year = 1;				// year 1,2
	private FirefoxDriver 					driver;					// firefox driver
	private String 							myaccount;				// my account			property
	private String 							password;				// my account password	property
	private String 							myaccountex ="TAKAEXPRICE";	// my account			currently use external
	private String 							passwordex = "password";	// my account password	external
    private static int						domain_num = 1;			// number of domain
	private static String[] 				domain_space = {".bike",".net",".camera",".melborne",".info",".camera"};// domain space
   
	private static SearchDomainPage 		searchPage;				// search domain page
    private static LoginPage 	 			loginPage;				// login page
    private static ReviewPage				ReviewPage;				// Review page
    private static PaymentPage				PaymentPage;			// Payment page
    private static CompletePage				CompletePage;			// Complete page
    private static LogoutPage				logOutPage;				// Log out page
    private static EligibilityDetailsPage	EligibilityDetailsPage;	// Eligibity AU page
    private static oldandnewflow			oldandnewflow;			// old cart flow
    private static CheckDomainSpace			CheckDomainSpace;		// check if domain space can support private reg or not
    private static int						newcount = 0;			// counter for new cart
	private String baseUrl = "https://stage.melbourneit.com.au/";		//URL stage
//	private String baseUrl = "https://www.melbourneit.com.au/";		//URL prod
    
	@BeforeTest
	public void BeforeTest() {
		 driver = new FirefoxDriver();
//		 driver.get(baseUrl); 
		 
	    // create page object
        searchPage = new SearchDomainPage();
        loginPage = new LoginPage();
        EligibilityDetailsPage = new EligibilityDetailsPage(); 
        ReviewPage = new ReviewPage();
        PaymentPage = new PaymentPage();
        CompletePage = new CompletePage();
        logOutPage = new LogoutPage();
        oldandnewflow = new oldandnewflow();
        CheckDomainSpace = new CheckDomainSpace();
        
        
        System.out.println("-------------Register Domain Start--------------");
        
        Properties prop = new Properties();
    	InputStream input = null;
     
    	try {
    		input = new FileInputStream("config.properties");
     
    		// load a properties file
    		prop.load(input);
     
    		// get the property value and print it out
    		myaccount = prop.getProperty("myaccount");
      		password = prop.getProperty("password");
      		System.out.println("My account - " + myaccount);
    		System.out.println("My account PW - " + password);
    	     
    	} catch (IOException ex) {
    		ex.printStackTrace();
    	} finally {
    		if (input != null) {
    			try {
    				input.close();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
    	}
	}

	@BeforeMethod
	public void BeforeMethod(){
		driver.get(baseUrl); 
	}
	
	// set up data
	@DataProvider(name = "GetDomain")
	public static Object[][] domainName() {
		Object[][] data = new Object[domain_num][2];
		for (int k = 0; k<domain_num; k++){
			String domainName = searchPage.CreateDomainName(domain_space[k]);
			data[k][0]= k+1;
			data[k][1]= domainName;
		}
		return data;
	}

/********************************************************************************************
 * 	
 * Register domain name test
 * 
 ********************************************************************************************/
	// old shopping cart only
	@Test(dataProvider = "GetDomain",enabled =false)
	public void RegisterDomain(int number, String domainName){
	
		//Search domain page
	     System.out.println("-------------------"+number+"-Register-"+domainName+"-------------------------");
		searchPage.searchDomain(driver, domainName);
	     System.out.println("search page");

/// same until above	     
    	//login page
		loginPage.loginmyaccount(driver,baseUrl, myaccount, password);
	    System.out.println("log into My account end");

	    // if AU domain
	    if (domainName.indexOf(".com.au") > 0 ||domainName.indexOf(".net.au") > 0 ){
	    	EligibilityDetailsPage.EligiblityComAU(driver);
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

	// new shopping cart and also old shopping cart version
	@Test(dataProvider = "GetDomain")
	public void RegisterDomain2(int number, String domainName){
	
		//Search domain page
	     System.out.println("-------------------"+number+"-Register-"+domainName+"-------------------------");
		searchPage.searchDomain(driver, domainName);

		if ( CheckDomainSpace.newshopcart(domainName) == true){
			/// new flow
			System.out.println("new view cart flow");
	        oldandnewflow.newcart(newcount,driver, domainName, baseUrl, myaccountex, passwordex, year);
	        newcount++;
	        System.out.println("new cart counter =" + newcount);
		}else{
	        System.out.println("old view cart flow");
	        oldandnewflow.oldcart(driver, domainName, baseUrl, myaccount, password, year);
		}
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Register Domain Completed");
		driver.quit();
	}
}
