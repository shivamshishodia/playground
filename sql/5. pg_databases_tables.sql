/* 
	CREATE DATABASES AND TABLES.
	Course: The Complete SQL Bootcamp 2022: Go from Zero to Hero.
*/

/*
	Datatypes (https://www.postgresql.org/docs/13/datatype.html)
	Boolean		: true/false
	Character	: char, varchar, text
	Numeric		: integer, float
	Temporal	: date, time, timestamp, interval
	UUID (Universally unique identifier)
	Array
	JSON
	Hstore key-value pair
	Special types such as network addresses and geometric data.
*/

/*
	CONSTRAINTS are the rules enforced on data columns on table. They are used
	to prevent invalid data from being entered into the database.
	Constraints are of two types: Column and Table constraints.
	Column constraints	: NOT NULL, UNIQUE, PRIMARY KEY, FOREIGN KEY, CHECK, DEFAULT, INDEX, EXCLUSION.
	Table constraints	: CHECK, REFERENCES, UNIQUE, PRIMARY KEY. 	
*/

-- CREATE TABLE.
create table account(
	user_id serial primary key, -- Column constraints.
	username varchar(50) unique not null, -- Column constraints.
	password varchar(50) not null, -- Column constraints.
	email varchar(250) unique not null, -- Column constraints.
	created_on timestamp not null, -- Column constraints.
	last_login timestamp -- Column constraints.
	-- Place table constraints here.
);

-- CREATE TABLE.
create table job(
	job_id serial primary key,
	job_name varchar(200) unique not null
);

-- CREATE TABLE.
create table account_job (
	user_id integer references account(user_id), -- Table constraints.
	job_id integer references job(job_id), -- Table constraints.
	hire_date timestamp
);

-- INSERT VALUES.
insert into account(username, password, email, created_on)
values('Jose', 'password', 'jose@mail.com', current_timestamp);

-- INSERT VALUES.
insert into job(job_name) values ('Astronaut');
insert into job(job_name) values ('President');

-- INSERT VALUES.
insert into account_job(user_id, job_id, hire_date) values (1, 1, current_timestamp);
insert into account_job(user_id, job_id, hire_date) values (10, 10, current_timestamp); -- Won't work due constraints.

/* 
	UPDATE can be used in two ways. One is a basic SET.
	Other is Update Join (use another table to set values).
	Ex: UPDATE tableA SET original_col = tableB.new_col FROM tableB WHERE tableA.id = tableB.id;4
	We can also return affected rows. UPDATE account SET last_login = created_on RETURNING account_id, last_login
*/
update account set last_login = current_timestamp; -- Value.
update account set last_login = created_on; -- Other column.
update account_job set hire_date = account.created_on 
from account where account_job.user_id = account.user_id; -- Other table value.
update account set last_login = current_timestamp returning email, last_login, created_on; -- Return updated rows.

-- DELETE. Just like UPDATE, we can delete based on values from other tables.
select * from job;
insert into job(job_name) values('Cowboy');
delete from job where job_name = 'Cowboy' returning job_id, job_name; -- Return deleted values.

/*
	ALTER can be used to change multiple table components.
	1. ADD, DROP, RENAME.
	2. CHANGE column datatype.
	3. Set DEFAULT.
	4. Add CHECK constraints.
	5. RENAME table.
*/

create table information(
	info_id serial primary key,
	title varchar(500) not null,
	person varchar(50) not null unique
);

select * from information;
alter table information rename to new_info; -- Rename table.
select * from new_info;
alter table new_info rename column person to people; -- Rename column.
select * from new_info;
insert into new_info(title) values ('some new title'); -- Errors out (violates not-null constraint).
alter table new_info alter column people drop not null;
-- alter table new_info alter column people set not null; -- You can use SET as well.
insert into new_info(title) values ('some new title'); -- Works now.

-- DROP. You can drop columns, tables, and constraints.
-- However, you cannot drop columns in views, triggers, or stored procedures without CASCADE.
select * from new_info;
alter table new_info drop column people;
select * from new_info;
alter table new_info drop column if exists people;

-- CHECK allows to create custom constraints with certian condition.
create table employees (
	emp_id serial primary key,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	birthdate date check (birthdate > '1990-01-01'),
	hire_date date check (hire_date > birthdate),
	salary integer check (salary > 0)
);

-- Violates check constraint "employees_birthdate_check". 
-- NOTE: This will increment SERIAL, even if CHECK fails.
insert into employees(first_name, last_name, birthdate, hire_date, salary)
values ('Jose', 'Portilla', '1899-11-03', '2010-01-01', 100); 

insert into employees(first_name, last_name, birthdate, hire_date, salary)
values ('Jose', 'Portilla', '1990-11-03', '2010-01-01', 100);

-- Note that emp_id (PK) gets incremented to 3 and not 2.
select * from employees;
