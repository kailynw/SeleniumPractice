Feature: Form Completion

  Scenario: User fills out and submits form
    Given The user selects their country using the select box
    Then enters their address
    Then enters their email
    Then enters their phone
    Then clicks the save button
    And success text is displayed
