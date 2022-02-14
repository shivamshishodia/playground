/* 
	ADVANCE SQL.
	Course: The Complete SQL Bootcamp 2022: Go from Zero to Hero.
	Data: Import 'resources/dvdrental.tar' into Postgres.
*/

/*
	TIME		: contains only time.
	DATE		: contains only date.
	TIMESTAMP	: contains date and time.
	TIMESTAMPZ	: contains date, time and timezone.
*/
show all; -- 300 different parameters visible.
show timezone; -- Asia/Calcutta
select now(); -- 2022-02-14 11:03:37.304808+05:30
select timeofday(); -- Mon Feb 14 11:03:30.166529 2022 IST
select current_time; -- 11:03:14.544765+05:30
select current_date; -- 2022-02-14

-- EXTRACT allows you to obtain sub-components of date value (YEAR, MONTH, DAY, WEEK, QUARTER).
select * from payment;
select extract(year from payment_date) as pay_year from payment;
select extract(month from payment_date) as pay_mon from payment;
select extract(quarter from payment_date) as pay_qtr from payment;

-- AGE returns the current age given the timestamp.
select age(payment_date) from payment; -- 14 years 11 mons 26 days 01:34:13.003423

-- TO_CHAR converts data types to text. It is generic.
-- Resources: https://www.postgresql.org/docs/13/functions-formatting.html#FUNCTIONS-FORMATTING-DATETIME-TABLE
select to_char(payment_date, 'MONTH-YYYY') from payment; -- FEBRUARY -2007
select to_char(payment_date, 'MONTH YYYY') from payment; -- FEBRUARY  2007
select to_char(payment_date, 'mon/dd/YYYY') from payment; -- feb/15/2007
select to_char(payment_date, 'MM-dd-YYYY') from payment; -- 02-15-2007

-- Mathematical Functions: https://www.postgresql.org/docs/9.5/functions-math.html
select round(rental_rate/replacement_cost, 2) * 100 as percent_cost from film;

-- String Functions: https://www.postgresql.org/docs/9.1/functions-string.html
select * from customer;
select length(first_name) from customer;
select first_name  || ' ' ||  last_name as full_name from customer;
select upper(first_name)  || ' ' ||  upper(last_name) as full_name from customer;
select first_name || last_name || '@gmail.com' from customer;
select lower(left(first_name, 2)) || lower(last_name) || '@gmail.com' as custom_email from customer;

/*
	Sub-query allows to perform a query on the results of another query.
	The syntax is often straightforward and involves two SELECTs. Basically,
	results obtained from one query are used in another query. Sub-query runs first.
	EXISTS and IN are often used in sub-query.
*/
select title, rental_rate from film
where rental_rate > 
(select avg(rental_rate) from film); -- AVG is calculated first and then used in WHERE.

select film_id, title from film
where film_id in (
	select inventory.film_id from rental
	inner join inventory on inventory.inventory_id = rental.inventory_id
	where return_date between '2005-05-29' and '2005-05-30'
) order by film_id; -- 3 tables are required. film_id is fetched first using join.

select first_name, last_name from customer as c
where exists (
	select * from payment as p
	where p.customer_id = c.customer_id -- Ensures customer made a payment.
	and amount  > 11
); -- Select customers who made payment more than $11. 

/*
	Self-join is a query in which a table is joined to itself. Useful when you 
	want to `compare columns of rows` within the same table. Aliases are required.
	It is basically an inner join on the same table.
*/
select f1.title, f2.title, f1.length 
from film as f1 
inner join film as f2 on 
f1.film_id != f2.film_id 
and f1.length = f2.length; -- We are matching films of same length on the same table.
