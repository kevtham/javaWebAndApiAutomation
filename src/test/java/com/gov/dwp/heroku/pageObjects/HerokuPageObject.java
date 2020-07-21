package com.gov.dwp.heroku.pageObjects;

import org.openqa.selenium.By;

public class HerokuPageObject {
    public static By apiName = By.xpath("//*[@id=\"swagger-ui\"]/div/div/div[1]/section/div/hgroup/h2");
    public static By jsonLink = By.xpath("//*[@id=\"swagger-ui\"]/div/div/div[1]/section/div/hgroup/a");
    public static By endPointLink = By.xpath("//*[@id=\"operations-tag-default\"]/small/div/p");
    public static By endPointList = By.xpath("//*[@id=\"swagger-ui\"]/div/div/div[2]/section/div/div");
}
