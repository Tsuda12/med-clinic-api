CREATE TABLE users (
    id serial PRIMARY KEY NOT NULL,
    login VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
)