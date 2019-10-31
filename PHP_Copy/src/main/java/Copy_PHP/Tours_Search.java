package Copy_PHP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Tours_Search extends LaunchBrowser {

	By city_click= By.xpath("//span[contains(text(),'Search by Listing or City Name')]");
	By select_city= By.xpath("//div[@id='s2id_autogen3']//a[@class='select2-choice select2-default']");
	By tour_type= By.xpath("//span[contains(text(),'Select')]");
	By date= By.xpath("//input[@id='DateTours']");
	By adults= By.xpath("//div[contains(@class,'col-md-12')]//button[contains(@class,'btn btn-white bootstrap-touchspin-up')][contains(text(),'+')]");
	By search= By.xpath("//div[contains(@class,'ftab-inner menu-horizontal-content')]//button[contains(@class,'btn btn-primary btn-block')][contains(text(),'Search')]");
	
	By nav1=By.xpath("//div[6]//nav[1]//div[2]");
	By nav2= By.xpath("(//div[@class='datepicker--nav-title'])[6]");
	By next=By.xpath("(//div[@data-action='next'])[6]");
	
	public WebElement city() {
		return driver.findElement(city_click);
	}
	
	WebElement selectCity() {
		return driver.findElement(select_city);
	}
	
	public WebElement tourType() {
		return driver.findElement(tour_type);
	}
	
	public WebElement tourDate() {
		return driver.findElement(date);
	}
	
	public WebElement guest() {
		return driver.findElement(adults);
	}
	
	public WebElement searchButton() {
		return driver.findElement(search);
	}
	
	public WebElement navigate() {
		driver.findElement(nav1).click();
		driver.findElement(nav2).click();
		return driver.findElement(next);
	}
}
