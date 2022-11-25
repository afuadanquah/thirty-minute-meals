Feature: Private Endpoints Feature

  Scenario: Client calls private-status endpoint and receives 200 OK
    When Client makes a request to "/private/status" endpoint
    Then Client receives a body of "OK"
    And Client receives a status code of 200