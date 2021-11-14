package selenium.POM.ThreadLocal.CucumberPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import selenium.POM.ThreadLocal.BaseClass.BaseClass;

public class ContentPage extends BaseClass{
	
	@And("Click ViewAll under Todays Task")
	public ContentPage clickViewAllInTodaysTask() {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath($("ContentPage.ViewAllInTodaysTask.xpath"))));
		WebElement el = getDriver().findElement(By.xpath($("ContentPage.ViewAllInTodaysTask.xpath")));
		getJSExecutor().executeScript("arguments[0].scrollIntoView();", el);
		getJSExecutor().executeScript("arguments[0].click();", el);
		return this;
	}
	@And("Click New Task in Contents Page")
	public New_EditTaskPage ClickNewTask() {
		getWait().until(ExpectedConditions.elementToBeClickable(By.xpath($("ContentPage.DisplayAsButton.xpath"))));
		getDriver().findElement(By.xpath($("ContentPage.DisplayAsButton.xpath"))).click();
		getDriver().findElement(By.xpath($("ContentPage.DisplayAsSplitView.xpath"))).click();
		getDriver().findElement(By.xpath($("ContentPage.MoreActionDropDown.xpath"))).click();
		getDriver().findElement(By.xpath($("ContentPage.NewTaskLink.xpath"))).click();
		return new New_EditTaskPage();
	}
	@Then("Verify {string} is displaying in ToastMessage") 
	public void verifyToastMessage(String subject) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'toastMessage') and contains(text(),'Task')]"), subject));
		String actualText = getDriver().findElement(By.xpath("//span[contains(@class,'toastMessage') and contains(text(),'Task')]")).getText();
		Assert.assertEquals(actualText, "Task "+subject+" was created.");
	}
	
	@And("Click the {string} for Edit Task")
	public New_EditTaskPage clickEditForTask(String subject) throws InterruptedException {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath($("General.FirstRecordinTable.xpath")), subject));
		Thread.sleep(1000);
		getDriver().findElement(By.xpath($("ContentPage.OptionsDropDown.xpath"))).click();
		getDriver().findElement(By.xpath($("General.EditRecordButton.xpath"))).click();
		return	new New_EditTaskPage();
	}
	
	@Then("Verify {string} is displaying in EditToastMessage") 
	public void verifyEditToastMessage(String subject) {
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'toastMessage') and contains(text(),'Task')]"), subject));
		String actualText = getDriver().findElement(By.xpath("//span[contains(@class,'toastMessage') and contains(text(),'Task')]")).getText();
		Assert.assertEquals(actualText, "Task \""+subject+"\" was saved.");
	}
	

}
