package Copy_PHP;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_Case_5Test {
	public static Logger log= Logger.getLogger(Test_Case_5Test.class);
	
	@BeforeTest
	public static void beforeLogIn() throws Exception {
		PropertyConfigurator.configure("C:\\New Project\\PHP_Copy\\Resource\\log4j.properties");
		log.info("Launch the browser");
		HomePage h1= new HomePage();
		h1.launch();
	}

	@Test
	public void logIn() throws Exception {
		
		HomePage h1= new HomePage();
		h1.driver.get(h1.prop.getProperty("url"));
		h1.logIn();
		log.info("Log into the account");
		Log_In l1= new Log_In();
		l1.email().sendKeys(h1.prop.getProperty("Email"));
		l1.password().sendKeys(h1.prop.getProperty("Password"));
		l1.logIn().click();
		Thread.sleep(10000);
	}
	
	@AfterTest
	public static void afterRegistration() {
		
		ValidationClass val= new ValidationClass();
		String result_name = val.registration().getText();
		System.out.println(result_name);
		
		HomePage h1= new HomePage();
		String expected_name ="Hi, "+ h1.prop.getProperty("First_Name")+" "+h1.prop.getProperty("Last_Name");
		System.out.println(expected_name);
		Assert.assertEquals(result_name, expected_name);
		
		if(expected_name.equalsIgnoreCase(result_name)) {
			System.out.println("Passed");
			log.info("Log in test case passed");
		}
		else {
			System.out.println("Fail");
			log.error("Log in test case failed");
		}
		h1.driver.close();
	}
}
