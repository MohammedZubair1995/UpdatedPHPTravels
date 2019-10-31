package Copy_PHP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Log_In extends LaunchBrowser {

	static By email= By.xpath("//input[@placeholder='Email']");
	static By password= By.xpath("//input[@placeholder='Password']");
	static By login= By.xpath("//button[@class='btn btn-primary btn-lg btn-block loginbtn']");
	
	public WebElement email() {
		return driver.findElement(email);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement logIn() {
		return driver.findElement(login);
	}
}
