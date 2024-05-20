Feature: TC_ADD_PERSONAL_LUGGAGE

  Scenario: User add personal luggage to a reservation
    Given The user is in the luggage management page
    When The user click the add personal luggage button
    And The user fill the personal luggage information
    And The user click the save luggage button
    Then The luggage must be added

  Scenario: User add more than one personal luggage to a reservation
    Given The user is in the luggage management page
    When The user click the add personal luggage button
    And The user fill the personal luggage information
    And The user click the save luggage button
    Then The luggage management page show an error

  Scenario: User add personal luggage to a reservation with values greater than the max valid
    Given The user is in the luggage management page
    When The user click the add personal luggage button
    And The user fill the personal luggage information with values greater than the max valid
    And The user click the save luggage button
    Then The luggage management page show an error with the personal luggage valid max values

  Scenario: User add personal luggage to a reservation with values less than the min valid
    Given The user is in the luggage management page
    When The user click the add personal luggage button
    And The user fill the personal luggage information with values less than the min valid
    And The user click the save luggage button
    Then The luggage management page show an error with the invalid values