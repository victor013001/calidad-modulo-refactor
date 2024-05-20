Feature: TC_ADD_INVALID_TYPE_LUGGAGE

  Scenario: User add a luggage with invalid type to a reservation
    Given The user is in the luggage management page
    When The user click the add personal luggage button
    And The user fill the invalid luggage information
    And The user click the save luggage button
    Then The luggage management page show an error with the invalid type
