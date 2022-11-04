CREATE
    KEYSPACE meals
    WITH REPLICATION = {
        'class' : 'SimpleStrategy',
        'replication_factor' : 1
        };


CREATE TABLE IF NOT EXISITS meals.recipe (

    id text PRIMARY KEY,
    name text,
    ingredients text,
    serves int,
    duration int,
    instructions text
);


