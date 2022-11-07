Feature: Allow user to login into Swaglabs system

  Scenario: User logins into Swaglabs system with valid detailssw
    When User enters valid details in email and password fields
      | userName        | password       |
      | valid user name | valid password |
    And User clicks on login button on Swaglabs login page
    Then User should be login in Swaglabs successfully and able to see the inventory

  Scenario Outline: User logins into Swaglabs system with invalid details
    When User enters valid details in email and password fields
      | userName   | password   |
      | <userName> | <password> |
    And User clicks on login button on Swaglabs login page
    Then User should not be login in Swaglabs successfully and should be error validation message
      | Epic sadface: Username and password do not match any user in this service |
      | Epic sadface: Username and password do not match any user in this service |
    Examples:
      | userName          | password         |
      | valid user name   | invalid password |
      | invalid user name | valid password   |

    Scenario: Login into Swaglabs system scenario used in other scenarios
      When User logins into Swaglabs system with valid credentials
