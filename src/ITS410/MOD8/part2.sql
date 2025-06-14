/*

Write a SELECT statement that returns these column names and data from the Order_Items table:
item_id                           The item_id column

item_price                      The item_price column

discount_amount            The discount_amount column

quantity      The quantity column

price_total        A column that’s calculated by multiplying the item price by the quantity

discount_total        A column that’s calculated by multiplying the discount amount by the quantity

item_total      A column that’s calculated by subtracting the discount amount from the item price 
and then multiplying by the quantity

Only return rows where the item_total is greater than 500. 
Sort the result set by the item_total column in descending sequence. 
Submit a screenshot.
*/

SELECT *
FROM order_items;

SELECT item_id, item_price, discount_amount, quantity
FROM order_items;

/*

price_total        
A column that’s calculated by multiplying the item price by the quantity
*/

DELIMITER $$
CREATE FUNCTION price_total(id INT) 
RETURNS DECIMAL(10,2) DETERMINISTIC
BEGIN
	DECLARE price DECIMAL(10,2);
    DECLARE quan INT;
		 SELECT item_price, quantity INTO price, quan FROM order_items where item_id = id;
	return price * quan;
END$$

SELECT item_id, item_price, discount_amount, quantity, price_total(item_id) as price_total
FROM order_items;

/*

discount_total        
A column that’s calculated by multiplying the discount amount by the quantity

*/

DELIMITER $$
CREATE FUNCTION discount_total(id INT) 
RETURNS DECIMAL(10,2) DETERMINISTIC
BEGIN
	DECLARE discount DECIMAL(10,2);
    DECLARE quan INT;
		 SELECT discount_amount, quantity INTO discount, quan FROM order_items where item_id = id;
	return discount * quan;
END$$

SELECT item_id, item_price, discount_amount, quantity, 
price_total(item_id) as price_total, discount_total(item_id) as discount_total
FROM order_items;


/*

item_total      
A column that’s calculated by subtracting the discount amount from the item price 
and then multiplying by the quantityv

*/


DELIMITER $$
CREATE FUNCTION item_total(id INT) 
RETURNS DECIMAL(10,2) DETERMINISTIC
BEGIN
	DECLARE price DECIMAL(10,2);
    DECLARE discount INT;
		 SELECT price_total(id), discount_total(id) INTO price, discount FROM order_items where item_id = id;
	return price - discount;
END$$

SELECT item_id, item_price, discount_amount, quantity, 
price_total(item_id) as price_total, discount_total(item_id) as discount_total,
item_total(item_id) as item_total
FROM order_items;

/*
Only return rows where the item_total is greater than 500. 
Sort the result set by the item_total column in descending sequence. 
Submit a screenshot.
*/

SELECT item_id, item_price, discount_amount, quantity, 
price_total(item_id) as price_total, discount_total(item_id) as discount_total,
item_total(item_id) as item_total
FROM order_items
WHERE item_total(item_id) > 500.00
ORDER BY item_total DESC;
