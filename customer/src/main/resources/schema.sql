DROP TABLE IF EXISTS CUSTOMER;
  
CREATE TABLE CUSTOMER (
  id INT AUTO_INCREMENT  PRIMARY KEY,
   email VARCHAR(250) NOT NULL,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL
 );
 
 
