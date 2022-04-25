
@regression
Feature: As a data consumer, I want UI and DB book information are match.

  @US5
  Scenario: Verify book information with DB
    Given Establish the database connection
    When I navigate to "Books" page
    And I open book "Chordeiles minor"
    Then book information must match the Database