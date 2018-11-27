Feature: Bankwallet

Scenario: Create Bank Account 

    Given User Enters all his details in homepage
    Then  Validate all the details
    Then  Send the valid details to the createaccount page
    Then Successfully added
    