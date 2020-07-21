package com.gov.dwp.heroku.stepDefnitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gov.dwp.heroku.pageObjects.HerokuPageObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DwpHerokkuAppSteps extends HerokuPageObject{
    final static  Logger log = Logger.getLogger(DwpHerokkuAppSteps.class);
    static WebDriver driver;

    @Given("I need to set the environment and the driver based on the input provided")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/kgnana741/Documents/Software/chromedriver");
        driver = new ChromeDriver();
    }

    @Given("I want to launch the app for the URL {string}")
    public void launchUrl(String url) throws InterruptedException {
        log.info("Attempting to call the url=" + url);
        driver.navigate().to(url);
        Thread.sleep(2000);
    }

    @Then("I need to check the page has loaded with expected values")
    public void ValidateData() {
        log.info("Attempting to validate the data for the Heroku App");
        String apiText = driver.findElement(apiName).getText();
        String jsonText = driver.findElement(jsonLink).getText();

        //assert Values
        assertFalse(apiText.isEmpty());
        assertEquals("http://bpdts-test-app-v2.herokuapp.com/swagger.json", jsonText);
        driver.findElement(endPointLink).click();
    }

    @Given("I need to get the list of endpoint and validate")
    public void validateEndPoint() {
        log.info("Attempting to validate the List of herokku User endPoint is Displayed");
        assertTrue(driver.findElement(endPointList).isDisplayed());
    }


    @Given("I need to close the browser")
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

}
