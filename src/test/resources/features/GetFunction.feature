Feature: Read/Get Function Positive and Negative Test Cases

  Scenario: verify getting right item with valid values
    Given User makes request to read the pets By Status
    When User gets the relevant data
    Then status code should be 200


  Scenario: verify NOT getting any response with invalid values
    Given User makes get request with wrong ID value
    When User doesnt get any response data
    Then status code should be 404