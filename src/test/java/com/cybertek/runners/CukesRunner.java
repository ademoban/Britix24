package com.cybertek.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@bitrix24"},
        features ={ "features"},
        glue = {"com\\cybertek\\step_definitions"},
        plugin = { "json:target\\cucumber.json",
                "html:target\\default-cucumber-reports"},
        dryRun = false

)

public class CukesRunner {
}
