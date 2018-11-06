insert into course(id, name) values(10001, 'Math')
insert into course(id, name) values(10002, 'English')
insert into course(id, name) values(10003, 'Literature')

insert into passport(id, number) values(30001, 'J123456')
insert into passport(id, number) values(30002, 'P123456')
insert into passport(id, number) values(30003, 'M123456')

insert into student(id, name, passport_id) values(20001, 'John', 30001)
insert into student(id, name, passport_id) values(20002, 'Pete', 30002)
insert into student(id, name, passport_id) values(20003, 'Mary', 30003)

insert into review(id, rating, description, course_id) values(30001, '5', 'Great', 10001)
insert into review(id, rating, description, course_id) values(30002, '4', 'Perfect', 10001)
insert into review(id, rating, description, course_id) values(30003, '3', 'Wonderful', 10003)

