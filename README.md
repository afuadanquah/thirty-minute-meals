#Thirty Minute Meals

###Specification - Create A Recipe API which showcases the CRUD endpoints.

This application showcases nutritious and wholesome meals that are 30 minutes or less - it is for the busy person, multifaceted family or simply the individual who hates cooking. 

Project board can be found [here](https://github.com/afuadanquah/thirty-minute-meals/projects?query=is%3Aopen).

Ensure you have the following tools downloaded:

* [Docker](https://docs.docker.com/get-docker/) - To spin up the Cassandra (Database) remotely.
* [Java JDK](https://www.oracle.com/uk/java/technologies/downloads/) - To run the application.
* [Postman](https://www.postman.com/downloads/) - Serves a Client UI (Optional)
* [IntelliJ](https://www.jetbrains.com/idea/download/#section=mac) - IDE (Optional)

####Instructions for local installation:

1. Build the application using Gradle. At the root directory of the project, run the command - ./gradlew build or gradle build. **NB:** You may have to comment the functional tests to build the project then uncomment the functional tests.
2. Run Docker-compose.yml file - Found in the recipes-service module. This will spin up the Cassandra Database.
3. Run the spring boot application
4. Test the CRUD endpoints by using Postman or navigate the Recipe Controller. You will find the Recipe endpoints in the Rest Controller. 

####Below you will find data to test the CREATE and PUT endpoints:

####Single recipe:

```
{
    "id": "4",
    "name": "Chicken Kofta Flatbreads",
    "ingredients": [{
            "name": "Minced Chicken",
            "quantity": "250g"
        },
        {
            "name": "Rose Harissa",
            "quantity": "2 tsp"
        },
        {
            "name": "Red Cabbage",
            "quantity": "250g"
        },
        {
            "name": "Wholemeal Tortillas",
            "quantity": "2"
        },
        {
            "name": "Cottage Cheese",
            "quantity": "2"
        }
    ],
    "serving": 2,
    "duration": "15 minutes",
    "instructions": "1. Put a griddle pan on a high heat. 2. Scrunch the minced chicken and harissa in your clean hands until well mixed. 3. Divide into 6 pieces, then shape into koftas with your fingertips, leaving dents in the surface to increase the gnarly bits as they cook. 4. Griddle for 4 to 5 minutes on each side, or until sizzling and golden. 5. Meanwhile, shred the red cabbage as finely as you can. Sprinkle with a pinch of sea salt and black pepper, drizzle with 1 tablespoon of red wine vinegar, then scrunch together to quickly pickle it. 6. Warm your tortillas or flatbreads, sprinkle over the cabbage, spoon over the cottage cheese, add the koftas, drizzle with a little extra harissa, and tuck in."
}
```
####Multiple recipes:

```
[
    {
        "id": "5",
        "name": "Black Tahini Orzo",
        "ingredients": [
            {
                "name": "Orzo",
                "quantity": "150g"
            },
            {
                "name": "Lemons",
                "quantity": "2"
            },
            {
                "name": "Punnet of Cress",
                "quantity": "1"
            },
            {
                "name": "Black Sesame Seeds",
                "quantity": "50g"
            },
            {
                "name": "Teriyaki Sauce",
                "quantity": "2 tbsp"
            }
        ],
        "serving": 2,
        "duration": "13 minutes",
        "instructions": "1. Cook the orzo in boiling salted water according to the packet instructions, then drain, reserving a mugful of cooking water. Meanwhile, finely grate the zest of 1 lime, snip the cress and put both aside. 2. Toast the sesame seeds in a dry non-stick frying pan on a high heat for 1 minute, tossing regularly. Reserving one quarter of the seeds, pound the rest in a pestle and mortar until fairly fine, then muddle in the teriyaki and the juice of 1 lime. Taste, season to perfection with sea salt and black pepper, and you’ve got a black tahini! 3. Toss the orzo and black tahini together, loosening with a splash of reserved noodle water. Serve sprinkled with the lime zest, cress and reserved seeds, with lemons wedges on the side, for squeezing over."
    },
    {
        "id": "6",
        "name": "Smoked salmon and leek hash with horseradish",
        "ingredients": [
            {
                "name": "New Potatoes, halved",
                "quantity": "250g"
            },
            {
                "name": "Oil",
                "quantity": "2 tbsp"
            },
            {
                "name": "Large Leeks, sliced",
                "quantity": "2"
            },
            {
                "name": "Eggs",
                "quantity": "4"
            },
            {
                "name": "Horseradish, creamed",
                "quantity": "2 tbsp"
            }
        ],
        "serving": 2,
        "duration": "30 minutes",
        "instructions": "1. Put the potatoes in a microwaveable bowl with a splash of water, cover, then cook on high for 5 mins until tender (or steam or simmer them). 2. Meanwhile, heat the oil in a frying pan over a medium heat, add the leeks with a pinch of salt and cook for 10 mins, stirring so they don’t stick, until softened. Tip in the potatoes, turn up the heat and fry for a couple of mins to crisp them up a bit. Slice the salmon to strips. 3. Make four indents in the leek mixture in the pan, crack an egg into each, season, then cover the pan and cook for 6-8 mins until the whites have set and the yolks are runny. Serve the horseradish on the side, with the pan in the middle of the table. "
    }
]
```