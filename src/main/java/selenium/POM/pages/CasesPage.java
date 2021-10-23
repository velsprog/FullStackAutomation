package selenium.POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import selenium.POM.BaseClass.BaseClass;

public class CasesPage extends BaseClass {
	
	public CasesPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public CasesPage clickCasesTab() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Cases']/following-sibling::*//a[contains(@class,'slds-button_reset')]")));
		Thread.sleep(500);
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[@title='Cases']/following-sibling::*//a[contains(@class,'slds-button_reset')]")));
		return this;
	}
	public NewCaseCreationPage clickNewCase() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'slds-dropdown')]//span[text()='New Case']")));
		Thread.sleep(500);
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//div[contains(@class,'slds-dropdown')]//span[text()='New Case']")));
		return new NewCaseCreationPage(driver);
	}
	public CasesPage verifyNewCaseCreated() {
		
		return this;
	}
	public void writecaseIDbacktoExcel() {
		
	}

}
