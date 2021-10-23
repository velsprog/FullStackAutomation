package selenium.POM.testcases.S017;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import selenium.testNG.Base.BaseClass;
import selenium.utility.Util;

public class S0153_CreateNewCase extends BaseClass{
 
	public static String caseID;
	public static int row=0,col=0;
	
	@BeforeClass(alwaysRun = true)
	public void getData( ) {
		
		fileName="S0153_CreateNewCase";
		sheetName="Sheet1";
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void gotoCaseTab() {
		
	}
	
	@Test(dataProvider = "data")
	public void newCaseCreation(String Salutation,
								String FirstName, 
								String LastName, 
								String CaseOrigin, 
								String Status, 
								String Subject, 
								String Description) throws InterruptedException {
		
		
		
		
		driver.findElement(By.xpath("//span[@title='New Contact']")).click();
		
		driver.findElement(By.xpath("//span[text()='Salutation']/parent::span/following-sibling::div//a[@class='select']")).click();
		driver.findElement(By.xpath("//ul[@class='scrollable']/li[@role='presentation']/a[@title='"+Salutation+"']")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(FirstName);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(LastName);
		
		driver.findElement(By.xpath("//div[contains(@class,'modal-footer')]//button[@title='Save']")).click();
		
		driver.findElement(By.xpath("//span[text()='Case Origin']/parent::span/following-sibling::div//a[@class='select']")).click();
		driver.findElement(By.xpath("//ul[@class='scrollable']/li[@role='presentation']/a[@title='"+CaseOrigin+"']")).click();
		
		driver.findElement(By.xpath("//label[text()='Status']//following-sibling::div//input")).click();
		driver.findElement(By.xpath("//span[@title='"+Status+"']")).click();
		
		driver.findElement(By.xpath("//span[text()='Subject']/parent::label/following-sibling::input")).sendKeys(Subject);
		driver.findElement(By.xpath("//span[text()='Description']/parent::label/following-sibling::textarea")).sendKeys(Description);
		
		driver.findElement(By.xpath("//div[@class='inlineFooter']//button[@title='Save']")).click();
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated((By.xpath("//span[contains(@class,'toastMessage')]")), "Case"));
		String actualToastMsg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		
		caseID = driver.findElement(By.xpath("//p[@title='Case Number']/following-sibling::p//lightning-formatted-text")).getText();
		
		Assert.assertEquals(actualToastMsg,"Case \""+caseID+"\" was created.");
		row=row+1;
		System.out.println(row);
		new Util().writeExcel("S0154_EditCase", sheetName, caseID,row,col);
		new Util().writeExcel("S0155_DeleteCase", sheetName, caseID,row,col);
	}
}
