Feature: Verifying the total balance

  Scenario Outline: Verifying the labels prices to match total balance
    Given User launch the application url
    When User is on the home page <title>
    Then Verify is prices are displaying on page
     Then verify the total balance is correct based on the values listed on the screen
    And verify the values on the screen are Null
    And Close the application
