Feature: Recipe Endpoints Feature

  Scenario: Client calls all the recipes endpoint and receives 200 OK
    When Client makes a "GET" request to "all-recipes-api" endpoint
    And Client receives a status code of 200

    #Client call the recipes and gets all the recipes from the database
  Scenario: Client calls all the recipes endpoint
    When Client makes a "GET" request to "all-recipes-api" endpoint
#    Then Client checks that there are 5 recipes are available
    And Client receives a status code of 200

    #Post a recipe into the database
  Scenario: Client adds a single recipe
  When Client makes a "POST" request to "add-recipe" endpoint
  Then Client checks that the recipe is available
  And Client receives a status code of 201

  #PUT - Updates a recipe that is available
  #TODO - Only updates if there it can find the id. If it cannot find the id, it does not post
  Scenario Outline: Client updates a recipe in the database
    When Client makes a "PUT" request to "update-recipe" endpoint with the "<id>"
#    Then Client checks that the recipe is available
    And Client receives a status code of 200
    Examples:
      | id     |
      | 8      |

  #Delete a recipe into the database
  Scenario Outline: Client deletes a single recipe in the database
    When Client makes a "DELETE" request to "delete-recipe" endpoint with the "<id>"
    #Then Client checks that the recipe is available
    And Client receives a status code of 204
    Examples:
    | id     |
    | 8      |


