CREATE TABLE medics (
    id serial PRIMARY KEY NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    cellphone VARCHAR(20) NOT NULL,
    crm VARCHAR(6) NOT NULL UNIQUE,
    specialty VARCHAR(100) NOT NULL,
    street VARCHAR(100) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    cep VARCHAR(8) NOT NULL,
    complement VARCHAR(100),
    number VARCHAR(100),
    uf CHAR(2) NOT NULL,
    city VARCHAR(100) NOT NULL,
    active BOOLEAN NOT NULL
)