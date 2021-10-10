package selenium.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util {
	
	static List<String> winList;
	static Set<String> windows;
	
	public static String getLastWindow(WebDriver driver) {
		windows=driver.getWindowHandles();
		winList= new ArrayList<String>();
		winList.addAll(windows);

		return (winList.get(winList.size()-1));
	}
}
