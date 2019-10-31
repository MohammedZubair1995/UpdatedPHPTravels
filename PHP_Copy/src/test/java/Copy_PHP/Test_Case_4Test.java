package Copy_PHP;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Test_Case_4Test {
	
	public static Logger log= Logger.getLogger(Test_Case_4Test.class);
	
	@BeforeTest
	public static void beforeSearch() throws Exception {
		PropertyConfigurator.configure("C:\\New Project\\PHP_Copy\\Resource\\log4j.properties");
		log.info("Launch the browser");
		HomePage h1= new HomePage();
		h1.launch();
	}
	
	
	
	
	@Test
	public static void tourSearch() throws Exception {
		
		HomePage h1= new HomePage();
		h1.tours().click();
		log.info("Select the tour city");
		Tours_Search t1= new Tours_Search();
		t1.city().click();
		
		String city= h1.prop.getProperty("tour_name");
		h1.driver.findElement(By.xpath("//div[@class='select2-result-label'][contains(text(),'"+city+"')]")).click();
		
		//tour type
		log.info("Select the tour type");
		t1.tourType().click();
		//h1.driver.findElement(By.xpath("//div[@id='tourtype_chosen']//input[@class='chosen-search-input']")).sendKeys("Private");
		h1.driver.findElement(By.xpath("//li[contains(text(),'"+h1.prop.getProperty("tour_type")+"')]")).click();		
		
		log.info("select the date");
		//date
		t1.tourDate().click();
		t1.navigate().click();
		h1.driver.findElement(By.xpath("//div[@class='datepicker--cell datepicker--cell-year'][contains(text(),'"+h1.prop.getProperty("tour_year")+"')]")).click();
		h1.driver.findElement(By.xpath("//div[contains(text(),'"+h1.prop.getProperty("tour_month")+"')]")).click();

		//date
				for(int i = 1 ; i<=35 ; i++) {             
					String str1 = h1.driver.findElement(By.xpath("//div[6]//div[1]//div[1]//div[2]//div["+i+"]")).getText();             
					if(str1.equals("1")) {                 
						for(int j = i ; j<=35 ; j++) {                     
							str1 = h1.driver.findElement(By.xpath("//div[6]//div[1]//div[1]//div[2]//div["+j+"]")).getText();                                         
							if(str1.equals(h1.prop.getProperty("tour_date"))) {                         
								h1.driver.findElement(By.xpath("//div[6]//div[1]//div[1]//div[2]//div["+j+"]")).click();                         
								break;
								}                 
							}             
						}
					}         			
		log.info("Select the number of guests");
		t1.guest().click();
		t1.searchButton().click();
		
		
		
	}
	
	@AfterTest
	public static void afterSearch() {
		HomePage h1= new HomePage();
		String actual_result= h1.driver.getTitle();
		String expected_result= h1.prop.getProperty("tour_name");
		
		Assert.assertEquals(actual_result, expected_result);
		
		if(expected_result.equalsIgnoreCase(actual_result)) {
			System.out.println("Passed");
			log.info("Tour search passed");
		}
		else {
			System.out.println("Failed");
			log.error("Tour search failed");
		}
		h1.driver.close();
	}
	}