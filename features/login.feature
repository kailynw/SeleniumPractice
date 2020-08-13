Feature: User Login

  Scenario: User enters correct username and password
    Given user enters username and password
    When user clicks the login button
    Then They are logged in

  Scenario: User enter incorrect username and password
    Given user enters incorrect username and password
    When user clicks the login button
    Then an unauthorized error appears and they are not logged in