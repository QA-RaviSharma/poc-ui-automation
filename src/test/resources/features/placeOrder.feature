Feature: Allow user to place an order on Swaglabs

  Scenario: Logins with registered user and place an order successfully
    When User logins into Swaglabs system with valid credentials
    When User clicks on add to cart button on inventory page
    When User clicks on cart button on inventory page
    When User clicks on checkout button the cart page
    When User enters all details in the checkout information fields and clicks on continue button
    When User overviews the order and clicks on finish button on the checkout overview page
    Then User should be land on checkout finish page successfully
