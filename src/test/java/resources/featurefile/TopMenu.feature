Feature: Top menu test

  As a user i want to check top menu tabs on tutorial ninja websites homepage

  Background: I am on homepage of tutorial ninja website
    Given I am on homepage
@sanity @regression
  Scenario: User should navigate to desktop page successfully
    When I mouse hover and click on desktop tab
    And I select menu "Show All Desktops"
    Then I should navigate to desktop page successfully
@smoke @regression
  Scenario: User should navigate to laptop and notebook page successfully
    When I mouse hover and click on laptop and notebook tab
    And I select menu "Show All Laptops & Notebooks"
    Then I should navigate to laptop and notebook page successfully
@regression
  Scenario: User should navigate to component page successfully
    When I mouse hover and click on component tab
    And I select menu "Show All Components"
    Then I should navigate to component page successfully