/* 
	JOINS.
	Course: The Complete SQL Bootcamp 2022: Go from Zero to Hero.
	Data: Import 'resources/dvdrental.tar' into Postgres.
	Resources
	https://blog.codinghorror.com/a-visual-explanation-of-sql-joins/
	https://en.wikipedia.org/wiki/Join_(SQL)
*/

-- AS is used to give an alias to a column. AS operator gets executed at
-- the end of a query and hence cannot be used inside WHERE/HAVING.
select count(*) as num_transactions from payment;
select customer_id, sum(amount) as total_spent from payment group by customer_id having total_spent > 100; -- Wont't work
select customer_id, sum(amount) as total_spent from payment group by customer_id having sum(amount) > 100;

-- INNER JOIN will result with the set of records that `match in both` tables.
-- Switching tables around `inner join` does not affect the results (symmetrical).
select * from payment inner join customer on payment.customer_id = customer.customer_id;
select payment_id, payment.customer_id, first_name from payment inner join customer on payment.customer_id = customer.customer_id;

-- OUTER JOINs allow us to specify how to deal with values only present in one of the tables joined.
-- FULL OUTER, LEFT OUTER, and RIGHT OUTER JOINs.
select * from customer full outer join payment 
on customer.customer_id = payment.customer_id 
where customer.customer_id is null 
or payment.customer_id is null;

-- LEFT OUTER JOIN results in a set of records that are in the left table.
-- If there are no match with the right table, the results are null.
-- LEFT OUTER JOIN is same as LEFT JOIN.
select film.film_id, title, inventory_id, store_id 
from film left outer join inventory
on inventory.film_id = film.film_id 
where inventory.film_id is null; -- We only have film info. but no inventory (only table A).

-- RIGHT OUTER JOIN is same as LEFT OUTER JOIN, it is just that the tables are switched.
-- Use either of the two while writing queries.

-- UNION is used to combine result-sets of two or more SELECT statements.
-- It essentially pastes the records one after the other. Discussed in other sections.
