Feature: dePurtat.ro web application BDD Selenium tests


  In this feature file we will create some test scenarios
  for our e-commerce web application. This application and tests
  were developed for demo purpose.



  Scenario: Verify that user is able to access web application
    Given the user accesses web application
    When he checks for the main elements on the page
    Then they are displayed