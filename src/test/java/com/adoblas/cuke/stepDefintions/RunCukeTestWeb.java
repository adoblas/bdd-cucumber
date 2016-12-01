package com.adoblas.cuke.stepDefintions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//		plugin = {"html:target/cucumberHtmlReport"},
		//pretty:target/cucumber-json-report.json
		features = "src/test/resources/com/adoblas/cuke/features/wSearch.feature"
)

public class RunCukeTestWeb {
}
