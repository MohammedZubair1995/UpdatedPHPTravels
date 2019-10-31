package Copy_PHP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends LaunchBrowser {

	 By my_account= By.xpath("(//a[@id='dropdownCurrency'])[2]");
	 By sign_up= By.xpath("//a[@class='dropdown-item tr']");
	 By login= By.xpath("//a[@class='dropdown-item active tr']");
	 By hotels= By.xpath("//a[@class='text-center hotels active']");
	 By flights= By.xpath("//a[contains(@class,'text-center flights')]");
	 By tours= By.xpath("//a[contains(@class,'text-center tours')]");
	 By cars= By.xpath("//a[contains(@class,'text-center transfer')]");
	 
	  public void signUp() {
		driver.findElement(my_account).click();
		driver.findElement(sign_up).click();
	}
	
	 public void logIn() {
		driver.findElement(my_account).click();
		driver.findElement(login).click();
	}
	
	 public WebElement hotel() {
		return driver.findElement(hotels);
	}
	
	 public WebElement flights(){
		return driver.findElement(flights);
	}
	 
	 public WebElement tours() {
		 return driver.findElement(tours);
	 }
	 
	 WebElement cars() {
		 return driver.findElement(cars);
	 }
}
