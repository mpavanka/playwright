Feature: login FB
    Scenario: login with valid credentials
        Given I open the Facebook login page
        When I enter valid username and password
        And I click on the login button
        Then I should be logged in successfully