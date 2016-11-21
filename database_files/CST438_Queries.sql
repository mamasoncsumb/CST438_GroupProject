#lists total product sales by month and year
select p.product_name as 'Product', SUM(s.qty_sold) as 'QTY Sold', MONTH(s.date_sold) as 'Month', YEAR(s.date_sold) as 'Year'
from employee as e, products as p, sales as s
where p.product_id = s.product_id
group by year(s.date_sold), s.product_id, month(s.date_sold);

#list total employee sales by month and year
select e.last_name as 'Name', SUM(s.qty_sold) as 'QTY Sold', MONTH(s.date_sold) as 'Month', YEAR(s.date_sold) as 'Year'
from employee as e, products as p, sales as s
where e.emp_id = s.emp_id and p.product_id = s.product_id
group by year(s.date_sold), e.last_name, month(s.date_sold);

#list total employee sales by year
select e.last_name as 'Name', SUM(s.qty_sold) as 'QTY Sold', YEAR(s.date_sold) as 'Year'
from employee as e, products as p, sales as s
where e.emp_id = s.emp_id and p.product_id = s.product_id
group by year(s.date_sold), e.last_name;

#list total product sales by year
select p.product_name as 'Product', SUM(s.qty_sold) as 'QTY Sold', YEAR(s.date_sold) as 'Year'
from employee as e, products as p, sales as s
where p.product_id = s.product_id
group by year(s.date_sold), s.product_id;

#list total product revenue by month and yeat
select p.product_name as 'Product', concat('$', format((SUM(s.qty_sold)* p.product_price),2)) as 'Total Revenue', MONTH(s.date_sold) as 'Month', YEAR(s.date_sold) as 'Year'
from employee as e, products as p, sales as s
where p.product_id = s.product_id
group by year(s.date_sold), s.product_id, month(s.date_sold);

#list total employee revenue by month and year
select e.last_name as 'Name', concat('$', format((SUM(s.qty_sold)* p.product_price),2)) as 'Total Revenue', MONTH(s.date_sold) as 'Month', YEAR(s.date_sold) as 'Year'
from employee as e, products as p, sales as s
where e.emp_id = s.emp_id and p.product_id = s.product_id
group by year(s.date_sold), e.last_name, month(s.date_sold);

#list total employee revenue by year
select e.last_name as 'Name', concat('$', format((SUM(s.qty_sold)* p.product_price),2)) as 'Total Revenue', YEAR(s.date_sold) as 'Year'
from employee as e, products as p, sales as s
where e.emp_id = s.emp_id and p.product_id = s.product_id
group by year(s.date_sold), e.last_name;

#list total product revenue by year
select p.product_name as 'Product', concat('$', format((SUM(s.qty_sold)* p.product_price),2)) as 'Total Revenue', YEAR(s.date_sold) as 'Year'
from employee as e, products as p, sales as s
where p.product_id = s.product_id
group by year(s.date_sold), s.product_id;






