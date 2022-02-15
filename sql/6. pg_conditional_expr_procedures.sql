/* 
	CONDITIONAL EXPRESSIONS and PROCEDURES.
	Course: The Complete SQL Bootcamp 2022: Go from Zero to Hero.
    Data: Import 'resources/dvdrental.tar' into Postgres.
*/

-- CASE can be used in a general way or in form of expression.
-- CASE is IF-ELSE of SQL in a single line.
select * from customer;
select customer_id from customer;

-- CASE (general)
select customer_id,
case
	when (customer_id <= 100) then 'Premium'
	when (customer_id between 100 and 200) then 'Plus'
	else 'Normal'
end as customer_class
from customer;

-- CASE (expression)
select customer_id,
case customer_id
	when 2 then 'Winner'
	when 5 then 'Second Place'
	else 'Normal'
end as raffle_results
from customer;

-- Multiple CASEs (expression)
select * from film;
select rental_rate from film;
select sum (
	case rental_rate
   	when 0.99 then 1
    else 0 
	end
) as bargins,
sum (
	case rental_rate
   	when 2.99 then 1
    else 0 
	end
) as regular,
sum (
	case rental_rate
   	when 4.99 then 1
    else 0 
	end
) as premium
from film;

-- COALESCE accepts unlimited number of arguments and returns the first argument which is not null.
-- If all arguments are null then COALESCE returns null.
-- Usage: useful when you query a table that contains null values and replace it with another value.
-- Tip: Place null values first and then default values.
-- Example: select item, (price - coalesce(discount, 0)) as final from table [if discount cell is null replace with 0]

select coalesce(1, 2); -- Returns 1.
select coalesce(null, 2, 3); -- Returns 2.

-- CAST converts one datatype into other. Conversion should be reasonable. 
-- 5.0 -> 5 (works); "Five" -> 5 (no);

select cast('5' as integer); -- CAST() is CAST function.
select '5'::integer; -- :: is CAST operator.

-- As `inventory_id` is `integer`, length won't work. Convert to `varchar` first and then use `char_length`. 
select char_length(inventory_id) from rental; -- Won't work.
select char_length(cast(inventory_id as varchar)) from rental;

-- NULLIF takes two inputs and returns `null` if both are equal otherwise it returns the first argument passed.
-- Read NULLIF as ReturnNullIfBothAreEqual.
select nullif(10, 10);
select nullif(10, 12);

-- VIEW is a database object of a stored query. View does not store data, it itself is a query.
-- Store a complex query as if it was a table.
create or replace view customer_info as
select first_name, last_name, address, district
from customer 
inner join address 
on customer.address_id = address.address_id;

select * from customer_info; -- SELECT on view.
alter view customer_info rename to cust_info; -- RENAME view.
select * from cust_info; -- SELECT on renamed view.
drop view if exists customer_info; -- DROP view.
