Feature: Checking the requirements for creating objects
  These scenarios are testing the requirements for creating objects at each level of the hierarchy in the 'Inventory'.

  Scenario: Testing TC_6_1_1
    Given URL-page for inventory page
    When When I create new object with <Create country>
    Then Object with type <Country> must be created

  Scenario: Testing TC_6_1_2
    Given URL-page for inventory page
    When When I create new object with <Create city>
    Then Object with type <City> must be created

  Scenario: Testing TC_6_1_3
    Given URL-page for inventory page
    When When I create new object with <Create building>
    Then Object with type <Building> must be created

  Scenario: Testing TC_6_1_4
    Given URL-page for inventory page
    When When I create new object with <Create floor>
    Then Object with type <Floor> must be created

  Scenario: Testing TC_6_1_5
    Given URL-page for inventory page
    When When I create new object with <Create room>
    Then Object with type <Room> must be created

  Scenario: Testing TC_6_1_6
    Given URL-page for inventory page
    When When I create new object with <Create rack>
    Then Object with type <Rack> must be created

  Scenario: Testing TC_6_1_7
    Given URL-page for inventory page
    When When I create new object with <Post terminal>
    Then Object with type <POS Term> must be created

  Scenario: Testing TC_6_2_1
    Given URL-page for inventory page
    When When I trying to click button <Edit>
    Then Found object open me an <Edit> page

  Scenario: Testing TC_8_1_1
    Given URL-page for inventory page
    When When I trying to check that object type <City> is inner type < Country>
    Then There is object of type <City> into object type <Country>

  Scenario: Testing TC_9_1_1
    Given URL-page for inventory page
    When When I trying to attributes from parameters of  <Country>
    Then All needed attributes is on their places





















