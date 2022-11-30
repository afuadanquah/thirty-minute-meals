CREATE
    KEYSPACE meals
    WITH REPLICATION = {
        'class' : 'SimpleStrategy',
        'replication_factor' : 1
        };

CREATE TYPE meals.ingredients (
    name text,
    quantity text
    );

CREATE TABLE IF NOT EXISTS meals.recipe (

    id text PRIMARY KEY,
    name text,
    ingredients frozen<list<Ingredients>>,
    serving int,
    duration text,
    instructions text
);
