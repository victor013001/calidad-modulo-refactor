Feature: TC_ADD_HAND_LUGGAGE

  Scenario: User add hand luggage to a reservation
    Given The user is in the luggage management page
    When The user click the add hand luggage button
    And The user fill the hand luggage information
    And The user click the save luggage button
    Then The luggage must be added

  Scenario: User add more than one hand luggage to a reservation
    Given The user is in the luggage management page
    When The user click the add hand luggage button
    And The user fill the hand luggage information
    And The user click the save luggage button
    Then The luggage must be added

  Scenario: User add hand luggage to a reservation with values greater than the max valid
    Given The user is in the luggage management page
    When The user click the add hand luggage button
    And The user fill the hand luggage information with values greater than the max valid
    And The user click the save luggage button
    Then The luggage management page show an error with the hand luggage valid max values