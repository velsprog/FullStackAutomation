package selenium.POM.ThreadLocal.CucumberRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import selenium.POM.ThreadLocal.BaseClass.BaseClass;

@CucumberOptions(features = "..\\FullStackAutomationPgm\\src\\main\\java\\selenium\\POM\\ThreadLocal\\CucumberFeatures\\S012",
				glue = "selenium\\POM\\ThreadLocal\\CucumberPages")
public class Runner extends BaseClass {
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
	

}
