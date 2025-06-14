/*

Write a SELECT statement that returns one row for each customer that has orders with these columns:
The email_address column from the Customers table

The sum of the item price in the Order_Items table multiplied by the quantity in the Order_Items table

The sum of the discount amount column in the Order_Items table multiplied by the quantity in the Order_Items table

Sort the result set in descending sequence by the item price total for each customer. 

Execute the query and take a screenshot of the query and the results.

*/
SELECT customers.email_address,  
SUM(item_price * quantity) as item_price_total, 
SUM(discount_amount * quantity) as discount_sum
FROM customers
INNER JOIN orders
ON orders.customer_id = customers.customer_id
INNER JOIN order_items
ON order_items.order_id = orders.order_id
GROUP BY customers.email_address
ORDER BY item_price_total DESC;

SELECT *
FROM customers;

SELECT *
FROM order_items;

SELECT *
FROM orders
ORDER BY customer_id;

SELECT SUM(item_price * quantity) as item_price_sum, SUM(discount_amount * quantity) as discount_sum
FROM order_items;

