package Copy_PHP;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Flight_Search extends LaunchBrowser{
	

	By from= By.xpath("//div[@id='s2id_location_from']//a[@class='select2-choice']");
	By to= By.xpath("//div[@id='s2id_location_to']//a[@class='select2-choice']");
	By departure_date= By.xpath("//input[@id='FlightsDateStart']");
	By adults= By.xpath("(//button[contains(text(),'+')])[3]");
	By child= By.xpath("(//button[contains(text(),'+')])[4]");
	By infant= By.xpath("(//button[contains(text(),'+')])[5]");
	By one_way= By.xpath("//div[@class='tab-content shad RTL_shad search-form']//div[1]//div[1]//div[1]//ins[1]");
	By search= By.xpath("//div[contains(@class,'col-xs-12 col-md-1')]//button[contains(@class,'btn-primary btn btn-block')][contains(text(),'Search')]");
	
	By nav1= By.xpath("//div[7]//nav[1]//div[2]");
	By nav2= By.xpath("(//div[@class='datepicker--nav-title'])[7]");
	By next=By.xpath("(//div[@data-action='next'])[7]");
	
	
	public WebElement from(){
		return driver.findElement(from);
	}
	
	
	public WebElement to() {
		return driver.findElement(to);
	}
	
	public WebElement departureDate() {
		return driver.findElement(departure_date);
	}
	
	public WebElement adults() {
		return driver.findElement(adults);
	}
	
	public WebElement child() {
		return driver.findElement(child);
	}
	
	public WebElement infantb() {
		return driver.findElement(infant);
	}
	
	WebElement oneWay() {
		return driver.findElement(one_way);
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
