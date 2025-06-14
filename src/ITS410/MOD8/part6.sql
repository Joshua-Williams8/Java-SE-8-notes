/*
Write a SELECT statement that answers this question: 
Which customers have ordered more than one product? 

Return these columns:
The email_address column from the Customers table

The count of distinct products from the customer’s orders

Sort the result set in ascending sequence by the email_address column. Submit a screenshot.
*/

SELECT *
FROM customers;

SELECT *
FROM orders;

SELECT *
FROM order_items;
-- COUNT(DISTINCT(order_items.product_id))
SELECT  customers.email_address, COUNT(DISTINCT(order_items.product_id))
FROM customers
INNER JOIN orders
ON customers.customer_id = orders.customer_id
INNER JOIN order_items
ON order_items.order_id = orders.order_id
GROUP BY customers.customer_id, orders.order_id
ORDER BY email_address ASC;
-- , orders.order_id, order_items.product_id;


