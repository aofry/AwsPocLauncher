Feature: aws feature

  Scenario: As a user I can click and get data from the web
    Given I press the "ClickMe" button
    Then I see "AverageDailyVolume"

  Scenario: As a user I can click Launch and Launch AUT
      Given I press the "Launch AUT" button
      Then I see "AUT"
