Feature: Verifying the application labels lists 

  Scenario Outline: Verifying the projection labels vs prices 
    Given User launch the application url
    When User is on the home page <title>
    Then Verify is prices are displaying on page
    Then verify the values on the screen are greater than <value>
    And verify the values on the screen are Null
    And Close the application
