Feature: TC_ADD_PERSONAL_LUGGAGE

  Scenario: User add personal luggage to a reservation
    Given The user is in the luggage management page
    When The user click the add luggage button
    And The user fill the personal luggage information
    And The user click the save luggage button
    Then The personal luggage must be added

  Scenario: User add more than one personal luggage to a reservation
    Given The user is in the luggage management page
    When The user click the add luggage button
    And The user fill the personal luggage information
    And The user click the save luggage button
    Then The luggage management page show an error
