package com.automation.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/automation/stepdefinitons",
        features = "@target/rerun.txt"
)

public class FailedTestRunner{
}
