Feature: Create/Post Function Positive and Negative Test Cases

  Scenario: verify getting right item with valid values
    Given User makes Post request to create a new order with valid values
    When User gets relevant message
    Then status code should be 200


  Scenario: verify NOT getting any response with invalid values
    Given User makes Post request with invalid values
    When User gets error message
    Then status code should be 500