/*
Write a script that creates and calls a stored function named item_total 
that calculates the total amount of an item in the Order_Items table 
(discount price multiplied by quantity). 

To do that, this function should accept one parameter for the item ID,
 
it should use the discount_price function that you created in exercise 2, 

and it should return the value of the total for that item. 
Execute the query and take a screenshot of the query and the results.
*/


EXPLAIN SELECT *
FROM order_items;

DELIMITER $$
CREATE FUNCTION item_total(id INT) 
RETURNS DECIMAL(10,2) DETERMINISTIC
BEGIN
	DECLARE discounted_price DECIMAL(10,2);
    DECLARE quan int;
		 SELECT discount_price(id), quantity INTO discounted_price , quan FROM order_items where item_id = id;
	return discounted_price * quan;
END$$


SELECT item_id, item_price, discount_amount, discount_price(item_id), quantity, item_total(item_id)
FROM order_items;

