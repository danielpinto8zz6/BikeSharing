CREATE TABLE dock (
id INTEGER PRIMARY KEY,
latitude DECIMAL ,
longitude DECIMAL ,
location VARCHAR(255) ,
bikeId INTEGER 
);

CREATE SEQUENCE hibernate_sequence START 1;
CREATE SEQUENCE my_seq_gen START 1;