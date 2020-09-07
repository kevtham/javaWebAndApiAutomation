package com.test.heroku;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/features"
,glue= {"com.test.heroku.stepDefnitions"}
)
public class TestRunner {

}
