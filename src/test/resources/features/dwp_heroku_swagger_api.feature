@smoke
Feature: Feature to test the Herokku app swagger endPoints

  Background: 
    Given I need to set the base-uri for the endpoint

  @cityUser
  Scenario: This scenario test the city user swagger endPoints
    Given I need to call the endpoint for city users and validate

  @instructions
  Scenario: This scenario test the instructions swagger endPoints
    Given I need to call the endpoint for instructions and validate

  @userID
  Scenario: This scenario test the userId swagger endPoints
    Given I need to call the endpoint for userId and validate

  @users
  Scenario: This scenario test the users swagger endPoints
    Given I need to call the endpoint for users and validate
