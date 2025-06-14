/*
1. Write a script that creates and calls a stored procedure named insert_category.

2. First, code a statement that creates a procedure that adds a new row to the Categories table. 
To do that, this procedure should have one parameter for the category name.

3. Code at least two CALL statements that test this procedure. 
(Note that this table doesn’t allow duplicate category names.) 
Execute the query and take a screenshot of the query and the results.
*/
SELECT *
FROM categories;

DELIMITER //
CREATE PROCEDURE insert_category( 
IN cat_name VARCHAR(255))
BEGIN

	INSERT INTO categories (category_name)
	VALUES (cat_name);

END //

CALL insert_category('Pianos');
CALL insert_category('Flutes');

SELECT *
FROM categories
ORDER BY category_id;

 