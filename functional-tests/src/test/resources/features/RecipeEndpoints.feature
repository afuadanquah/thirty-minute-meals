Feature: Recipe Endpoints Feature

  Scenario: Client calls all the recipes endpoint and receives 200 OK
    When Client makes a request to "/thirty-min-meals/recipes" endpoint
    And Client receives a status code of 200

  Scenario: Client calls all the recipes endpoint and receives 200 OK
    When Client makes a request to "/thirty-min-meals/recipes" endpoint
    Then Client checks that there are 5 recipes are available
    And Client receives a status code of 200

#  Scenario: Client calls all the receipes endpoint and receives 200 OK
#    When Client makes a request to "/recipe/all" endpoint
#    Then Client adds another recipe
#    And Client recipe checks that there are 11 recipes are available
#    And Client receives a status code of 200
#
#  Scenario: Client calls all the receipes endpoint and receives 200 OK
#    When Client makes a request to "/recipe/all" endpoint
#    Then Client deletes the fifth recipe
#    And Client recipe checks that there are 10 recipes are available
#    And Client receives a status code of 204
#
#  Scenario: Client calls all the receipes endpoint and receives 200 OK
#    When Client makes a request to "/recipe/" endpoint with an {id} endpoint
#    Then Client a checks that recipe of type: breakfast
#    And Client recipe checks that there are 11 recipes are available