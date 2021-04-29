Feature: Product Subscription


  Scenario: Validate the product price for a full special support plan for 6 months simulation
    Given I open Chrome and launch the application
    When I select type "Special"
    And  I select support plan "Full"
    And I write monthly duration of "6"
    And I click in calculate price button
    Then I validate price is "2249.10 $"

  Scenario Outline: : Validate the product prices variations
    Given I open Chrome and launch the application
    When I select type "<type>"
    And  I select support plan "<plan>"
    And I write monthly duration of "<duration>"
    And I click in calculate price button
    Then I validate price is "<price>"

    Examples:
      | type          | plan  | duration | price    |
      | Regular       | Basic | 1        | 24.99 $  |
      | Special       | Basic | 1        | 74.97 $  |
      | Extra Special | Basic | 1        | 124.95 $ |
      | Premium       | Basic | 1        | 174.93 $ |


# Considering the time available to do the project I wont do all variations

