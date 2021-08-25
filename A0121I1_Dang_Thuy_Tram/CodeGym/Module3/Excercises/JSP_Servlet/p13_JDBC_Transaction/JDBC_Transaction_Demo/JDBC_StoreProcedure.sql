DELIMITER $$
create procedure avgPoint(out output double)
begin 
	select avg(point) into output
    from student;

end; $$
DELIMITER ;

call avgPoint(@result);
select @result;

DELIMITER $$
create procedure searchByName(in key_word varchar(255))
begin 
	select *
	from student
	where `name` = key_word;
end; $$
DELIMITER ;

call searchByName("Nguyen Van A");

DELIMITER $$
create procedure searchByName2(in student_id int,  out studentName varchar(255))
begin 
	select `name` into studentName
	from student
	where id = student_id;
end; $$
DELIMITER ;

call searchByName2(1 , @studentName);
select @studentName;