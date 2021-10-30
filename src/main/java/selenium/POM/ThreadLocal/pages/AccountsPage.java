package selenium.POM.ThreadLocal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import selenium.POM.ThreadLocal.BaseClass.BaseClass;



public class AccountsPage extends BaseClass {
	
	public AccountsPage(String Browser) {
		this.Browser=Browser;
		System.out.println(Browser);
		System.out.println("This. : "+this.Browser);
	}
	public New_EditAccountPage clickNewButton() {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='New']/parent::a")));
		getDriver().findElement(By.xpath("//div[@title='New']/parent::a")).click();
		return new New_EditAccountPage(Browser);
	}
	public AccountsPage entersearchkey(String accountName) {
		getDriver().findElement(By.xpath("//input[contains(@placeholder,'Search this lis')]")).sendKeys(accountName,Keys.ENTER);
		return this;
	}
	public AccountsPage clickEditDropdownOf(String accountName) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//table[contains(@class,'forceRecordLayout')]/tbody/tr/th//a"), accountName));
		getDriver().findElement(By.xpath("//table[contains(@class,'forceRecordLayout')]/tbody/tr/td[6]//a")).click();
		return this;
	}
	public New_EditAccountPage clickEdit() {
		getDriver().findElement(By.xpath("//a[@title='Edit']")).click();
		return	new New_EditAccountPage(Browser);
	}
	public void verifyAccountCreated(String accountName) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[contains(@title,'"+accountName+"')]"), accountName));
		String actualText = getDriver().findElement(By.xpath("//div[contains(@title,'"+accountName+"')]")).getText();
		Assert.assertEquals(actualText,"\""+accountName+"\"");
	}
	public AccountsPage verifyAccountEdited(String accountName) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'toastMessage')]"), accountName));
		String actualText=getDriver().findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		Assert.assertEquals(actualText, "Account \""+accountName+"\" was saved.");
		return this;
	}
	public void verifyPhoneNumber(String phoneNum) {
		String actualPhoneNum = getDriver().findElement(By.xpath("//table[contains(@class,'forceRecordLayout')]/tbody/tr[1]/td[4]//span[contains(@class,'forceOutputPhone')]")).getText();
		Assert.assertEquals(actualPhoneNum,phoneNum);
	}
	

}
