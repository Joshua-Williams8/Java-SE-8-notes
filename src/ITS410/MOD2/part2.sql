/* 2. Write a SELECT statement that returns one column from 
 the Customers table named full_name that 
 joins the last_name and first_name columns.*/
 
#Grabs all columns
SELECT * FROM customers;
#Grabs only the first and last names
SELECT first_name, last_name FROM customers;
#Puts those name into one column using CONCAT
SELECT CONCAT(last_name, ", ", first_name) AS full_name FROM Customers;
#Order by last_name column in ascending order
SELECT CONCAT(last_name, ", ", first_name) AS full_name FROM Customers ORDER BY last_name ASC;
/* Return only the customers whose last names begin with letters from M to Z. 
Execute the query and take a screenshot of the query and the results.*/ 
SELECT CONCAT(last_name, ", ", first_name) AS full_name FROM Customers
 WHERE last_name BETWEEN "m" AND "z"
 ORDER BY last_name ASC;