/*

Write a SELECT statement that returns one row for each category that has products with these columns:

The category_name column from the Categories table

The count of the products in the Products table

The list price of the most expensive product in the Products table.

Sort the result set so the category with the most products appears first. 
Execute the query, and take a screenshot of the query and the results.
*/

SELECT DISTINCT category_id
FROM products;
-- Used this query to check my work to make sure I am getting the right product prices, and counts
SELECT *
FROM products
ORDER BY category_id, list_price;

SELECT  categories.category_name, COUNT(products.category_id) as amount_of, 
MAX(products.list_price) as highest_value
FROM categories
INNER JOIN products
ON products.category_id = categories.category_id
GROUP BY categories.category_id, categories.category_name
ORDER BY amount_of DESC;