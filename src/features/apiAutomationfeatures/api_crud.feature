Feature: CRUD resqres

  Scenario: TC002 – Add user with job

    Given I use the user creation service
    When I set name "Toy"
    And I set job "singer"
    And I build the payload
    And I send the post request
    Then I validate the user creation response is correct

  Scenario: TC003 – Delete user

    Given I use the user deletion service
    When I try to delete the user "2"
    Then I validate the delete response is correct

  Scenario: TC004 – Register new user without password

    Given I use the user registering service
    When I set email as "challenge@automation.com"
    And I set the password as ""
    And I build the register payload
    And I send the register post request
    Then I validate the register response is correct with status "400"


