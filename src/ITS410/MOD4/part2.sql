/*
Write a DELETE statement that deletes the row you added to the Categories table in exercise 1. 
This statement should use the category_id column to identify the row. 
Execute the query and take a screenshot of the query and the results.
*/

SELECT * 
FROM categories
ORDER BY category_id;

DELETE FROM categories
WHERE category_id = 5;

