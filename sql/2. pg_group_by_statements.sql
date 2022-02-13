/* 
	Course: The Complete SQL Bootcamp 2022: Go from Zero to Hero.
	Data: Import 'resources/dvdrental.tar' into Postgres.
*/

/*
	Aggregate function takes multiple inputs and provides single output.
	Example: AVG(), COUNT(), MAX(), MIN(), SUM().
	Aggregate function calls happen only in SELECT or HAVING.
*/

select * from film;
select min(replacement_cost) from film;
select max(replacement_cost) from film;
select max(replacement_cost), title from film; -- Won't work, use GROUP BY.
select min(replacement_cost), max(replacement_cost) from film; -- Fn can be used together.
select avg(replacement_cost) from film;
select round(avg(replacement_cost), 2) from film;
select sum(replacement_cost) from film;

/* 
	GROUP BY allows us to aggregate columns per some category.
	We need categorical column to apply GROUP BY. GROUP BY must 
	appear right after FROM or WHERE. You can filter out rows 
	using WHERE before applying GROUP BY. In SELECT statement,
	columns must either have an aggregate function or be in the 
	GROUP BY call. WHERE should not refer aggragate function (use HAVING).
	ex: select company, division, sum(sales) from finance_table group by company, division order by sum(sales)
	ex: select company, division, sum(sales) from finance_table where division in ('transport', 'marketing') group by company, division
	[REFER NOTES]
*/
select * from payment;
select customer_id, sum(amount) from payment group by customer_id order by sum(amount) desc;
select customer_id, count(amount) from payment group by customer_id order by count(amount) desc;
-- The order in which columns are mentioned in GROUP BY matters.
select customer_id, staff_id, sum(amount) from payment group by staff_id, customer_id order by customer_id;

-- HAVING allows us to filter after an aggregation (GROUP BY) has already taken place. 
-- WHERE allows us to filter before the aggregation (GROUP BY) takes place.
select customer_id, sum(amount) from payment group by customer_id having sum(amount) > 100;
select store_id, count(customer_id) from customer group by store_id having count(customer_id) > 300;
