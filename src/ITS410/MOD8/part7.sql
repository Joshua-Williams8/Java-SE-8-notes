/*

Write a SELECT statement that answers this question: 
What is the total quantity purchased for each product within each category? 
Return these columns:

The category_name column from the category table

The product_name column from the products table

The total quantity purchased for each product with orders in the Order_Items table

Use the WITH ROLLUP operator to include rows that give a summary for each category name as well as a row that gives the grand total.

Use the IF and GROUPING functions to replace null values in the category_name and product_name columns with literal values if they’re for summary rows. Submit a screenshot.

*/

SELECT *
FROM products;

SELECT *
FROM orders;

SELECT *
FROM order_items;
