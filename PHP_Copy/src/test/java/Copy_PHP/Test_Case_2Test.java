package Copy_PHP;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_Case_2Test {
	
	static By nav1_out=By.xpath("//div[@id='datepickers-container']//div[2]//nav[1]//div[2]");

	public static Logger log=Logger.getLogger(Test_Case_2Test.class);
	
	
	@BeforeTest
	public static void beforeSearch() throws Exception {
		PropertyConfigurator.configure("C:\\New Project\\PHP_Copy\\Resource\\log4j.properties");
		
		HomePage h1= new HomePage();
		log.info("Launch the browser");
		h1.launch();
	}
	
	//Hotel search
	@Test
	public static void hotelSearch() throws Exception {
	
		HomePage h1= new HomePage();
		
		h1.hotel().click();
		
		Hotel_Search h2= new Hotel_Search();
		
		//hotel or city name
		log.info("Enter the city name");
		h2.searchButton().sendKeys(h1.prop.getProperty("city_hotel"));
		h1.driver.findElement(By.xpath("//span[@class='select2-match'][contains(text(),'"+h1.prop.getProperty("city_hotel")+"')]")).click();
		
		
		//check in
		log.info("select the check in date");
		h2.checkIn().click();
		h2.navigateIn().click();
		h1.driver.findElement(By.xpath("//div[@class='datepicker--cell datepicker--cell-year'][contains(text(),'"+h1.prop.getProperty("check_in_year")+"')]")).click();
		h1.driver.findElement(By.xpath("//div[contains(text(),'"+h1.prop.getProperty("check_in_month")+"')]")).click();
		h1.driver.findElement(By.xpath("//div[1]//div[1]//div[2]//div[contains(text(),'"+h1.prop.getProperty("check_in_date")+"')]")).click();
		
		
		//check out
		log.info("select the check out date");
		h1.driver.findElement(nav1_out).click();
		h1.driver.findElement(By.xpath("//div[@class='datepicker--months datepicker--body active']//div[@class='datepicker--cell datepicker--cell-month'][contains(text(),'"+h1.prop.getProperty("check_out_month")+"')]")).click();
		h1.driver.findElement(By.xpath("//div[@id='datepickers-container']//div[2]//div[1]//div[contains(text(),'"+h1.prop.getProperty("check_out_date")+"')]")).click();
		log.info("Select number of guests");
		h2.adults().click();
		h2.child().click();
		h2.hotelSearchButton().click();
	}
	
	@AfterTest
	
	public static void afterSearch() {
		
		ValidationClass val= new ValidationClass();
		String result = val.hotelSearch().getText();
		log.info("Hotel search page is displayed");
		
		HomePage h1= new HomePage();
		String expected_result =h1.prop.getProperty("city_hotel");
		System.out.println(expected_result);
		
		
		Assert.assertEquals(result, expected_result);
		if(expected_result.equalsIgnoreCase(result)) {
			System.out.println("Passed");
			log.info("Hotel search is Passed");
		}
		else {
			System.out.println("Fail");
			log.error("Error: Hotel search failed");
		}
		h1.driver.close();
	}
}