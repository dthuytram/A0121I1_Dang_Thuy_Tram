use a01_student;
select *
from mon_hoc
limit 1000,20000;

select *
from mon_hoc
where ten_mh
in(
'Hoa', 'Hoang', 'Tuan Anh'
)
limit 0, 30

select *
from mon_hoc
where ten_mh like '%A%';


