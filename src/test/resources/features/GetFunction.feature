Feature: Read/Get Function Positive and Negative Test Cases


  Scenario: verify getting categories with valid data
    Given User makes get request to see the Categories
    When User gets the relevant data
    Then Verify status code 200 and content type

  @wip
  Scenario Outline: verify category ID's with valid data
    Given User makes get request with the <ID> to see specific category
    When User gets the data with the <ID> successfully
    Then Verify status code 200 and content type
    Examples:
      | ID |
      | 38 |
      | 20 |
      | 11 |
      | 3  |
      | 9  |
      | 7  |
      | 29 |
      | 37 |


  Scenario: verify NOT getting any response with invalid values
    Given User makes get request with wrong ID value
    When User doesnt get any response data
    Then status code should be 404



#  38, 20, 11, 3, 9, 7, 29, 37