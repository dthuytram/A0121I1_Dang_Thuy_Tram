
use class;

create table loai_sach(
ma_loai_sach int(15) primary key auto_increment,
ten_loai_sach nvarchar(100)
);
insert into loai_sach(ten_loai_sach) 
values('văn học'),
('tin học'),
('toán học'),
('thiên văn học'),
('sử học');

create table sach(
ma_sach int(15) primary key auto_increment,
ten_sach nvarchar(50) not null,
nha_xuat_ban nvarchar(100) not null,
ten_tac_gia nvarchar(50) not null,
nam_xuat_ban date,
so_lan_xuat_ban int,
gia float not null,
anh blob,
ma_loai_sach int(15) not null,
foreign key (ma_loai_sach) references loai_sach(ma_loai_sach)
);
insert into sach(ten_sach,nha_xuat_ban,ten_tac_gia,nam_xuat_ban,so_lan_xuat_ban,gia,anh,ma_loai_sach)
values('Nước Anh Trong tim tôi','NXB Hà Nội','Kulzsc','2021/01/09',12,63.960,'D:\A0121I1_Dang_Thuy_Tram(1)\A0121I1_Dang_Thuy_Tram\CodeGym\Module3\p3_ThaoTacCSDL\anh\anh.jpg',01),
('Hoa Lan Vàng','NXB Dân Trí','R. G. Grant','2018/11/03',19,360.000,'D:\A0121I1_Dang_Thuy_Tram(1)\A0121I1_Dang_Thuy_Tram\CodeGym\Module3\p3_ThaoTacCSDL\anh\hoa.jpg',5),
('Hoàng Hôn Trên Xăng-ti mét','NXB Thanh Niên','Joy Woodward','2020/11/12',12,101910,'D:\A0121I1_Dang_Thuy_Tram(1)\A0121I1_Dang_Thuy_Tram\CodeGym\Module3\p3_ThaoTacCSDL\anh\hoanghon.jpg',3),
('Sách - Toán Học Cao Cấp - Tập 3','NXB Giáo Dục Việt Nam','Tạ Văn Đĩnh - Nguyễn Hồ Quỳnh','2020/06/13',99,41400,'D:\A0121I1_Dang_Thuy_Tram(1)\A0121I1_Dang_Thuy_Tram\CodeGym\Module3\p3_ThaoTacCSDL\anh\may.jpg',3),
('Nhà Giả Kim','NXB Hội Nhà Văn','Paulo Coelho','2020/03/01',30,67.150,'D:\A0121I1_Dang_Thuy_Tram(1)\A0121I1_Dang_Thuy_Tram\CodeGym\Module3\p3_ThaoTacCSDL\anh\phim.jpg',2);

create table phieu_muon(
ma_sinh_vien int(15) not null,
ma_sach int(15) not null,
primary key(ma_sinh_vien, ma_sach),
foreign key (ma_sinh_vien) references sinh_vien(ma_sinh_vien),
foreign key (ma_sach) references sach(ma_sach),
ngay_muon date not null,
ngay_tra date
);
insert into phieu_muon(ma_sinh_vien,ma_sach,ngay_muon,ngay_tra)
values(1,30,'2021/08/02','2021/08/17'),
(1,26,'2021/08/30','2021/09/05'),
(2,26,'2021/09/01',null),
(2,28,'2021/08/02','2021/08/16'),
(4,29,'2021/09/02',null),
(5,30,'2021/08/02','2021/08/17');

create table sinh_vien(
ma_sinh_vien int(15) primary key auto_increment,
ten_sinh_vien nvarchar(50) not null,
dia_chi nvarchar(500),
email nvarchar(50) not null,
anh blob
);
insert into sinh_vien(ten_sinh_vien,dia_chi,email,anh)
values('Nguyễn Thị Nga','08, Hà Văn Tính, Hòa Khánh Nam, Liên Chiểu, Đà Nẵng','nga1234@gmail.com','D:\Java\A0121I1-NguyenThiNga\Module_3\ss3_thao_tac_csdl\bai_tap\anh\nga.jpg'),
('Nguyễn Thị Hiền','08, Hà Văn Tính, Hòa Khánh Nam, Liên Chiểu, Đà Nẵng','hien1234@gmail.com',null),
('Đặng Thùy Trâm','97, Phạm Như Xương, Hòa Khánh Bắc, Liên Chiểu, Đà Nẵng','tram1234@gmail.com',null),
('Nguyễn Thị Hậu',null,'hau1234@hmail.com',null),
('Phạm Thị Quỳnh Như','85, Nguyễn Lương Bằng, Hòa Khánh Bắc, Liên Chiểu, Đà Nẵng','nhu1234@gmail.com',null);
