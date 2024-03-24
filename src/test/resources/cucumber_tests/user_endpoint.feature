Feature: User Endpoint Test

  Scenario: Creating a new user with correct data
    When a call is made to /api/v1/user endpoint with POST method and correct_data body
    Then the response status code is 201
    And user exists in database

  Scenario: Creating a new user with incorrect data
    When a call is made to /api/v1/user endpoint with POST method and incorrect_data body
    Then the response status code is 400
    And user does not exist in database
