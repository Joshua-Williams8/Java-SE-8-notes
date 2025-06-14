/*
Write a SELECT statement that returns these column names and data from the Products table:
product_name               The product_name column

list_price                 The list_price column

discount_percent           The discount_percent column

discount_amount            A column that’s calculated from the previous two columns

discount_price             A column that’s calculated from the previous three columns

Round the discount_amount and discount_price columns to two decimal places. 
Sort the result set by the discount_price column in descending sequence. 
Use the LIMIT clause so the result set contains only the first five rows. 
Submit a screenshot.
*/

SELECT*
FROM products;
-- discount_amount            A column that’s calculated from the previous two columns

SELECT product_name, list_price, discount_percent
FROM products;

DELIMITER $$
CREATE FUNCTION calc_discount(id INT) 
RETURNS DECIMAL(10,2) DETERMINISTIC
BEGIN
	DECLARE discount_per DECIMAL(10,2);
    DECLARE price DECIMAL(10,2);
		 SELECT list_price, discount_percent INTO price, discount_per FROM products where product_id = id;
	return (discount_per/100.00) * price;
END$$

-- discount_price             A column that’s calculated from the previous three columns

DELIMITER $$
CREATE FUNCTION price_after_discount(id INT) 
RETURNS DECIMAL(10,2) DETERMINISTIC
BEGIN
	DECLARE price DECIMAL(10,2);
    DECLARE discount DECIMAL(10,2);
		 SELECT list_price, calc_discount(id) INTO price, discount FROM products where product_id = id;
	return price - discount;
END$$
-- Sort the result set by the discount_price column in descending sequence. 
-- Use the LIMIT clause so the result set contains only the first five rows. 
SELECT product_name, list_price, discount_percent, calc_discount(product_id) as discount_amount, price_after_discount(product_id) as discount_price
FROM products
ORDER BY discount_price DESC
LIMIT 5;