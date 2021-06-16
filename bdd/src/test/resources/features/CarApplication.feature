Feature: Car insurance payment
  Functionalities:
  1. user is able to pay for car insurance for a hole year
  2. user has to pay 30% more this year because he had a car accident
  3. user receives a 10% discount for car insurance because he has reached the highest bonus category

  Scenario: user is able to pay for car insurance for a hole year
    Given "Cristi" goes to car insurance company "Allianz"
    And has in his wallet 1800 ron
    When he pays 390 ron
    Then the available funds that "Cristi" now has are 1410 ron
    And the insurance company fund has increased with 390 ron


  Scenario: user has to pay 30% more this year because he had a car accident
    Given "Stefan" goes to car insurance company "Tiriac Asigurari"
    And has in his wallet 1800 ron
    When he finds out that the standard car assurance plan costs 390 RON
    But he had a car accident this year and has to pay 50% more
    Then the available funds that "Cristi" now has are 1215 ron
    And the insurance company fund has increased with 585 ron
   # And the insurance company final fund is 585 ron

  Scenario: user receives a 10% discount for car insurance because he has reached the highest bonus category
    Given "Nicu" goes to car insurance company "Tiriac Asigurari"
    And has in his wallet 1000000 ron
    When he finds out that the standard car assurance plan costs 390 RON
    But he has a discount and pays 10% less
    Then the available funds that "Nicu" now has are 999649 ron
    And the insurance company fund has increased with 351 ron
   # And the insurance company final fund is 936 ron