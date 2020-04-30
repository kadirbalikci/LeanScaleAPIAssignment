Feature: Update/Put Function Positive and Negative Test Cases


  Scenario: verify updating values successfully with valid data
    Given User makes Put request to update an order
    When User gets id in the message
    Then status code should be 200


  Scenario: verify NOT getting any response with invalid values
    Given User makes Put request with invalid data
    When User gets error message
    Then status code should be 500