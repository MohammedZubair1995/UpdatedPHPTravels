package Copy_PHP;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Test_Case_3Test {
	
	public static Logger log= Logger.getLogger(Test_Case_3Test.class);
	
	@BeforeTest
	public static void beforeSearch() throws Exception {
		PropertyConfigurator.configure("C:\\New Project\\PHP_Copy\\Resource\\log4j.properties");
		log.info("Launch the browser");
		HomePage h1= new HomePage();
		h1.launch();
	}
	
	
	@Test
	public static void fightSearch() throws Exception{
		
		HomePage h1= new HomePage();
		h1.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		h1.flights().click();
		
		Flight_Search f1= new Flight_Search();
		log.info("enter from city");
		f1.from().click();
		f1.from().sendKeys(h1.prop.getProperty("from_location"));
		h1.driver.findElement(By.xpath("//span[@class='select2-match'][contains(text(),'"+h1.prop.getProperty("from_location")+"')]")).click();
		log.info("enter to city");
		f1.to().click();
		f1.to().sendKeys(h1.prop.getProperty("to_city"));
		h1.driver.findElement(By.xpath("//span[@class='select2-match'][contains(text(),'"+h1.prop.getProperty("to_city")+"')]")).click();
		log.info("Select the date");
		f1.departureDate().click();
		f1.navigate().click();
		h1.driver.findElement(By.xpath("//div[@class='datepicker--cell datepicker--cell-year'][contains(text(),'"+h1.prop.getProperty("f_year")+"')]")).click();
		h1.driver.findElement(By.xpath("//div[contains(text(),'"+h1.prop.getProperty("departure_month")+"')]")).click();
		
		//date
		for(int i = 1 ; i<=35 ; i++) {             
			String str1 = h1.driver.findElement(By.xpath("//div[7]//div[1]//div[1]//div[2]//div["+i+"]")).getText();             
			if(str1.equals("1")) {                 
				for(int j = i ; j<=35 ; j++) {                     
					str1 = h1.driver.findElement(By.xpath("//div[7]//div[1]//div[1]//div[2]//div["+j+"]")).getText();                                         
					if(str1.equals(h1.prop.getProperty("departure_date"))) {                         
						h1.driver.findElement(By.xpath("//div[7]//div[1]//div[1]//div[2]//div["+j+"]")).click();                         
						break;
						}                 
					}             
				}
			}         				
		log.info("Select the number of guests");
		f1.adults().click();
		f1.child().click();		
		f1.infantb().click();
		//Thread.sleep(1000);
		//h1.driver.findElement(By.xpath("//button[@id='cookyGotItBtn']")).click();
		f1.searchButton().click();
	}

	@AfterTest
	public static void afterSearch() {
		
		HomePage h1= new HomePage();
		String actual_result = h1.driver.getTitle();
		String expected_res= h1.prop.getProperty("flight_res");
		Assert.assertEquals(actual_result, expected_res);
		if(actual_result.equalsIgnoreCase(expected_res)) {
			System.out.println("Passed");
			log.info("flight search paassed");
		}
		else {
			System.out.println("Failed");
			log.error("Flight search failed");
		}
		h1.driver.close();
	}
	
	
	}
