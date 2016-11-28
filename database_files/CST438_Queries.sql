#lists total product sales by month and year
select p.productName as 'Product', SUM(s.qtySold) as 'QTY Sold', MONTH(s.dateSold) as 'Month', YEAR(s.dateSold) as 'Year'
from employee as e, products as p, sales as s
where p.productId = s.productId
group by year(s.dateSold), s.productId, month(s.dateSold);

#list total employee sales by month and year
select e.lastName as 'Name', SUM(s.qtySold) as 'QTY Sold', MONTH(s.dateSold) as 'Month', YEAR(s.dateSold) as 'Year'
from employee as e, products as p, sales as s
where e.empId = s.empId and p.productId = s.productId
group by year(s.dateSold), e.lastName, month(s.dateSold);

#list total employee sales by year
select e.lastName as 'Name', SUM(s.qtySold) as 'QTY Sold', YEAR(s.dateSold) as 'Year'
from employee as e, products as p, sales as s
where e.empId = s.empId and p.productId = s.productId
group by year(s.dateSold), e.lastName;

#list total product sales by year
select p.productName as 'Product', SUM(s.qtySold) as 'QTY Sold', YEAR(s.dateSold) as 'Year'
from employee as e, products as p, sales as s
where p.productId = s.productId
group by year(s.dateSold), s.productId;

#list total product revenue by month and yeat
select p.productName as 'Product', concat('$', format((SUM(s.qtySold)* p.productPrice),2)) as 'Total Revenue', MONTH(s.dateSold) as 'Month', YEAR(s.dateSold) as 'Year'
from employee as e, products as p, sales as s
where p.productId = s.productId
group by year(s.dateSold), s.productId, month(s.dateSold);

#list total employee revenue by month and year
select e.lastName as 'Name', concat('$', format((SUM(s.qtySold)* p.productPrice),2)) as 'Total Revenue', MONTH(s.dateSold) as 'Month', YEAR(s.dateSold) as 'Year'
from employee as e, products as p, sales as s
where e.empId = s.empId and p.productId = s.productId
group by year(s.dateSold), e.lastName, month(s.dateSold);

#list total employee revenue by year
select e.lastName as 'Name', concat('$', format((SUM(s.qtySold)* p.productPrice),2)) as 'Total Revenue', YEAR(s.dateSold) as 'Year'
from employee as e, products as p, sales as s
where e.empId = s.empId and p.productId = s.productId
group by year(s.dateSold), e.lastName;

#list total product revenue by year
select p.productName as 'Product', concat('$', format((SUM(s.qtySold)* p.productPrice),2)) as 'Total Revenue', YEAR(s.dateSold) as 'Year'
from employee as e, products as p, sales as s
where p.productId = s.productId
group by year(s.dateSold), s.productId;






