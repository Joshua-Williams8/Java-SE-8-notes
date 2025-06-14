/*
Write an INSERT statement that adds this row to the Products table:

product_id: 		The next automatically generated ID
category_id:    	4
product_code:		dgx_640
product_name:		Yamaha DGX 640 88-Key Digital Piano
description:		Long description to come.
list_price:			799.99
discount_percent:	0
date_added:			Today’s date/time.

Use a column list for this statement. 
Execute the query and take a screenshot of the query and the results
*/

SELECT product_id, category_id,  product_code, product_name, description, 
list_price, discount_percent, date_added
FROM products
ORDER BY product_id;

INSERT INTO products (category_id,  product_code, product_name, description, 
list_price, discount_percent, date_added)
VALUES (4, "dgx_640", "Yamaha DGX 640 88-Key Digital Piano",
"Long description to come.", 799.99, 0, NOW());

-- for fixing the insert
DELETE FROM products
WHERE product_id = 11;

