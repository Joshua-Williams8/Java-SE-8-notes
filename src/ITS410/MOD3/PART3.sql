/*
Write a SELECT statement that joins the Customers table to the
Addresses table and returns these columns: 
first_name, last_name, line1, city, state, zip_code.
Return one row for each customer, but only return addresses 
that are the shipping address for a customer. 
Execute the query and take a screenshot of the query and the results.
*/

SELECT *
FROM addresses;
SELECT * 
FROM customers;

SELECT customers.first_name, customers.last_name, 
addresses.line1, addresses.city, addresses.state, addresses.zip_code
FROM customers
INNER JOIN addresses ON customers.shipping_address_id = addresses.address_id;