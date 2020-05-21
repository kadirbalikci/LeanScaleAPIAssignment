Feature: Read/Get Function Positive and Negative Test Cases

  Scenario: verify getting categories with valid data
    Given User makes get request to see the Categories
    When User gets the relevant data
    Then Verify status code 200 and content type


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


  Scenario: verify NOT getting any response with invalid data
    Given User makes get request with wrong ID value
    When User doesn't get any response data
    Then status code should be 404


  Scenario: Verifying values of What's New category
    Given User makes get request to see What's New category details
    When Correct data should ve displayed about the What's New category
    Then Verify status code 200 and content type


  Scenario: Verifying values of Women category
    Given User makes get request to see Women category details
    When Correct data should ve displayed about the Women category
    Then Verify status code 200 and content type


  Scenario: Verifying values of Men category
    Given User makes get request to see "Men" category details
    When Correct data should ve displayed about the "Men" category
    Then Verify status code 200 and content type


  Scenario: Verifying values of Gear category
    Given User makes get request to see Gear category details
    When Correct data should ve displayed about the Gear category
    Then Verify status code 200 and content type


  Scenario: Verifying values of Training category
    Given User makes get request to see Training category details
    When Correct data should ve displayed about the Training category
    Then Verify status code 200 and content type


  Scenario: Verifying values of Collections category
    Given User makes get request to see Collections category details
    When Correct data should ve displayed about the Collections category
    Then Verify status code 200 and content type

  Scenario: Verifying values of Promotions category
    Given User makes get request to see Promotions category details
    When Correct data should ve displayed about the Promotions category
    Then Verify status code 200 and content type
  @wip
  Scenario: Verifying values of Sale category
    Given User makes get request to see Sale category details
    When Correct data should ve displayed about the Sale category
    Then Verify status code 200 and content type



