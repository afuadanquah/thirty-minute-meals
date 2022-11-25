Feature: Private Endpoints Feature

  Scenario: Client calls all the recipes endpoint and receives 200 OK
    When Client makes a request to "/recipe/all" endpoint
#    Then Client receives a body of "OK"
    And Client receives a status code of 200

  Scenario: Client calls all the receipes endpoint and receives 200 OK
    When Client makes a request to "/recipe/all" endpoint
    Then Client checks that there are 3 recipes are available
    And Client receives a status code of 200

  Scenario: Client calls all the receipes endpoint and receives 200 OK
    When Client makes a request to "/recipe/all" endpoint
    Then Client adds another recipe
    And Client recipe checks that there are 11 recipes are available
    And Client receives a status code of 200

  Scenario: Client calls all the receipes endpoint and receives 200 OK
    When Client makes a request to "/recipe/all" endpoint
    Then Client deletes the fifth recipe
    And Client recipe checks that there are 10 recipes are available
    And Client receives a status code of 204

  Scenario: Client calls all the receipes endpoint and receives 200 OK
    When Client makes a request to "/recipe/" endpoint with an {id} endpoint
    Then Client a checks that recipe of type: breakfast
    And Client recipe checks that there are 11 recipes are available