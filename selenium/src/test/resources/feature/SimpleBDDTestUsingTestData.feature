Feature: BDD Test data tests


  Scenario Outline: Visit multiple web applications and check for their titles
    Given user access web application with url "<url>"
    When the checks the title of the page
    Then the title of the page he navigated to is "<title>"
    Examples:
      | url                      |  | title                                               |
      | https://www.depurtat.ro/ |  | dEpurtat.ro - Magazinul tău cu încălțăminte de damă |
      | https://www.dedeman.ro/  |  | Dedeman Magazin Online - Dedicat planurilor tale    |
      | https://www.emag.ro/     |  | ó eMAG.ro - Libertate în fiecare zi                 |