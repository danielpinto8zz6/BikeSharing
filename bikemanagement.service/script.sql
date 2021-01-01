CREATE TABLE bike (
id INTEGER PRIMARY KEY,
charge_level INTEGER ,
service_hours DECIMAL,
serial_number VARCHAR(255) ,
brand VARCHAR(255) ,
model VARCHAR(255) 
);

CREATE SEQUENCE hibernate_sequence START 1;
CREATE SEQUENCE my_seq_gen START 1;