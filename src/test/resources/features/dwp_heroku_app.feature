@smoke
Feature: Feature to test the Herokku app

  Background: 
    Given I need to set the environment and the driver based on the input provided

  @herokkuAppSuccess
  Scenario: This scenario test the successful flow of heroku app
    Given I want to launch the app for the URL "http://bpdts-test-app-v2.herokuapp.com/"
#    Then I need to check the page has loaded with expected values
#    And I need to get the list of endpoint and validate
    And I need to close the browser
