package selenium.week1.S014;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0139_EditDashboard {

	static ChromeOptions option;
	static ChromeDriver driver;
	static WebDriverWait wait;
	static JavascriptExecutor js;
	static String dashboardName = "Velmurugan";
	static String description = "SalesForce";
	static String actualText;

	public static void main(String[] args) {
		
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");

			// Webdriver Setup
			WebDriverManager.chromedriver().setup();

			// ChromeOption Setup
			option = new ChromeOptions();
			option.addArguments("--disable-notifications");

			// Create Chrome Driver Object
			driver = new ChromeDriver(option);

			// Create JavascriptExecutor instance and assign driver object
			js = (JavascriptExecutor) driver;

			// Wait Setup
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Maximize window
			driver.manage().window().maximize();

			// 1. Login to https://login.salesforce.com
			driver.navigate().to("https://login.salesforce.com");
			driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
			driver.findElement(By.id("Login")).click();

			// 2. Click on the toggle menu button from the left corner
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']")));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

			// 3. Click View All and click Dashboards from App Launcher
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			WebElement dashboardElement = driver.findElement(By.xpath("//p[@class='slds-truncate' and text()='Dashboards']"));
			js.executeScript("arguments[0].scrollIntoView();", dashboardElement);
			dashboardElement.click();

			// 4. Click on the Dashboards tab
			WebElement dashboardtabElement = driver.findElement(By.xpath("//a[@title='Dashboards']/span"));
			js.executeScript("arguments[0].click();", dashboardtabElement);

			// 5. Search the Dashboard 'Salesforce Automation by Your Name'
			driver.findElement(By.xpath("//span[@title='Created On']")).click();
			driver.findElement(
					By.xpath("//input[contains(@class,'search-text-field') and contains(@placeholder,'Search recent')]"))
					.sendKeys(dashboardName, Keys.ENTER);

			// 6. Click on the Dropdown icon and Select Edit
			WebElement tableElement = driver
					.findElement(By.xpath("//table[contains(@class,'slds-table_edit')]/tbody/tr[1]/th//a[contains(@title,'"+ dashboardName + "')]"));
			wait.until(ExpectedConditions.elementToBeClickable(tableElement));
			List<WebElement> tdElements = driver
					.findElements(By.xpath("//table[contains(@class,'slds-table_edit')]/tbody/tr[1]/td"));
			driver.findElement(By.xpath(
					"//table[contains(@class,'slds-table_edit')]/tbody/tr[1]/td[" + (tdElements.size()) + "]//button"))
					.click();
			driver.findElement(By.xpath("//a[@role='menuitem']/span[text()='Edit']")).click();

			// 7.Click on the Edit Dashboard Properties icon
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@title='Edit Dashboard Properties']")).click();

			// 8. Enter Description as 'SalesForce' and click on save.
			driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).clear();
			driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).sendKeys(description);
			driver.findElement(By.id("submitBtn")).click();

			// 9. Click on Done and Click on save in the popup window displayed.
			driver.findElement(By.xpath("//div[@class='actionRibbon']//button")).click();
			driver.findElement(By.xpath("//div[@class='actionRibbon']/following::button")).click();
			
			
			  if(driver.findElements(By.xpath("//div[contains(@class,'saveModal')]/footer/button[text()='Save']")).size()!=0) {
				  driver.findElement(By.xpath("//div[contains(@class,'saveModal')]/footer/button[text()='Save']")).click(); 
			  }
			  driver.switchTo().defaultContent();
			  
			  //10. Verify the Description.
			  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			  actualText=driver.findElement(By.xpath("//p[@class='slds-page-header__info']")).getText(); Assert.assertEquals(actualText, description);
			  driver.switchTo().defaultContent();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
		  //Close the driver 
		  driver.quit();
		}
		 
	}

}