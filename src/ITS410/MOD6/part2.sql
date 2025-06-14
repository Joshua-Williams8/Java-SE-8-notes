/*
Write a script that creates and calls a stored function named discount_price 
that calculates the discount price of an item in the Order_Items table 
(discount amount subtracted from item price). 

To do that, this function should accept one parameter for the item ID, 
and it should return the value of the discount price for that item. 

Execute the query and take a screenshot of the query and the results.
*/

SELECT *
FROM order_items
WHERE item_id = 1;


DELIMITER $$
CREATE FUNCTION discount_price(id INT) 
RETURNS DECIMAL(10,2) DETERMINISTIC
BEGIN
	DECLARE price DECIMAL(10,2);
    DECLARE discount DECIMAL(10,2);
		 SELECT item_price, discount_amount INTO price, discount FROM order_items where item_id = id;
	return price - discount;
END$$


SELECT item_id, item_price, discount_amount, discount_price(item_id)
FROM order_items;




