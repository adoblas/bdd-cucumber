package com.adoblas.cuke.stepDefintions;
import cucumber.api.java.en.Given;
import env.BaseTest;

public class UserStepDefinitions implements BaseTest{


    //Step to navigate to specified URL
    @Given("^I( securely)? navigate to page '([^\"]*)'$")
    public void navigate_toPage(String isSecured, String link)
    {
        if (isSecured != null) {
            link = "https://" + link;
        }
        else {
            link = "http://" + link;
        }
        navigationObj.navigateTo(link);
    }

}
