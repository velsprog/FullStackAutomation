package selenium.POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import selenium.POM.BaseClass.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	public LoginPage enterUsername(String LoginID) {
		driver.findElement(By.id("username")).sendKeys(LoginID);		
		return this;
	}
	public LoginPage enterPassword(String Password) {
		driver.findElement(By.id("password")).sendKeys(Password);
		return this;	
	}
	public HomePage clickLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("Login")));
		driver.findElement(By.id("Login")).click();
		return new HomePage(driver);
	}
	
}
