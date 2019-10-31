package Copy_PHP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ValidationClass extends LaunchBrowser {
	
	static By name= By.xpath("//h3[contains(text(),'Hi, "+prop.getProperty("First_Name")+"')]");
	By hotel_city= By.xpath("//span[@class='text-primary'][contains(text(),'"+prop.getProperty("city_hotel").toLowerCase()+"')]");
	By flight= By.xpath("//h3[@class='heading-title']//span[contains(text(),'MAA')]");
	
	
	 public static WebElement registration() {
		return driver.findElement(name);
	}
	
	public WebElement hotelSearch() {
		return driver.findElement(hotel_city);
	}
	
	public WebElement flightSearch() {
		return driver.findElement(flight);
	}
}
