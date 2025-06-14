/*
Write a SELECT statement that joins the 
Customers, Orders, Order_Items, and Products tables. 
This statement should return these columns: 
last_name, first_name, order_date, product_name, item_price, discount_amount, and quantity.
Use aliases for the tables.

Sort the final result set by the 
last_name, order_date, and product_name columns. 
Execute the query and take a screenshot of the query and the results.
*/


SELECT * 
FROM customers;
SELECT *
FROM orders;
SELECT *
FROM order_items;
SELECT *
FROM products;


SELECT customers.first_name, customers.last_name, 
addresses.line1, addresses.city, addresses.state, addresses.zip_code
FROM customers
INNER JOIN orders ON customers.shipping_address_id = addresses.address_id;

SELECT c.last_name, c.first_name, o.order_date, p.product_name, oi.item_price, oi.discount_amount, oi.quantity
FROM customers c
    INNER JOIN orders o ON c.customer_id = o.customer_id
    INNER JOIN order_items oi ON o.order_id  = oi.order_id
	INNER JOIN products p ON oi.product_id  = p.product_id 
ORDER BY c.last_name, o.order_date, p.product_name;