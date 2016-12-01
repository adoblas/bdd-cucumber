package com.adoblas.cuke.stepDefintions;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks {
	@After("@NegativeTest")
	public void beforeScenario(Scenario scenario) {
	}
}
