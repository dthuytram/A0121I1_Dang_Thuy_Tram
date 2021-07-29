CREATE DATABASE bang;

USE bang;

-- Tao bang
CREATE TABLE contacts
( contact_id INT(11) NOT NULL AUTO_INCREMENT,
  last_name VARCHAR(30) NOT NULL,
  first_name VARCHAR(25),
  birthday DATE,
  CONSTRAINT contacts_pk PRIMARY KEY (contact_id)
);
-- DEFAULT -> gan gia tri mac dinh cho cot
CREATE TABLE suppliers
( supplier_id INT(11) NOT NULL AUTO_INCREMENT,
  supplier_name VARCHAR(50) NOT NULL,
  account_rep VARCHAR(30) NOT NULL DEFAULT 'TBD',
  CONSTRAINT suppliers_pk PRIMARY KEY (supplier_id)
);
-- Xoa bang
DROP TABLE suppliers;
--  ALTER TABLE -> chinh sua bang dang ton tai
ALTER TABLE contacts
ADD adress varchar(40) NOT NULL
AFTER contact_id;
-- Them nhieu cot mot luc
ALTER TABLE contacts
ADD phone_number varchar(40) NOT NULL
AFTER contact_id,
ADD email varchar(35) NULL
AFTER phone_number;
-- Sua mo ta cua mot cot
ALTER TABLE contacts
MODIFY last_name varchar(50) NULL;
-- Doi ten cot
ALTER TABLE contacts
CHANGE COLUMN adress address
varchar(20) NOT NULL;
-- Doi ten bang
ALTER TABLE contacts
RENAME TO people;