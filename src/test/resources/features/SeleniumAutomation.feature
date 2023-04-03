
Feature: Selenium Automation Practice
  Scenario: Practicing automatic form filling
    Given I open Chrome
    When I open practice form webpage
    Then I enter my name
    And I enter my email
    And I choose Gender and Profession
    And I enter country and skill
    And I click the button