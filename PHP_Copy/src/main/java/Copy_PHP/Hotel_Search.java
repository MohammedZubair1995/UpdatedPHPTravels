package Copy_PHP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Hotel_Search extends LaunchBrowser {

	By search_city_click= By.xpath("//span[contains(text(),'Search by Hotel or City Name')]");
	By search_city= By.xpath("//div[@id='s2id_autogen1']//a[@class='select2-choice']");
	By check_in= By.id("checkin");
	By check_out= By.id("checkout");
	By adults= By.xpath("(//button[contains(text(),'+')])[1]");
	By child= By.xpath("(//button[contains(text(),'+')])[2]");
	By search= By.xpath("(//button[contains(text(),'Search')])[1]");
	
	By nav1_in=By.xpath("//div[1]//nav[1]//div[2]");
	By nav2_in=By.xpath("(//div[@class='datepicker--nav-title'])[1]");
	By next_in=By.xpath("(//div[@data-action='next'])[1]");
	
	By nav1_out=By.xpath("//div[@id='datepickers-container']//div[2]//nav[1]//div[2]");
	By nav2_out=By.xpath("(//div[@class='datepicker--nav-title'])[2]");
	By next_out=By.xpath("(//div[@data-action='next'])[2]");
	
	
	public WebElement searchButton() {
		driver.findElement(search_city_click).click();
		return driver.findElement(search_city);
	}
	
	public WebElement checkIn() {
		return driver.findElement(check_in);
	}
	
	public WebElement checkOut() {
		return driver.findElement(check_out);
	}
	
	public WebElement adults(){
		return driver.findElement(adults);
	}
	
	public WebElement child() {
		return driver.findElement(child);
	}
	
	public WebElement hotelSearchButton(){
		return driver.findElement(search);
	}
	
	public WebElement navigateIn() {
		driver.findElement(nav1_in).click();
		driver.findElement(nav2_in).click();
		return driver.findElement(next_in);
	}
	
	public WebElement navigateOut() {
		driver.findElement(nav1_out).click();
		driver.findElement(nav2_out).click();
		return driver.findElement(next_out);
	}
}

