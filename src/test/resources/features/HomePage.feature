Feature: As a User I want to SignUp

  Scenario Outline: Create new user

    Given Open the web site and assert 'https://www.obilet.com/' website
    When Click Login Button
    Then assert pop-up text 'Üye Girişi'
    And Click sign up button
    Then assert pop-up text 'Üye Ol'
    Then User enters '<mail>' and '<password>' and Click register button
    Then User assert profile part is visible
    Examples:
      |mail             |password         |
      |asdassdfsdf23dg@example.com |examplepasword1  |



