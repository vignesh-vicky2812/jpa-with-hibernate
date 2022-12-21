insert into course(id,name, created_date, last_updated_date) values(10001, 'JPA in 50 steps', current_timestamp(), current_timestamp());
insert into course(id,name, created_date, last_updated_date) values(10002, 'Spring in 50 steps',current_timestamp(), current_timestamp());
insert into course(id,name, created_date, last_updated_date) values(10003, 'AWS in 50 steps',current_timestamp(), current_timestamp());


insert into passport(id,number)
values(40001,'E123456');
insert into passport(id,number)
values(40002,'F987650');
insert into passport(id,number)
values(40003,'W145779');

insert into student(id,name,passport_id)
values(20001,'Vicky',40001);
insert into student(id,name,passport_id)
values(20002,'Adam',40002);
insert into student(id,name,passport_id)
values(20003,'James',40003);



insert into review(id, rating, description, course_id)
values(50001,'5','Great course',10001);
insert into review(id, rating, description, course_id)
values(50002,'3','On par course',10001);
insert into review(id, rating, description, course_id)
values(50003,'4','Good course',10003);


insert into student_course(student_id, course_id)
values(20001,10001);
insert into student_course(student_id, course_id)
values(20002,10001);
insert into student_course(student_id, course_id)
values(20003,10001);
insert into student_course(student_id, course_id)
values(20001,10003);

//select * from student_course, student, course where student_course.student_id=student.id and student_course.course_id=course.id