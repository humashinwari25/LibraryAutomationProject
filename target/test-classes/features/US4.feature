
@regression
Feature: As a librarian, I want to know who is the most popular user

  @US4 @wip
  Scenario: verify who is the most popular user who reads the most
    Given Establish the database connection
    When I execute a query to find the most popular user
    Then verify student is the user who reads the most