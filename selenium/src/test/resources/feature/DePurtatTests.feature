Feature: dePurtat.ro web application BDD Selenium tests


  In this feature file we will create some test scenarios
  for our e-commerce web application. This application and tests
  were developed for demo purpose.


  Scenario: Verify that user is able to access web application
    Given the user accesses web application
    When he checks for the main elements on the page
    Then they are displayed
    And after the check he closes the browser

  Scenario Outline: Verify that registered user can log in
    Given the user accesses web application
    When he logs in into his account with username "<username>" and password "<password>"
    Then he can validate that he is logged in
    And after the check he closes the browser
    Examples:
      | username                  | password             |  |
      | barosanunumber1@gmail.com | Cemaifacetidragilor? |  |


  Scenario Outline: Verify that registered user can log in and logout
    Given the user accesses web application
    And he logs in into his account with username "<username>" and password "<password>"
    When he logs out from his account
    Then he can validate that he is logged out
    And after the check he closes the browser
    Examples:
      | username                  | password             |  |
      | barosanunumber1@gmail.com | Cemaifacetidragilor? |  |


    Scenario: Verify that user can add multiple products to his favourite list
      Given the user accesses web application
      And navigates to Noutati page
      When he add multiple favourite products into his favourite list
      Then the favourite has his previously added favourite products
      And after the check he closes the browser
