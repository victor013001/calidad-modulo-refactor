Feature: TC_DELETE_PERSONAL_LUGGAGE

  Scenario: User delete personal luggage to a reservation
    Given The user is in the luggage management page
    When The user click the see my luggage button
    And The user sees all his luggage
    And The user click the delete luggage button
    And The user sees the confirmation message
    And The user click the delete luggage button
    And The user sees the confirmation message
    And The user click the delete luggage button
    And The user sees the confirmation message
    And The user click the delete luggage button
    And The user sees the confirmation message
    And The user click the delete luggage button
    And The user sees the confirmation message
    Then The luggage list shows no luggage
