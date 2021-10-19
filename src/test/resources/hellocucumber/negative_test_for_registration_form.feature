Feature: Main negative scenario for registration form
  These scenarios are testing all field of form with not correct values

  Scenario: Testing TC_3_1_1
    Given URL-page for negative testing
    When I am testing checking <?> of <Username> field
    Then Checking <?> of <Username> shows me a notification

  Scenario: Testing TC_3_1_2
    Given URL-page for negative testing
    When I am testing <Username> field for alphanumeric characters
    Then Page near <Username> shows me a notification if the value is incorrect

  Scenario: Testing TC_3_2_1
    Given URL-page for negative testing
    When I am testing checking <?> of <Password> field
    Then Checking <?> of <Password> shows me a notification

  Scenario: Testing TC_3_2_2
    Given URL-page for negative testing
    When I am testing <Password> field length
    Then Page near <Password> field shows me a notification if the value is incorrect

  Scenario: Testing TC_3_2_3
    Given URL-page for negative testing
    When I am testing <Password> field for correction value of password
    Then Page near <Password> field shows me a notification about incorrect symbols

  Scenario: Testing TC_3_3_1
    Given URL-page for negative testing
    When I am testing checking <?> of <Repeat Password'> field
    Then Checking <?> of <Repeat Password> shows me a notification

  Scenario: Testing TC_3_3_2
    Given URL-page for negative testing
    When I am testing coincidence <Password> field with <Repeat Password>
    Then Page near <Repeat Password> field shows me a notification about incorrect symbols

  Scenario: Testing TC_3_4_1
    Given URL-page for negative testing
    When I am testing checking <?> of <Email> field
    Then Checking <?> of <Email> shows me a notification

  Scenario: Testing TC_3_4_2
    Given URL-page for negative testing
    When I am testing <Email> field for correction value of email
    Then Page near <Email> field shows me a notification about incorrect symbols

  Scenario: Testing TC_3_5_1
    Given URL-page for negative testing
    When I am testing checking <?> of <Role> field
    Then Checking <?> of <Role> shows me a notification

  Scenario: Testing TC_3_5_2
    Given URL-page for negative testing
    When I am testing <Role> field with value <Admin>
    Then The registration with value <Admin> has completed successfully

  Scenario: Testing TC_3_5_3
    Given URL-page for negative testing
    When I am testing <Role> field with value <Read Only>
    Then The registration with value <Read Only> has completed successfully

  Scenario: Testing TC_3_5_4
    Given URL-page for negative testing
    When I am testing <Role> field with value <Read_Write>
    Then The registration with value <Read_Write> has completed successfully














