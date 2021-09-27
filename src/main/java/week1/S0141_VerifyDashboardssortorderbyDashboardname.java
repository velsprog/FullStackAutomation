package week1;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
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

public class S0141_VerifyDashboardssortorderbyDashboardname {
	
	static ChromeOptions option;
	static ChromeDriver driver;
	static WebDriverWait wait;
	static JavascriptExecutor js;
	static List<String> expectedList;
	static List<String> actualList;
	

	public static void main(String[] args) throws IOException, InterruptedException {

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
		
		expectedList = new ArrayList<String>();
		actualList = new ArrayList<String>();

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
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// 3. Click View All and click Dashboards from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement dashboardElement = driver.findElement(By.xpath("//p[@class='slds-truncate' and text()='Dashboards']"));
		js.executeScript("arguments[0].scrollIntoView();", dashboardElement);
		dashboardElement.click();

		// 4. Click on the Dashboards tab
		WebElement dashboardtabElement = driver.findElement(By.xpath("//a[@title='Dashboards']/span"));
		js.executeScript("arguments[0].click();", dashboardtabElement);
		WebElement scrollbar = driver.findElement(By.xpath("//div[@class='slds-scrollable_y']"));
//		 js.executeScript("window.scrollBy(300,300)",""); 
		
		scrollbar.click();
		for(int i=0;i<3;i++ ) {
			scrollbar.sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(1000);
		}
		
		List<WebElement> noOfRows = driver.findElements(By.xpath("//table[contains(@class,'slds-table_edit')]/tbody/tr"));
		for(int i=1;i<=noOfRows.size();i++) {
			expectedList.add(driver.findElement(By.xpath("//table[contains(@class,'slds-table_edit')]/tbody/tr["+i+"]/th//a")).getText().trim());
		}
		Collections.sort(expectedList,String.CASE_INSENSITIVE_ORDER);
		
		//5. Click the sort arrow in the Dashboard Name.
		driver.findElement(By.xpath("//span[@title='Dashboard Name']")).click();
		
		//6. Verify the Dashboard displayed in ascending order by Dashboard name.
		scrollbar = driver.findElement(By.xpath("//div[@class='slds-scrollable_y']"));
		scrollbar.click();
		for(int i=0;i<3;i++ ) {
			scrollbar.sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(1000);
		}
		noOfRows = driver.findElements(By.xpath("//table[contains(@class,'slds-table_edit')]/tbody/tr"));
		for(int i=1;i<=noOfRows.size();i++) {
			actualList.add(driver.findElement(By.xpath("//table[contains(@class,'slds-table_edit')]/tbody/tr["+i+"]/th//a")).getText().trim());
		}
		System.out.println(expectedList.equals(actualList));
		Assert.assertEquals(actualList, expectedList);
		
		//Close the driver
		driver.quit();		
	}

}
