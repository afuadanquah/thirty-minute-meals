CREATE
    KEYSPACE meals
    WITH REPLICATION = {
        'class' : 'SimpleStrategy',
        'replication_factor' : 1
        };

CREATE TYPE meals.ingredients (
    name text,
    quantity int
    );

CREATE TABLE IF NOT EXISTS meals.recipe (

    id text PRIMARY KEY,
    name text,
    ingredients list<Ingredients>,
    serves int,
    duration int,
    instructions text
);
