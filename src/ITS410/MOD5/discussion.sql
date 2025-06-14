SELECT *
FROM orders;

SELECT *
FROM customers;

SELECT *
FROM order_items;

SELECT orders.customer_id, customers.last_name, customers.first_name, COUNT(*) as amount_of_orders
FROM orders
JOIN customers ON customers.customer_id = orders.customer_id
GROUP BY customer_id
HAVING amount_of_orders > 1
LIMIT 10;



SELECT orders.customer_id, customers.last_name, customers.first_name, COUNT(*) as amount_of_orders
FROM orders
JOIN customers ON customers.customer_id = orders.customer_id
WHERE COUNT(*) > 1
LIMIT 10;