Feature:  Login OrangeHRM
  
  
  #Author: Plabani

 Scenario: Verify Login Functionality
    Given Open Browser
    When Enter Username "admin" and password "admin123"
    And Click Login
    Then Login Successful
    
    


  Scenario Outline: Test
    Given Open Browser
    When Enter Username "<username>" and password "<password>"
    And Click Login
    Then Login Successful

   Examples: 
      | username         | password         |
      | login.username   | login.password   |
      | invalid.username | valid.password   |
      | valid.username   | invalid.password |
