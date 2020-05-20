package com.LeanScale.step_definitions;

import java.util.concurrent.TimeUnit;


import com.LeanScale.utilities.ConfigurationReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.LeanScale.utilities.Driver;

import cucumber.api.Scenario;


public class Hooks {


	@Before
	public void setUp() {
		RestAssured.baseURI = ConfigurationReader.get("url");
		// we put a logic that should apply to every scenario
		Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown(Scenario scenario) {
		// only takes a screenshot if the scenario fails
		if (scenario.isFailed()) {
			// taking a screenshot
			final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		Driver.closeDriver();
	}
	
	
	
	
	
}
