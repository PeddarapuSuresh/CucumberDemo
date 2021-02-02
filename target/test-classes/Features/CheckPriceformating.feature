Feature: Verifying the total balance

  Scenario Outline: Verifying the labels prices to match total balance
    Given User launch the application url
    When User is on the home page <title>
    Then Verify is prices are displaying on page
     Then verify the values are formatted as currencies
      And Close the application
