drop database if exists competence;
create database competence default character set utf8 collate utf8_general_ci;

use competence;
create table group_info(
	id integer(10) primary key not null,
	group_num varchar(200),
	group_name varchar(255),
	description varchar(255),
	use_flag tinyint(1)
)engine=innodb default charset=utf8;

create table user(
	id integer(10) primary key not null,
	name varchar(200),
	login_name varchar(200),
	password varchar(255),
	birthday date,
	sex varchar(2),
	mail varchar(200),
	address varchar(255),
	phone varchar(20),
	description varchar(255),
	use_flag tinyint(1),
	groupid integer(10),
foreign key(groupid) references group_info(id) on delete cascade on update cascade
)engine=innodb default charset=utf8;

create table role(
	id integer(10) primary key not null,
	role_name varchar(255),
	role_num varchar(200),
	description varchar(255),
	use_flag tinyint(1)
)engine=innodb default charset=utf8;

create table user_role(
	id integer(10) primary key not null,
	login_name varchar(200),
	role_num varchar(200),
	description varchar(255),
	userid integer(10),
	roleid integer(10),
foreign key(userid) references user(id) on delete cascade on update cascade,
foreign key(roleid) references role(id) on delete cascade on update cascade
)engine=innodb default charset=utf8;

create table menu(
	id integer(10) primary key not null,
	menu_num varchar(200),
	menu_name varchar(100),
	parent_menu integer(10),
	use_flag tinyint(1),
	description varchar(255)
)engine=innodb default charset=utf8;

create table menu_project(
	id integer(10) primary key not null,
	project varchar(200),
	project_name varchar(100),
	menuid integer(10),
foreign key(menuid) references menu(id) on delete cascade on update cascade
)engine=innodb default charset=utf8;


create table user_menu(
	id integer(10) primary key not null,
	description varchar(255),
	userid integer(10),
	menuid integer(10),
	menu_projectid integer(10),
foreign key(userid) references user(id) on delete cascade on update cascade,
foreign key(menuid) references menu(id) on delete cascade on update cascade,
foreign key(menu_projectid) references menu_project(id) on delete cascade on update cascade
)engine=innodb default charset=utf8;

create table role_menu(
	id integer(10) primary key not null,
	description varchar(255),
	roleid integer(10),
	menuid integer(10),
	menu_projectid integer(10),
foreign key(roleid) references role(id) on delete cascade on update cascade,
foreign key(menuid) references menu(id) on delete cascade on update cascade,
foreign key(menu_projectid) references menu_project(id) on delete cascade on update cascade
)engine=innodb default charset=utf8;

create table op_info(
	id integer(10) primary key not null,
	op_num varchar(200),
	op_name varchar(255),
	description varchar(255)
)engine=innodb default charset=utf8;

create table menu_op(
	id integer(10) primary key not null,
	use_flag tinyint(1),
	menuid integer(10),
	operatorid integer(10),
	menu_projectid integer(10),
foreign key(menuid) references menu(id) on delete cascade on update cascade,
foreign key(operatorid) references op_info(id) on delete cascade on update cascade,
foreign key(menu_projectid) references menu_project(id) on delete cascade on update cascade
)engine=innodb default charset=utf8;


