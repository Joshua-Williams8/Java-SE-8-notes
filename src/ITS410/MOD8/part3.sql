/*
Write a SELECT statement that returns the product_name and list_price columns from the Products table.
Return one row for each product that has the same list price as another product.

Hint: Use a self-join to check that the product_id columns aren’t equal but the list_price columns are equal.

Sort the result set by the product_name column. Submit a screenshot.
*/

SELECT *
FROM products;

SELECT p1.product_name , list_price
FROM products as p1, products as p2;
-- p2.product_name AS product_name2,

SELECT p1.product_name AS product_name,
p1.list_price AS list_price
FROM products p1
JOIN products p2 ON p1.list_price = p2.list_price;

SELECT *
FROM products;

SELECT p1.product_id, 
p1.product_name AS product_name,
p1.list_price AS list_price
FROM products as p1
JOIN products as p2 ON p1.list_price = p2.list_price 
AND p1.product_id != p2.product_id
GROUP BY p1.product_id
ORDER BY p1.product_name;