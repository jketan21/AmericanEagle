package junitcucumber;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;		


@RunWith(Cucumber.class)				
//@CucumberOptions(features="Features",glue={"/AmericanEagle/src/test/java/ae/StepDefinition"})						
public class Runner 
{		

	
	
	private TestNGCucumberRunner testNGCucumberRunner;
	
	
	// Create Properties class object to read properties file
	@BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
	
	
	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider()
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}
	
	 @AfterClass(alwaysRun = true)
	    public void tearDownClass() throws Exception {
	        testNGCucumberRunner.finish();
	    }

}

