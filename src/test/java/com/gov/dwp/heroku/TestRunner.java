package com.gov.dwp.heroku;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/features"
,glue= {"com.gov.dwp.heroku.stepDefnitions"}
)
public class TestRunner {

}
