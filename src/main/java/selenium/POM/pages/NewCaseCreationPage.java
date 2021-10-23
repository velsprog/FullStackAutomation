package selenium.POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import selenium.POM.BaseClass.BaseClass;

public class NewCaseCreationPage extends BaseClass {
	
	public NewCaseCreationPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public NewCaseCreationPage clickSearchContact() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@title='Search Contacts']"))));
		driver.findElement(By.xpath("//input[@title='Search Contacts']")).click();
		
		return this;
	}
	public NewCaseCreationPage clickNewContact() {
		
		return this;
	}
	public NewCaseCreationPage selectCaseOrigin() {
		
		return this;
	}
	public NewCaseCreationPage selectStatus() {
		
		return this;
	}
	public NewCaseCreationPage enterSubject() {
		
		return this;
	}
	public NewCaseCreationPage enterDescription() {
		
		return this;
	}
	public NewCaseCreationPage clickSave() {
		
		return this;
	}

}
