package assesment.selenium;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assessment1 {

	static ChromeOptions option;
	static ChromeDriver driver;
	static WebDriverWait wait;
	static JavascriptExecutor js;
	static int openAmt,ClosedAmt;
	static WebElement ddbutton;
	static String dashboardName="Velmurugan_Workout";
	static String description="testing";
	static String creatDBToastMsg;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
				
			//1. Login to https://login.salesforce.com
			driver.get("https://login.salesforce.com/");
			driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
			driver.findElement(By.id("Login")).click();
			
			//2. Click on toggle menu button from the left corner
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']")));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			
			//3. Click view All 
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			
			//4. Click Service Console from App Launcher
			driver.findElement(By.xpath("//p[@class='slds-truncate' and text()='Service Console']")).click();
			
			//5. Select Home from the DropDown
			if(!(driver.findElement(By.xpath("//div[contains(@class,'selectedListItem')]/a")).getText().equalsIgnoreCase("Home"))) {
				driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
				ddbutton=driver.findElement(By.xpath("//span[@class='slds-media__body']/span[text()='Home']"));
				js.executeScript("arguments[0].scrollIntoView();", ddbutton);
				js.executeScript("arguments[0].click();", ddbutton);
			}
			//6. Add CLOSED + OPEN values and result should set as the GOAL (If the result is less than 10000 then set the goal as 10000)
			Thread.sleep(3000);
			ClosedAmt=Integer.parseInt(driver.findElement(By.xpath("//span[@class='metricLabel' and text()='Closed']/following-sibling::span")).getText().split("\\$")[1]);
			openAmt=Integer.parseInt(driver.findElement(By.xpath("//span[@class='metricLabel' and contains(text(),'Open')]/following-sibling::span")).getText().split("\\$")[1]);
			if((openAmt+ClosedAmt)<10000) {
				driver.findElement(By.xpath("//button[@title='Edit Goal']")).click();
				driver.findElement(By.xpath("//span[@id='currencyCode']/following-sibling::input")).clear();
				driver.findElement(By.xpath("//span[@id='currencyCode']/following-sibling::input")).sendKeys("10000");
				driver.findElement(By.xpath("//span[contains(@class,'label bBody') and text()='Save']")).click();
			}
			//7. Select Dashboards from DropDown
			driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
			ddbutton=driver.findElement(By.xpath("//span[@class='slds-media__body']/span[text()='Dashboards']"));
			js.executeScript("arguments[0].scrollIntoView();", ddbutton);
			js.executeScript("arguments[0].click();", ddbutton);
			
			//8. Click on New Dashboard
			driver.findElement(By.xpath("//a[@title='New Dashboard']/div")).click();
			
			//9. Enter the Dashboard name as "YourName_Workout"
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys(dashboardName);
			
			//10. Enter Description as Testing and Click on Create
			driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).clear();
			driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).sendKeys(description);
			driver.findElement(By.id("submitBtn")).click();
			//11. Click on Done
			driver.findElement(By.xpath("//div[@class='actionRibbon']/following::button")).click();
			
			//12. Verify the Dashboard is Created
			creatDBToastMsg=driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
			
			//13. Click on Subscribe
			//14. Select Frequency as "Daily"
			//15. Time as 10:00 AM
			//16. Click on Save
			//17. Verify "You started Dashboard Subscription" message displayed or not
			//18. Close the "YourName_Workout" tab
			//19. Click on Private Dashboards
			//20. Verify the newly created Dashboard available
			//21. Click on dropdown for the item
			//22. Select Delete
			//23. Confirm the Delete
			//24. Verify the item is not available under Private Dashboard folder
		}catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
