/*
Write a SELECT statement that returns these two columns:
category_name        The category_name column from the Categories table

product_id               The product_id column from the Products table

Return one row for each category that has never been used. 
Hint: Use an outer join and only return rows where the product_id column contains a null value. 
Submit a screenshot.
*/
SELECT *
FROM categories;

SELECT *
FROM products;

SELECT categories.category_name, categories.category_id
FROM categories
LEFT JOIN products ON categories.category_id = products.category_id
WHERE products.product_id IS NULL;