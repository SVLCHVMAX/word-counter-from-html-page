DROP TABLE IF EXISTS word;

CREATE TABLE word
(id serial,
word varchar(50),
count int,
url varchar(500),
PRIMARY KEY (id));