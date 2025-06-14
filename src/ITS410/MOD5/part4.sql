/*

Write a SELECT statement that returns one row for each customer that has orders with these columns:

The email_address column from the Customers table

A count of the number of orders

The total amount for each order 
(Hint: First, subtract the discount amount from the price. Then, multiply by the quantity.)

Return only those rows where the customer has more than one order. 

Sort the result set in descending sequence by the sum of the line item amounts. 
Execute the query and take a screenshot of the query and the results.
*/
-- commented out bits are parts that are not needed for final screenshot

SELECT customers.email_address, 
-- order_items.quantity,
COUNT(orders.order_id * order_items.quantity) * order_items.quantity number_of_orders, 
-- SUM(discount_amount * quantity) as discount_sum,
-- SUM((item_price) * quantity) as item_price_total, 
-- SUM(orders.ship_amount + orders.tax_amount) as shipping_cost,
SUM((item_price - discount_amount ) * quantity) as item_price_total_with_discounts,
SUM((item_price - discount_amount ) * quantity) + SUM(orders.ship_amount + orders.tax_amount) as total_amount_with_tax_shipping 
FROM customers
INNER JOIN orders
ON orders.customer_id = customers.customer_id
INNER JOIN order_items
ON order_items.order_id = orders.order_id
GROUP BY customers.email_address, order_items.quantity
HAVING number_of_orders > 1
ORDER BY total_amount_with_tax_shipping DESC;
