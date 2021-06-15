Feature: Banking application

  Functionalities:
  1. user is able to deposit money into his account
  2. user is able to withdraw money from his account
  3. user is able to send money into his wife (children) account
  4. user is able to receive money into his account
  5. user is able to receive money into his account from another person
  6. user is not able to transfer money above specific limit

  Scenario: user is able to deposit money into his account
    Given user access his banking account using his card
    And his account balance is 2000 ron
    When he deposit 500 ron
    Then his balance will reflect the deposit he previously made
    And his new balance will be 2500 ron

  Scenario: user is able to withdraw money from his account
    Given user access his banking account using his card
    And his account balance is 2000 ron
    When he withdraws 500 ron
    Then his balance will reflect the withdraw he previously made
    And his new balance will be 1500 ron

  Scenario: user is able to send money into his wife (children) account
    Given user access his banking account using his card
    And his account balance is 2000 ron
    When he transfers 500 ron to "Gigel" account
    Then his balance will reflect the transfer he previously made
    And his new balance will be 1500 ron

  Scenario: user is able to receive money into his account
    Given Alex access his banking account using his card
    And his account balance is 3000 ron
    When he transfers 500 ron to "Ionel" account
    Then his balance will reflect the transfer he previously made
    And his new balance will be 2500 ron

  Scenario: user is not able to transfer money above specific limit
    Given user access his banking account using his card
    And his account balance is 2000 ron
    When he transfers 11000 ron to "Gigel" account
    Then his balance will reflect the transfer he previously made
    And his new balance will be 1500 ron