DROP TABLE IF EXISTS ITEM;
  
CREATE TABLE ITEM (
  id INT AUTO_INCREMENT  PRIMARY KEY,
   name VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  price DECIMAL(20,2) NOT NULL
 );
 
 