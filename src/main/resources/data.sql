CREATE TABLE PRICE (
  brand_id INT NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  price_list INT NOT NULL,
  product_id INT NOT NULL,
  priority INT NOT NULL,
  price DOUBLE NOT NULL,
  curr varchar(3) NOT NULL,
  PRIMARY KEY (product_id, price_list)
);


INSERT INTO PRICE (
  brand_id,
  start_date,
  end_date,
  price_list,
  product_id,
  priority,
  price,
  curr
)
VALUES (
  1, 
  PARSEDATETIME('14-06-2020-00.00.00','dd-MM-yyyy-HH.mm.ss'),
  PARSEDATETIME('31-12-2020-23.59.59','dd-MM-yyyy-HH.mm.ss'),
  1,
  35455,
  0,
  35.50,
  'EUR'
),
(
  1,
  PARSEDATETIME('14-06-2020-15.00.00','dd-MM-yyyy-HH.mm.ss'),
  PARSEDATETIME('14-06-2020-18.30.00','dd-MM-yyyy-HH.mm.ss'),
  2,
  35455,
  1,
  25.45,
  'EUR'
),
 (
   1,
   PARSEDATETIME('15-06-2020-00.00.00','dd-MM-yyyy-HH.mm.ss'),
   PARSEDATETIME('15-06-2020-11.00.00','dd-MM-yyyy-HH.mm.ss'),
   3,
   35455,
   1,
   30.50,
   'EUR'
),
(
  1,
  PARSEDATETIME('15-06-2020-16.00.00','dd-MM-yyyy-HH.mm.ss'),
  PARSEDATETIME('15-06-2020-23.59.59','dd-MM-yyyy-HH.mm.ss'),
  4,
  35455,
  1,
  38.95,
  'EUR'
 )

