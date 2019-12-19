DROP TABLE IF EXISTS CUSTOMER_SOS;
DROP TABLE IF EXISTS SALES_ORDER;
DROP TABLE IF EXISTS ORDER_LINE_ITEM;

CREATE TABLE CUSTOMER_SOS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
   email VARCHAR(250) NOT NULL,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL
 );
 
 
CREATE TABLE SALES_ORDER (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  order_date DATE NOT NULL,
  cust_id INT NOT NULL,
  order_desc VARCHAR(100) NOT NULL,
  total_price DECIMAL(20,2) NOT NULL
 );
 
 
 CREATE TABLE ORDER_LINE_ITEM (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  item_name VARCHAR(250) NOT NULL,
  item_quantity INT NOT NULL,
  order_id INT NOT NULL,
  CONSTRAINT `items_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `SALES_ORDER` (`id`)
 );