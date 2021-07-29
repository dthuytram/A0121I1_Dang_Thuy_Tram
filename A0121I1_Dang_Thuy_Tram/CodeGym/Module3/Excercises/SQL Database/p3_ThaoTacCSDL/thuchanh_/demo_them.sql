SELECT * FROM classicmodels.orders;
select status 
from orders
group by status;
select status ,count(status) as 'số lương'
from orders
group by status;
/*
thuc hien tinh tong so tien cua cac doen hàng theo trạng thái đặt hàng
*/

select status, sum(quantityOrdered*priceEach) as 'amount'
from orders
inner join orderdetails on orders.ordernumber = orderdetails.ordernumber
group by status;

#tinh tong tien cua tung don hang 

select orderNumber, sum(quantityOrdered*priceEach) as 'tong'
from orderdetails
group by orderNumber;


/*
su dung having ket hop với group 
nên nhớ having sẽ chạy sau group group thử thi được mới tới having
*/
select year(orderDate) as year, sum(quantityOrdered*priceEach) as sum
from orders
inner join orderdetails on orders.orderNumber=orderdetails.orderNumber
where status='shipped'
group by year
having year >2003

