create database BT1_Store;
use BT1_Store;
create table demo1(
id  int not null primary key auto_increment,
productCode  varchar(250), 
productName varchar(250),
productPrice varchar(250),
productAmount varchar(250),
productDescription varchar(250),
productStatus varchar(250)
);

select * from demo1;

insert into demo1(productCode,productName,productPrice,productAmount ,productDescription,productStatus) value
('SP01','Ten1','4000','3000','Hang Nhat Ban','moi'),
('SP02','Ten2','34000','19000','Hang Trung Quoc','cu'),
('SP03','Ten3','56000','25000','Hang Viet Nam','moi');

create view  productView as
 select  productCode,productName, productPrice,productStatus from demo1;
  
  -- cập nhật view 
  alter view productView as
 select productDescription from demo1;
 
 -- xóa view 
 drop view productView;
 
 
-- tạo store procudere 
-- lấy tất cả các thông tin 
DELIMITER $$
create procedure viewSanPham()
begin
 select * from demo1;
 end; $$
DELIMITER ;
call viewSanPham();

--  thêm sản phẩm mới
DELIMITER $$
create procedure insertSanPham()
begin 
 insert into demo1(productCode,productName,productPrice,productAmount ,productDescription,productStatus) value
('SP04','Ten4','6000','8000','Hang Da Nang','cu');
end; $$
 DELIMITER ;
 call insertSanPham();
 
 
 -- sửa đổi thông tin sản phẩm theo ID
DELIMITER $$
create procedure  suadoi3SanPham(in idn int)
begin 
	update demo1
  set productName ='Ten4'
  where  id = idn;
end; $$
 DELIMITER ;
call  suadoi3SanPham(4);

select * from demo1;

-- Xóa sản phẩm theo idDELIMITER $$
DELIMITER $$
create procedure  deleteSanPham(in idn int)
begin 
	DELETE FROM demo1
   WHERE id = idn;
end; $$
DELIMITER ;
call  deleteSanPham(5);
select * from demo1;

-- thủ tục uppdate được còn view thì ko update được 
 
 
 