CREATE TABLE payment (
id INTEGER PRIMARY KEY,
rental_id INTEGER ,
value DOUBLE ,
is_paid BOOLEAN ,
method INTEGER ,
timestamp TIMESTAMP WITHOUT TIME ZONE ,
user_id INTEGER 
);

CREATE TABLE invoice (
id INTEGER PRIMARY KEY,
payment_id INTEGER ,
name VARCHAR(255) ,
tax_number INTEGER ,
company VARCHAR(255) ,
timestamp TIMESTAMP WITHOUT TIME ZONE
);
