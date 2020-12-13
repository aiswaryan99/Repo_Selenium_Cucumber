Feature: Ways to Pay Feature

  Scenario: Verify heading 'Pay directly from your favorite apps' is displayed
    Given I am on facebook landing page
    When I click on 'Facebook Pay'
    Then I click on 'Oculus'
    Then I close Facebook Landing Page
    And I close Oculus page
    When I click on 'Ways to Pay'
    Then I verify heading 'Pay Directly from you favorite apps' appears