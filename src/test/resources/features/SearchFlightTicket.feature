Feature: As a User I want to SignUp

  Scenario Outline: Choose Ticket Two Way

    Given Open the web site and assert 'https://www.obilet.com/' website
    When Click the flight button and assert 'https://www.obilet.com/ucak-bileti' website
    And Users enters From '<Gidis>' to '<Donus>'
    Then User click ChenckInDate and CheckOutDate
    And User click the flight search button
    Then User assert availible flights
    And User click random depurter flight and choose flight type
    And User click random return flight and choose flight type
    Then User assert tickets


    Examples:
      |Gidis                |Donus             |
      |Esenboğa             |Şakirpaşa         |


