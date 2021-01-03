CREATE TABLE rent (
    id INTEGER PRIMARY KEY,
    dock_id INTEGER NOT NULL,
    bike_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    create_at TIMESTAMP WITHOUT TIME ZONE,
    status INTEGER
);

CREATE SEQUENCE hibernate_sequence START 1;
CREATE SEQUENCE my_seq_gen START 1;