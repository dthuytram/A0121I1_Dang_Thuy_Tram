create database class1;

use class1;

create table Orders(
orderNumber int(11) primary key not null,
oriderDate date not null,
requiredDate date not null,
shippedDate date ,
status varchar(15) not null,
conments text 
);
create table  OrderDetails (
orderNumvber int(11) not null ,
productCode varchar(15) not null,
quantityOrdered int(11) not null,
priceEach decimal(10,2) not null,
orderLineNumber smallint(6) not null,
primary key(orderNumvber, productCode),
foreign key(productCode) references Products(productCode)
);
create table customers(
customerNumber int(11) primary key,
customerName varchar(50) not null,
contactLastName varchar(50) not null,
contactFirstName varchar(50) not null,
phone varchar(50) not null,
addressLine1 varchar(50) not null,
addressLine2 varchar(50) ,
city varchar(50) not null,
state varchar(50) ,
postalCode varchar(15) ,
country varchar(50) not null,
selesRepEmployeeNumber int(11),
creditLimit decimal(10,2),
foreign key(selesRepEmployeeNumber) references Employees(employeeNumber)
); 
create table  Payments(
customerNumber int(11) not null,
checkNumber varchar(50) not null,
paymentDate date not null,
amount decimal(10,2) not null,
primary key(customerNumber,checkNumber)
);
create table Products (
productCode varchar(15) not null,
productName varchar(70) not null,
productLine varchar(50) not null,
productScale varchar(10) not null,
productVendor varchar(50) not null,
productDescription text not null,
quantitylnStock smallint(6) not null,
buyPrice decimal(10,2) not null,
MSRP decimal(10,2) not null,
primary key(productCode),
foreign key(productLine) references productLines(producLine)
);
create table   productLines(
producLine varchar(50) not null,
textDescription varchar(4000) ,
htmlDescription mediumtext,
image mediumblob,
primary key(producLine)
);
create table   Offices(
officeCode  varchar(10) primary key not null,
city varchar(50) not null,
phone varchar(50) not null,
addressLine1 varchar(50) not null,
addressLine2 varchar(50) ,
state varchar(50) ,
country varchar(50) not null,
postalCode varchar(15) not null,	
territory varchar(10) not null	
);
create table  Employees(
employeeNumber int primary key not null,
lastName varchar(50) not null,
firstName varchar(50) not null,
extension varchar(10) not null,
email varchar(100)  not null,
officdeCode varchar(10) not null,
reportsTo int(11),
foreign key(reportsTo) references Employees(employeeNumber),
jobTitle  varchar(50) not null,
foreign key( jobTitle) references  Offices(officeCode)
);