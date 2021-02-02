Feature: Counting the number of the Values projected in the application

  Scenario Outline: Verifing the number of values with respect prices displaying on screen
    Given User launch the application url
    When User is on the home page <title>
    Then Verify is prices are displaying on page
    Then Verify the right <Count> of values appear on the screen
    And Close the application

    Examples: 
      | title    | Count |
      | Homepage |     5 |
