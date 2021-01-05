CREATE TABLE users (
    id INTEGER PRIMARY KEY,
    username VARCHAR(255),
    name VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255)
);

CREATE SEQUENCE hibernate_sequence START 1;
CREATE SEQUENCE my_seq_gen START 1;