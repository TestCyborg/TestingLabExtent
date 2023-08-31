Feature: Services
  Framework to cover a service provided by Dial Testing Lab
  Scenario: Submitting a service on the front-end
    Given User is on the Testing Lab landing page
    When User clicks Services
    Then The services offered are displayed
    When User selects a service
    Then Mobile Testing is displayed
    When User ticks Appium [Framework set up and training]
    And User scrolls down
    Then Additional information is displayed
    When User populates the Additional_information, Name, Contact_number, Email and Company
      |I am interested in the learning material.|
      |Justice|
      |0663716158|
      |mothobi.january@dialtestinglab.co.za|
      |Testing Lab|
    And User clicks Submit button
    Then The Thank You message is displayed