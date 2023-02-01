CREATE KEYSPACE IF NOT EXISTS meals
    WITH REPLICATION = {
        'class' : 'SimpleStrategy',
        'replication_factor' : 1
        };

CREATE TYPE IF NOT EXISTS meals.ingredients (
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
