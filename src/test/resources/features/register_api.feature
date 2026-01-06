@registerApi
Feature: User Registration API
 
  Scenario: Successful user registration
    Given the user registration data is prepared 
    When I send a POST request     
    Then the response status code should be 200
    And the response body should contain responseCode 201
  
