Feature: Recipe Endpoints Feature

  Scenario: Client calls all the recipes endpoint and receives 200 OK
    When Client makes a request to "/thirty-min-meals/recipes" endpoint
    And Client receives a status code of 200

    #Client call the recipes and gets all the recipes from the database
  Scenario: Client calls all the recipes endpoint
    #Add as endpoint as a Map
    When Client makes a request to "/thirty-min-meals/recipes" endpoint
    Then Client checks that there are 4 recipes are available
    And Client receives a status code of 200


