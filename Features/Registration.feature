#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Registration page
  I want to use this template for my feature file

  @sanity
  Scenario: New user registration
    Given I launch chrome browser
    When I open homepage url "https://demo.perscholastraining.com/"
    And I click on MyAccount button
    And I entered username as "Admin189645" and email as "pertest49755@gmail.com" and password as "PERscholas$123" in registration form
    And I clicked on Register button
    Then I validate My Account heading is displayed on page
    And close chrome browser

  @tc2
  Scenario Outline: New user registration data driven
    Given I launch chrome browser
    When I open homepage url "https://demo.perscholastraining.com/"
    And I click on MyAccount button
    And I entered username as "<username>" and email as "<email>" and password as "<password>" in registration form
    And I clicked on Register button
    Then I validate My Account heading is displayed on page
    And close chrome browser
    
    Examples:
        | username | email | password |
        | Admin1254496778 | pertest643973@gmail.com | PERscholas$123 |
        | Admin12345967078 | pertest619733@gmail.com | PERscholas$123 |