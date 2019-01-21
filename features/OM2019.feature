Feature: Testing the OM web portal as a Admin

  Scenario: Logging in as a system Admin on OMConnect portal

    Given The System Admin has navigated to the OM web portal
    When The System Admin must enter a valid email address
    And The System Admin must enter a valid password
    When The System Admin should have their name appear accordingly in a message]