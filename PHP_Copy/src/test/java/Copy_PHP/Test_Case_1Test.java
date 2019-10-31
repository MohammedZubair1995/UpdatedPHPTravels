package Copy_PHP;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


//User registration
public class Test_Case_1Test {
	
	
	public static Logger log=Logger.getLogger(Test_Case_1Test.class);
	
	@BeforeTest
	public static void beforeRegistration() throws Exception {
		PropertyConfigurator.configure("C:\\New Project\\PHP_Copy\\Resource\\log4j.properties");
		
		HomePage h1= new HomePage();
		log.info("Launching the browser");
		h1.launch();
		
	}
	
	
	@Test
	public static void userRegistration() throws Exception {
	
		
		HomePage h1= new HomePage();
		h1.signUp();
		
		log.info("Registering the user");
		RegisterationPage r1= new RegisterationPage();
		r1.firstName().sendKeys(h1.prop.getProperty("First_Name"));;
		r1.lastName().sendKeys(h1.prop.getProperty("Last_Name"));;
		r1.mobileNo().sendKeys(h1.prop.getProperty("Mobile_no"));;
		r1.email().sendKeys(h1.prop.getProperty("Email"));;
		r1.password().sendKeys(h1.prop.getProperty("Password"));;
		r1.confirmPassword().sendKeys(h1.prop.getProperty("Confirm_P"));
		h1.driver.manage().deleteAllCookies();
		r1.submitButton();
	}
	
	@AfterTest
	public static void afterRegistration() {
		
		ValidationClass val= new ValidationClass();
		String result_name = val.registration().getText();
		log.debug("Successfull Registration");
		
		HomePage h1= new HomePage();
		String expected_name ="Hi, "+ h1.prop.getProperty("First_Name")+" "+h1.prop.getProperty("Last_Name");
		System.out.println(expected_name);
		Assert.assertEquals(result_name, expected_name);
		
		if(expected_name.equalsIgnoreCase(result_name)) {
			System.out.println("Passed");
			log.info("Registration validation Pass");
		}
		else {
			System.out.println("Fail");
			log.error("Error: User name is differrent");
		}
		h1.driver.close();
	}
}