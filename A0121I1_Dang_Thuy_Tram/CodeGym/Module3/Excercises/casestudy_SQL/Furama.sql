-- Data from SQL 
-- Include: Create & Insert Table

create database furama;
use furama;
--   drop database furama;
create table CustomerType(
CustomerTypeId int not null primary key,
CustomerTypeName varchar(50) not null);

select * from Customer;
-- insert into Customer(CustomerName, CustomerBir, Gender, CusIdNum, CusTelNum, CusEmail, Address, CustomerTypeId) values ('Nguyen Thanh Binh','20/8/1999','nu',12345678,902538765,'binhnguyen@gmail.com','Quang Nam','Go') ;
create table Customer(
CustomerId int not null auto_increment primary key,
CustomerTypeId int not null,
foreign key (CustomerTypeId) references CustomerType(CustomerTypeId),
Customer_Name varchar(50) not null,
Customer_Birthday  date  not null,
Customer_Id_Number int not null,
Customer_Phone int not null,
Customer_Email varchar(50) not null,
Customer_Address varchar(50) not null);

-- bang vi tri
create table Location(
LoactionId int not null primary key,
LocationName varchar(50) not null);

create table Education(
EducationId int not null primary key,
Education_Name varchar(50) not null);

create table Department(
DepartmentId int not null primary key,
Department_Name varchar(50) not null);

create table Employee(
EmployeeId int not null auto_increment primary key,
Employee_Name varchar(50) not null,
Employee_Birthday date not null,
Employee_Id_Number varchar(15) not null,
Employee_Phone varchar(50) not null,
Employee_Email varchar(50) not null,
Employee_Salary double not null,
LoactionId int not null,
EducationId int not null,
DepartmentId int not null,
foreign key (LoactionId) references Location(LoactionId),
foreign key (EducationId) references Education(EducationId),
foreign key (DepartmentId) references Department(DepartmentId));

create table Rent_Type(
Rent_TypeId int not null primary key,
Rent_TypeName varchar(50) not null, 
Rent_Type_Price double);

create table Service_Type(
	Service_Type_Id int not null primary key,
    Service_Type_Name varchar(50) not null 
);

create table Service(
ServiceId int not null primary key,
ServiceName varchar(50) not null,
UseArea double not null,
Number_Floors int not null,
Max_People int not null,
Service_Cost int not null,
Rent_TypeId int not null,
foreign key (Rent_TypeId) references Rent_Type(Rent_TypeId),
Service_Type_Id int not null,
foreign key (Service_Type_Id) references Service_Type(Service_Type_Id),
Service_Status varchar(50) not null
);
select * from Service;

create table Villa(
VillaId int not null primary key,
VillaName varchar(50) not null,
VillaStandard varchar(50) not null,
VillaDescribe varchar(50) not null,
PoolArea int not null,
FloorNum int not null,
ServiceId int not null,
foreign key (ServiceId) references Service(ServiceId));

create table House(
HouseId int not null primary key,
HouseName varchar(50) not null,
HouseStandard varchar(50) not null,
HouseDescribe varchar(50) not null,
FloorNum int not null,
ServiceId int not null,
foreign key (ServiceId) references Service(ServiceId));

create table Room(
RoomId int not null primary key,
RoomName varchar(50) not null,
FreeServiceName varchar(50) not null,
ServiceId int not null,
foreign key (ServiceId) references Service(ServiceId));

create table Service_Plus(
Service_Plus_Id int not null primary key,
Service_Plus_Name varchar(50) not null,
Unit varchar(50) not null,
Price int not null);

create table Contract(
ContractId int not null primary key,
BeginDay date not null,
FinishDay date not null, 
Deposit int not null,
TotalPayment int not null,
EmployeeId int not null,
CustomerId int not null,
ServiceId int not null,
foreign key (EmployeeId) references Employee(EmployeeId),
foreign key (CustomerId) references Customer(CustomerId),
foreign key (ServiceId) references Service(ServiceId));

create table DetailContract(
DetailContractId int not null primary key,
Service_Plus_Id int not null,
Quantity int not null,
ContractId int not null,
foreign key (Service_Plus_Id) references Service_Plus(Service_Plus_Id),
foreign key (ContractId) references Contract(ContractId));

-- 1 Thêm mới thông tin
insert into CustomerType (CustomerTypeId, CustomerTypeName) value
(100, 'Diamond'),
(101, 'Platinium'),
(102, 'Gold'),
(103, 'Silver'),
(104, 'Member');
select * from CustomerType;

insert into Customer(Customer_Name, Customer_Birthday, Customer_Id_Number, Customer_Phone, Customer_Email, Customer_Address, CustomerTypeId) value ('Nguyen Thanh Binh','1999/8/31',12345678,902538765,'binhnguyen@gmail.com','Quang Nam',103) ;

---
insert into Customer(Customer_Name, Customer_Birthday, Customer_Id_Number, Customer_Phone, Customer_Email, Customer_Address, CustomerTypeId) values
(('Phan Cong', '1988/12/14', 292830999, 348997878,'danh88@gmail.com','Nghe An',102),
('Phan Ngoc', '1995/06/23', 201679257, 978192837,'quynhpn@gmail.com','Quang Nam',104));

insert into Location(LoactionId, LocationName) value
(110, 'Trung cap'),
(111, 'Cap dang'),
(112, 'Dai hoc'),
(113, 'Sau Dai học');

insert into Education(EducationId, Education_Name) value
(001, 'Le tan'),
(002, 'Phuc vu'),
(003, 'Chuyen vien'),
(004, 'Giam sat'),
(005, 'Quan ly'),
(006, 'Giam doc');

--
insert into Department(DepartmentId, Department_Name) value
(201, 'Sales Marketing'),
(202, 'Hanh chinh'),
(203, 'Phuc vu'),
(204, 'Quan ly');

use furama;
insert into Employee(Employee_Name, Employee_Birthday, Employee_Id_Number, Employee_Phone, Employee_Email, Employee_Salary, LoactionId, EducationId, DepartmentId) value
 ('Hoang Van Tung', '1989/09/22', 205678392, 978982937, 'tunghv@gmail.com', 1000, 111, 2, 202),
 ('Tran Thanh Thuy', '1992/11/20', 201890082, 935790289, 'thuytt@gmail.com', 500, 112, 6, 201),
 ('Nguyen Tuan Tu', '1995/03/12', 201829087, 998958567, 'tuntv@gmail.com', 800, 110, 3, 204),
 ('Phan Thanh Hoang', '1987/08/27', 206729003, 987989892, 'hoangpt@gmail.com', 1000,113, 2, 202);
-- 
insert into Rent_Type(Rent_TypeId, Rent_TypeName, Rent_Type_Price) value
(310,'Nam',100000000),
(312,'Thang',45000000),
(313,'Ngay',5000000),
(311,'Gio',45000000);

insert into Service(ServiceId, ServiceName, UseArea, Number_Floors, Max_People, Service_Cost, Rent_TypeId, Service_Type_Id, Service_Status) value
(140, 'Villa', 20, 1,12, 2000000, 310,120,  'DA'),
(141, 'House', 16, 12, 3, 500000, 311,121, 'HO'),
(142, 'Room', 12, 23,20, 4000000, 312, 122,'MO'),
(143, 'Villa', 20, 45,70, 1000000,310, 120,  'HO'),
(144, 'House', 16, 11,150, 1000000,313,123,  'DA'),
(145, 'Room', 12, 30, 250, 40000000, 311,122, 'YE');

insert into Villa(VillaId, VillaName, VillaStandard, VillaDescribe, PoolArea, FloorNum, ServiceId) value
(440, 'Villa1', 'Tieu chuan', 'Co ho boi', 9, 2, 140),
(441, 'Villa2', 'Vip', 'Co ho boi, co giat ui', 9 , 4, 142);

insert into House(HouseId, HouseName, HouseStandard, HouseDescribe, FloorNum, ServiceId) value
(450, 'House1', 'Tieu chuan', 'Co an sang', 1, 141),
(451, 'House2', 'Vip', 'Co an sang, co giat ui', 3, 144);

insert into Room(RoomId, RoomName, FreeServiceName, ServiceId) value
(460, 'Room1', 'Nuoc loc', 142),
(461, 'Room2', 'Bia', 145);

insert into Service_Plus(Service_Plus_Id, Service_Plus_Name, Unit, Price) value
(880, 'Massage', 'Gio', '100000'),
(881, 'Thuc an', 'Mon', '70000'),
(882, 'Xe', 'Gio', '120000');

insert into Contract(ContractId, BeginDay, FinishDay, Deposit, TotalPayment, EmployeeId, CustomerId, ServiceId) value
(940, '2021/04/23', '2021/4/25', 2000000, 4000000, 13, 3, 140),
(941, '2021/04/20', '2021/4/24', 2000000, 4000000, 16, 4, 141);

insert into DetailContract(DetailContractId, Service_Plus_Id, Quantity, ContractId) value
(333, 880, 2, 940),
(334, 882, 1, 941);