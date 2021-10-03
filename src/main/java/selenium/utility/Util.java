package selenium.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;

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
