@call_local
Feature: IMS Issues API - Local Env
  Scenario: Issues API Listing
    Given issues api is up and running
    When a request to the Issue listing is made
    Then a list of issues should be returned with 404 status code

