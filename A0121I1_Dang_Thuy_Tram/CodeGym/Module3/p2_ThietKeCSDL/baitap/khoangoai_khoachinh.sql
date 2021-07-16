create database class1;

use class1;

create table Customers(
customer_number int primary key auto_increment,
fullname nvarchar(100) not null,
address nvarchar(255),
email nvarchar(50) not null,
phone nvarchar(10)
);
insert into Customers(fullname,address,email,phone) 
values('Dang Thuy Tram','Da Nang','tram1234@gmail.com','0935472840'),
('Nguyen Thi Thanh Thuy','Thanh Hoa','thhuy3333@gmail.com','0925472840'),
('ha Ngoc Tuan Anh','Ha Tinh','anh1234@gmail.com','0915472346'),
('Hanh Phuc La Day','Da Nang','tram1212@gmail.com','0925374041');

create table Account_Type(
account_pype_number int primary key auto_increment,
account_type_name nvarchar(50)
);
insert into Account_Type(account_type_name) 
values ('vip'),
('thường'),
('doanh nghiệp');

create table Accounts(
account_number int primary key auto_increment,
account_type int,
date date,
balance float,
customer_number int,
foreign key (account_type) references Account_Type(account_pype_number),
foreign key (customer_number) references Customers(customer_number)
);
insert into Accounts(account_type,date,balance,customer_number)
values(1,'2015/07/15',123340000,1),
(2,'2015/08/12',33400001,2),
(3,'2016/07/15',12300000,4);

create table Descriptions(
description_number int primary key auto_increment,
detal nvarchar(255)
);
insert into Descriptions(detal)
values('tang 20% khi thanh toan qua the tai cac cua hang lien ket'),
('lai xuat 0.3% hang thang');


create table Transactions(
tran_number int primary key auto_increment,
account_number int,
date date,
amounts float,
description_number int,
foreign key (account_number) references Accounts(account_number),
foreign key (description_number) references Descriptions(description_number)
);
insert into Transactions(account_number,date,amounts,description_number)
values(1,'2015/07/19',123200000,1),
(2,'2015/12/01',33000001,2),
(2,'2016/012/30',1130000,3);