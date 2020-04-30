Feature: Delete Function Positive and Negative Test Case


  Scenario: verify delete function works correctly with valid data
    Given User makes Delete request to remove an existing order with valid data
    When User gets delete message
    Then status code should be 200

  @wip
  Scenario: verify NOT getting any response with invalid values
    Given User makes Delete request with invalid order id
    When User gets not found error message
    Then status code should be 404