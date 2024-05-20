Feature: TC_ADD_STORAGE_LUGGAGE

  Scenario: User add storage luggage to a reservation
    Given The user is in the luggage management page
    When The user click the add storage luggage button
    And The user fill the storage luggage information
    And The user click the save luggage button
    Then The luggage must be added

  Scenario: User add more than one storage luggage to a reservation
    Given The user is in the luggage management page
    When The user click the add storage luggage button
    And The user fill the storage luggage information
    And The user click the save luggage button
    Then The luggage must be added

  Scenario: User add storage luggage to a reservation with values greater than the max valid
    Given The user is in the luggage management page
    When The user click the add storage luggage button
    And The user fill the storage luggage information with values greater than the max valid
    And The user click the save luggage button
    Then The luggage management page show an error with the storage luggage valid max values