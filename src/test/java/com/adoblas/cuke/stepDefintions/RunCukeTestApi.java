package com.adoblas.cuke.stepDefintions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty","html:target/cucumber-reports/html","json:target/cucumber-reports/json/cucumber.json"},
        features = {"src/test/resources/com/adoblas/cuke/features/rSearch.feature"},
        glue = {"com.adoblas.cuke.stepDefintions.step"}
)

public class RunCukeTestApi {
}
