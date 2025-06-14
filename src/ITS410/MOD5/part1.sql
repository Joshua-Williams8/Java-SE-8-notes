/*

Write a SELECT statement that returns these columns:

The count of the number of orders in the Orders table

The sum of the tax_amount columns in the Orders table

Execute the query and take a screenshot of the query and the results.

*/

SELECT COUNT(*) as total_orders, SUM(tax_amount) as tax_sum
FROM orders;
