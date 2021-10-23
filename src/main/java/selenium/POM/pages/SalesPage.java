package selenium.POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import selenium.POM.BaseClass.BaseClass;

public class SalesPage extends BaseClass {
	
	public SalesPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public SalesPage clickMore() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='More']")));
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[text()='More']"))); 
		return this;
	}
	public CasesPage selectCaseFromDropDown() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'slds-dropdown')]//span[text()='Cases']")));
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//div[contains(@class,'slds-dropdown')]//span[text()='Cases']")));
		return new CasesPage(driver);
	}

}
