create database class;
use class;

create table employees(
id int ,
ten varchar(100),
tuoi int,
khoahoc varchar(200),
soTien int );
use class;
insert into employees(id,ten,tuoi,khoahoc,soTien)
values(1,'Hoang',21,'CNTT',400000),
(2,'Viet',19,'DTVT',320000),
(3,'Thanh',18,'KTDN',400000),
(4,'Nhan',19,'CK',450000),
(5,'Huong',20,'TCNH',500000),
(5,'Huong',20,'TCNH',200000);

#- Viết câu lệnh hiện thị tất cả các dòng có tên là Huong
select *
from employees
where ten='Huong';

#Viết câu lệnh lấy ra tổng số tiền của Huong
select sum(soTien) as tong
from employees
where ten='Huong';

#- Viết câu lệnh lấy ra tên danh sách của tất cả học viên, không trùng lặp
select   DISTINCT ten ,khoahoc
from employees
