-- Having 2 ways to explain the code :
--  the first way
#   the second way

-- //---------------------------------------------------------------
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
#2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K”
# và có tối đa 15 ký tự.
SELECT *
FROM Employee
WHERE (Employee_Name LIKE 'H%' OR Employee_Name LIKE 'T%' OR Employee_Name LIKE 'K%')
  AND LENGTH(Employee_Name) <= 15;

-- //---------------------------------------------------------------
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
# 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi 
# và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
use furama;
SELECT CustomerId, Customer_Name, 
Customer_Id_Number, Customer_Phone, Customer_Email, Customer_Address,
TIMESTAMPDIFF(YEAR, Customer_Birthday, CURDATE()) AS Customer_Age
FROM customer
WHERE TIMESTAMPDIFF(YEAR, Customer_Birthday, CURDATE()) BETWEEN 18 AND 50
  AND (Customer_Address = 'Da Nang' OR Customer_Address = 'Quang Tri');

-- //---------------------------------------------------------------
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
#4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
# Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
# Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select kh.Customer_Name, count(hd.CustomerId) as Order_Number
from customer as kh inner join contract as hd 
on hd.CustomerId=kh.CustomerId
where hd.CustomerId in(
	select kh.CustomerId
    from customer as kh inner join customertype as lk
    on kh.CustomerTypeId=lk.CustomerTypeId
	where lk.CustomerTypeName='Diamond'
)
group by hd.CustomerId;

-- //---------------------------------------------------------------
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
#5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
# (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
# cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

#tinh gia tien dich vu di kem theo hop dong chi tiet
select sum(dv.Service_Cost + Quantity*Price) as Total,kh.CustomerId, Customer_Name, CustomerTypeName, hd.ContractId, dv.ServiceName, hd.BeginDay, hd.FinishDay, dv.Service_Cost, hdct.Quantity, Price
from service_plus as dvdk 
inner join detailcontract as hdct 
	on dvdk.Service_Plus_Id = hdct.Service_Plus_Id
inner join contract as hd 
	on hdct.ContractId = hd.ContractId
inner join service as dv 
	on hd.ServiceId = dv.ServiceId
right join customer as kh 
	on hd.CustomerId = kh.CustomerId
inner join customertype as lk 
	on kh.CustomerTypeId = lk.CustomerTypeId
group by kh.CustomerId
order by Total desc;

# Cach 2:
select Customer.CustomerId, Customer.Customer_Name, CustomerType.CustomerTypeName, Contract.ContractId, Service.ServiceName, Contract.BeginDay,  Contract.FinishDay, Service.Service_Cost +(DetailContract.Quantity*Service_Plus.Price) as TotalPayment
from Customer
left join Contract
on Customer.CustomerId = Contract.CustomerId
left join Service on Contract.ServiceId = Service.ServiceId
left join DetailContract on Contract.ContractId = DetailContract.ContractId
left join Service_Plus on DetailContract.Service_Plus_Id = Service_Plus.Service_Plus_Id
left join CustomerType on Customer.CustomerTypeId = CustomerType.CustomerTypeId
group by Customer.CustomerId 
order by TotalPayment desc;
-- //---------------------------------------------------------------
-- -- -- -- -- -- -- -- -- -- 6-- -- -- -- -- 
-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của 
-- tất cả các loại Dịch vụ chưa từng 
-- được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
use furama;
(select Service.ServiceId, Service.ServiceName, Contract.ContractId ,Contract.BeginDay, Service.UseArea, Service.Service_Cost, Villa.VillaName as ServiceType_Name
from (Service
 join Contract on Contract.ServiceId = Service.ServiceId )
 join Villa on Villa.ServiceId =  Service.ServiceId
 where Contract.ContractId not in (select Contract.ContractId from Service join Contract on Contract.ServiceId = Service.ServiceId where month(BeginDay) in (1,2,3) AND year(BeginDay) = '2019' ))
union all
--  
(select Service.ServiceId, Service.ServiceName, Contract.ContractId ,Contract.BeginDay, Service.UseArea, Service.Service_Cost, Room.RoomName as ServiceType_Name
from( Service
 join Contract on Contract.ServiceId = Service.ServiceId )
 join Room on Room.ServiceId =  Service.ServiceId
 where Contract.ContractId not in (select Contract.ContractId from Service join Contract on Contract.ServiceId = Service.ServiceId where month(BeginDay) in (1,2,3) AND year(BeginDay) = '2019' ))
 union all
-- 
 (select Service.ServiceId, Service.ServiceName, Contract.ContractId ,Contract.BeginDay, Service.UseArea, Service.Service_Cost, House.HouseName as ServiceType_Name
from( Service
 join Contract on Contract.ServiceId = Service.ServiceId )
 join House on House.ServiceId =  Service.ServiceId
 where Contract.ContractId not in (select Contract.ContractId from Service join Contract on Contract.ServiceId = Service.ServiceId where month(BeginDay) in (1,2,3) AND year(BeginDay) = '2019' ))
order by ServiceId;
 #cách 2:---> Sai ( đáp án chỉ ra 3 cái, đúng là: hơn 3 )
 select dv.ServiceId, ServiceName, ContractId, BeginDay, UseArea, Service_Cost, Service_Type_Name
from contract as hd 
right join service as dv on dv.ServiceId = hd.ServiceId 
inner join service_type as ldv on dv.Service_Type_Id = dv.Service_Type_Id
where (BeginDay < '2019-01-01' or BeginDay > '2019-03-31') or ContractId is null
group by ServiceName;




-- //---------------------------------------------------------------
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
#7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu
# của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2021
# nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.

#chon ra nhung dich vu khong duoc dung trong nam 2019
#xong tim xem trong nhung dich vu do, dich vu nao duoc dung trong nam 2021

SELECT DISTINCT hd.ServiceId, ServiceName, hd.ContractId, hd.BeginDay, UseArea, Max_People, Service_Cost, ldv.Service_Type_Name
FROM Service as dv
         INNER JOIN contract hd ON dv.ServiceId = hd.ServiceId
         INNER JOIN service_type ldv ON dv.Service_Type_Id = ldv.Service_Type_Id
WHERE hd.ServiceId NOT IN (SELECT DISTINCT ServiceId
                          FROM Contract
                          WHERE BeginDay BETWEEN '2019-01-01' AND '2019-12-31')
  AND BeginDay BETWEEN '2021-01-01' AND '2021-12-31';

#Cách 2: Dùng union all
 select Service.ServiceId, Service.ServiceName, Service.UseArea, Service.MaxPeople, Service.RentalPrice, Villa.VillaName as ServiceTypeName
from( Service
 join Contract on Contract.ServiceId = Service.ServiceId )
 join Villa on Villa.ServiceId =  Service.ServiceId
 where Contract.ContractId in (select Contract.ContractId from Service join Contract on Contract.ServiceId = Service.ServiceId where year(BeginDay) = '2018' and not year(BeginDay) = '2019' )
union all
select Service.ServiceId, Service.ServiceName, Service.UseArea, Service.MaxPeople, Service.RentalPrice, Room.RoomName as ServiceTypeName
from( Service
 join Contract on Contract.ServiceId = Service.ServiceId )
 join Room on Room.ServiceId =  Service.ServiceId
 where Contract.ContractId in (select Contract.ContractId from Service join Contract on Contract.ServiceId = Service.ServiceId where year(BeginDay) = '2018' and not year(BeginDay) = '2019' )
 union all
 select Service.ServiceId, Service.ServiceName, Service.UseArea, Service.MaxPeople, Service.RentalPrice, House.HouseName as ServiceTypeName
from( Service
 join Contract on Contract.ServiceId = Service.ServiceId )
 join House on House.ServiceId =  Service.ServiceId
 where Contract.ContractId in (select Contract.ContractId from Service join Contract on Contract.ServiceId = Service.ServiceId where year(BeginDay) = '2018' and not year(BeginDay) = '2019' );
 
 -- //---------------------------------------------------------------
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
#8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
#Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
/* Cách 1: Dùng distinct*/ 
SELECT DISTINCT Customer_Name
FROM Customer
ORDER BY Customer_Name;

/* Cách 2: dùng group by*/
SELECT Customer_Name
FROM Customer
GROUP BY Customer_Name
ORDER BY Customer_Name;

/* Cách 3: Dùng union*/
SELECT Customer_Name
FROM Customer
UNION
SELECT Customer_Name
FROM Customer;

/* Cách 4: Dùng union của (left join + right join) */
select Customer_Name
from customer
left join customertype on customer.CustomerTypeId = customertype.CustomerTypeId
union
select Customer_Name
from customer
right join customertype on customer.CustomerTypeId= customertype.CustomerTypeId;

-- //---------------------------------------------------------------
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
#9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019
# thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

SELECT MONTH(BeginDay) AS thang, COUNT(*) AS soLuongDV
FROM contract hd
inner join customer kh on kh.CustomerId = hd.CustomerId
WHERE BeginDay BETWEEN '2019-01-01' AND '2019-12-31'
GROUP BY MONTH(BeginDay)
Order by MONTH(BeginDay) ;

/*Cách 2: hay*/
select `month`.month , count(month(contract.BeginDay)) as times_order , sum(contract.TotalPayment) as tongtien from 
(select 1 as month
union select 2 as month
union select 3 as month
union select 4 as month
union select 5 as month
union select 6 as month
union select 7 as month
union select 8 as month
union select 9 as month
union select 10 as month
union select 11 as month
union select 12 as month) as `month`
left join contract on month(contract.BeginDay) = `month`.month
left join customer on customer.CustomerId = contract.CustomerId
where year(contract.BeginDay) = 2019 or year(contract.BeginDay) is null or month(contract.BeginDay) is null
group by `month`.month
order by `month`.month;

-- //---------------------------------------------------------------
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 
#10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm.
# Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem
# (được tính dựa trên việc count các IDHopDongChiTiet).

SELECT HopDong.ContractId, Service_Plus_Id, BeginDay, FinishDay, Deposit, count(HopDongChiTiet.Service_Plus_Id) as SoluongDichVu
FROM detailcontract as HopDongChiTiet
         LEFT JOIN contract as HopDong ON HopDongChiTiet.ContractId = HopDong.ContractId
group by HopDong.ContractId
order by HopDong.ContractId;

-- //---------------------------------------------------------------
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 

-- 11 Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond”
--  và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.

select distinct Service_Plus.Service_Plus_Id, Service_Plus.Service_Plus_Name, Customer.Customer_Address, Service_Plus.Unit, Service_Plus.Price  
from Customer 
inner join Contract on Customer.CustomerId = Contract.CustomerId
inner join DetailContract on Contract.ContractId = DetailContract.ContractId
inner join Service_Plus on DetailContract.Service_Plus_Id = Service_Plus.Service_Plus_Id
where Customer.Customer_Address like '%Vinh%' or Customer.Customer_Address like '%Quang Ngai%' and CustomerTypeId=100;

-- 12 Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), 
-- TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019

select Contract.ContractId, BeginDay, Employee.Employee_Name, Contract.CustomerId, Customer.Customer_Name, Customer.Customer_Phone, Service.ServiceName, DetailContract.Quantity
from Contract
inner join Employee on Contract.EmployeeId = Employee.EmployeeId
inner join Customer on Contract.CustomerId = Customer.CustomerId
inner join Service on Contract.ServiceId = Service.ServiceId
inner join DetailContract on Contract.ContractId = DetailContract.ContractId 
where  (Contract.CustomerId  in (select CustomerId from Contract where
 BeginDay between '2019-10-01' and '2019-12-31')) and (Contract.CustomerId not in (select CustomerId from Contract where
 BeginDay between '2019-01-01' and '2019-06-30'));
 
-- 13 Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.  

select dichvudikem.Service_Plus_Id, 
    dichvudikem.Service_Plus_Name ,
    count(hopdongchitiet.Service_Plus_Id) as count
    from detailcontract as hopdongchitiet 
    join Service_Plus as dichvudikem 
    on hopdongchitiet.Service_Plus_Id = dichvudikem.Service_Plus_Id
    group by hopdongchitiet.Service_Plus_Id 
    
    having count = (select count(detailcontract.Service_Plus_Id) as count 
    from detailcontract
    join Service_Plus
    on detailcontract.Service_Plus_Id = Service_Plus.Service_Plus_Id
    group by detailcontract.Service_Plus_Id  
    order by count desc
    limit 1);

# 
SELECT HDCT.idDichVuDiKem, tenDichVuDiKem, SUM(soLuong) AS soLanSuDung
FROM DichVuDiKem
         INNER JOIN HopDongChiTiet HDCT ON DichVuDiKem.idDichVuDiKem = HDCT.idDichVuDiKem
GROUP BY HDCT.idDichVuDiKem
HAVING SUM(soLuong) = (SELECT MAX(soLuong)
                       FROM (SELECT SUM(soLuong) AS soLuong
                             FROM HopDongChiTiet
                             GROUP BY idDichVuDiKem) AS thongKeDVDK);
-- MOI LAM DEN DAY***
-- 14 Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

select Contract.ContractId, Service.ServiceName, AccompaniedService.AccSerName, count(Contract.ContractId) from AccompaniedService
inner join DetailContract on DetailContract.AccSerId = AccompaniedService.AccSerId
inner join Contract on Contract.ContractId = DetailContract.ContractId
inner join Service on Service.ServiceId = Contract.ServiceId
group by AccompaniedService.AccSerId
having count(Contract.ContractId) ='1';

-- 15 Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

select Employee.EmployeeId, Employee.EmployeeName, Diploma.DiplomaName, Department.DepartmentName, Employee.EmpTelNum, count(ContractId)
from  Employee
inner join Diploma on Diploma.DiplomaId = Employee.DiplomaId
inner join Department on Department.DepartmentId = Employee.DepartmentId
inner join Contract on Contract.EmployeeId = Employee.EmployeeId
where year(BeginDay) in ('2018','2019')
group by  Employee.EmployeeId
having count(ContractId) <=3 ;

-- 16 Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

-- 17 Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.

update Customer
inner join Contract on Contract.CustomerId = Customer.CustomerId
inner join CustomerType on CustomerType.CustomerTypeId = Customer.CustomerTypeId
set Customer.CustomerTypeId = 'Di'
where Customer.CustomerId in (select Contract.CustomerId from Contract
 where Year(BeginDay) ='2019' and  Customer.CustomerTypeId = 'Pl'
 group by  Customer.CustomerId
having  sum(TotalPayment) > 10000000);

-- 18 Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).

-- 19 Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.

-- 20 Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.

select EmployeeId, EmployeeName, EmpEmail, EmpTelNum, EmployeeBir from Employee
union all
select CustomerId, CustomerName, CusEmail, CusTelNum, CustomerBir from Customer;

select CustomerId,CustomerName,CustomerBir,Gender,CusIdNum,CusTelNum,CusEmail,Address,Customer.CustomerTypeId,CustomerTypeName from Customer 
left join CustomerType on CustomerType.CustomerTypeId = Customer.CustomerTypeId