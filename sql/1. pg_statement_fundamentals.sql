/* 
	SELECT Statement.
	Course: The Complete SQL Bootcamp 2022: Go from Zero to Hero.
	Data: Import 'resources/dvdrental.tar' into Postgres.
*/

-- Use * wisely as it increases resource consumption.
select * from actor;
select first_name, last_name from actor;

-- DISTINCT operates on a column. Use of parentheses is recommended.
-- A table column table may have duplicate values. DISTINCT helps to
-- filter out unique values from the column.
select * from film;
select distinct(release_year) from film; -- Returns 2006.
select distinct(rental_rate) from film; -- Returns three values (2.99, 4.99, 0.99).
select distinct release_year, rental_rate from film; -- Returns three pairs (2006 * (2.99, 4.99, 0.99)).

-- COUNT on entire table or on a table column returns same result when it is a simple query.
select * from payment;
select count(*) from payment; -- Returns 14596.
select count(payment_date) from payment; -- Returns 14596.
select count(amount) from payment; -- Returns 14596.
select count(distinct amount) from payment; -- Returns distinct amount which exist.

-- WHERE specifies condition on columns for the rows to be returned.
-- Logical operators used AND, OR, and NOT.
select * from customer;
select * from customer where first_name = 'Jared';
select * from film;
select * from film where rental_rate > 4 and replacement_cost >= 19.99 and rating = 'R';
select title from film where rental_rate > 4 and replacement_cost >= 19.99 and rating = 'R';
select count(title) from film where rental_rate > 4 and replacement_cost >= 19.99 and rating = 'R';
select count(title) from film where rating = 'R' or rating = 'PG-13';

-- ORDER BY helps to sort the results in ASC (default) or DESC. Must be done at the end of query.
-- It can be used on multiple columns. This makes sense when one column has duplicate entries.
select store_id, first_name, last_name from customer order by store_id DESC, first_name ASC;

-- LIMIT is the last command that is executed.
select * from payment order by payment_date DESC LIMIT 5; -- Most recent 5 payments.
select * from payment where amount <> 0.00 order by payment_date DESC LIMIT 5; -- Most recent 5 payments not equal to 0.00.

-- BETWEEN is same as (value >= low) and (value <= high).
-- NOT BETWEEN is same as (value < low) or (value > high).
select * from payment where amount between 8 and 9;
select count(*) from payment where amount between 8 and 9;
select count(*) from payment where amount not between 8 and 9;
select * from payment where payment_date between '2007-02-01' and '2007-02-15';

-- IN is used in-place of multiple WHEREs (AND + OR).
-- It can be used with NOT.
select * from payment limit 2;
select * from payment where amount in (0.99, 1.98, 1.99);
select count(*) from payment where amount in (0.99, 1.98, 1.99);
select count(*) from payment where amount not in (0.99, 1.98, 1.99);
select * from customer where first_name in ('John', 'Jake', 'Julie');
select * from customer where first_name not in ('John', 'Jake', 'Julie');

-- LIKE/ILIKE is used for pattern matching. It supports regex.
-- Percent % : Match any sequence of characters.
-- Underscore _ : Match any single character.
-- LIKE is case-sensitive and ILIKE is case-insensitive.
select * from customer where first_name like 'J%'; -- Name starts with letter J.
select count(*) from customer where first_name like 'J%';
select count(*) from customer where first_name like 'j%';
select count(*) from customer where first_name ilike 'j%';
select * from customer where first_name like '%er%';
select * from customer where first_name not like '%er%';
