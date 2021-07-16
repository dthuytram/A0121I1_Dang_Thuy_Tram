use classicmondels;

-- B1: Sử dụng group by

-- **Không dùng group by
-- Sử dụng câu lệnh select status from orders thì sẽ
-- trả về toàn bộ số bản ghi trong bảng đơn hàng, 
-- kể cả những bản ghi có trạng thái trùng nhau
select status from orders;

-- **Dùng group by
select status from orders 
group by status;

-- B2: Sử dụng các hàm tập hợp với mệnh đề group by
-- **Các hàm tập hợp (SUM, MAX, MIN, COUNT, AVG) cho phép tính toán một tập các hàng và trả về một giá trị duy nhất. Mệnh đề group by thường được sử dụng với một hàm tập 
-- để thực hiện việc tính toán và trả về một giá trị cho mỗi nhóm.
select status, count(*) as 'So luong status'
from orders
group by status;

-- B3: Sử dụng group by với hàm tập hợp truy vấn trên hai bảng.

select status, sum(quantityOrdered * priceEach) as amount
from orders 
inner join orderdetails on orders.ordernumber = orderdetails.ordernumber
group by status;

-- B4:  Một yêu cầu khác là tính tổng tiền của từng đơn hàng, thực hiện lệnh truy vấn sau:
select orderNumber, sum(quantityOrdered * priceEach) as total
from orderdetails
group by orderNumber;

-- B5: GROUP BY với mệnh đề HAVING
select year(orderDate) as year, sum(quantityOrdered * priceEach) as total
from orders 
inner join orderdetails on orders.orderNumber = orderdetails.orderNumber
where status = 'shipped'
group by year
having year > 2003;
-- Vậy mệnh đề having thay cho where để hạn chế dữ liệu trả về trong tập kết quả. 
-- Mệnh đề where dùng với các cột của bảng, tuy nhiên không dùng được với các hàm tập hợp. 
-- Mệnh đề having dùng với các hàm tập hợp.