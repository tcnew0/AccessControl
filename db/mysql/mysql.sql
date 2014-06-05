drop database if exists competence;
create database competence default character set utf8 collate utf8_general_ci;

use competence;
create table group_info(
	id bigint(10) primary key not null,
	group_num varchar(200),
	group_name varchar(255),
	description varchar(255),	
	use_flag tinyint(1),
	create_user bigint(10),
	create_time timestamp,
	update_user bigint(10),
	update_time timestamp
)engine=innodb default charset=utf8;

create table user(
	id bigint(10) primary key not null,
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
	group_id bigint(10),
	create_user bigint(10),
	create_time timestamp,
	update_user bigint(10),
	update_time timestamp,
foreign key(group_id) references group_info(id) on delete cascade on update cascade
)engine=innodb default charset=utf8;

create table group_user(
	id bigint(10) primary key not null,
	group_num varchar(200),
	login_name varchar(200),
	user_id bigint(10),
	group_id bigint(10),
	create_user bigint(10),
	create_time timestamp,
	update_user bigint(10),
	update_time timestamp
)engine=innodb default charset=utf8;

create table role(
	id bigint(10) primary key not null,
	role_name varchar(255),
	role_num varchar(200),
	description varchar(255),
	use_flag tinyint(1),
	create_user bigint(10),
	create_time timestamp,
	update_user bigint(10),
	update_time timestamp
)engine=innodb default charset=utf8;

create table user_role(
	id bigint(10) primary key not null,
	login_name varchar(200),
	role_num varchar(200),
	description varchar(255),
	user_id bigint(10),
	role_id bigint(10),
	create_user bigint(10),
	create_time timestamp,
	update_user bigint(10),
	update_time timestamp,
foreign key(user_id) references user(id) on delete cascade on update cascade,
foreign key(role_id) references role(id) on delete cascade on update cascade
)engine=innodb default charset=utf8;

create table menu(
	id bigint(10) primary key not null,
	menu_num varchar(200),
	menu_name varchar(100),
	parent_menu bigint(10),
	use_flag tinyint(1),
	description varchar(255),
	create_user bigint(10),
	create_time timestamp,
	update_user bigint(10),
	update_time timestamp
)engine=innodb default charset=utf8;

create table menu_project(
	id bigint(10) primary key not null,
	project varchar(200),
	project_name varchar(100),
	menu_id bigint(10),
	create_user bigint(10),
	create_time timestamp,
	update_user bigint(10),
	update_time timestamp,
foreign key(menu_id) references menu(id) on delete cascade on update cascade
)engine=innodb default charset=utf8;


create table user_menu(
	id bigint(10) primary key not null,
	description varchar(255),
	user_id bigint(10),
	menu_id bigint(10),
	project_id bigint(10),
	create_user bigint(10),
	create_time timestamp,
	update_user bigint(10),
	update_time timestamp,
foreign key(user_id) references user(id) on delete cascade on update cascade,
foreign key(menu_id) references menu(id) on delete cascade on update cascade,
foreign key(project_id) references menu_project(id) on delete cascade on update cascade
)engine=innodb default charset=utf8;

create table role_menu(
	id bigint(10) primary key not null,
	description varchar(255),
	role_id bigint(10),
	menu_id bigint(10),
	project_id bigint(10),
	create_user bigint(10),
	create_time timestamp,
	update_user bigint(10),
	update_time timestamp,
foreign key(role_id) references role(id) on delete cascade on update cascade,
foreign key(menu_id) references menu(id) on delete cascade on update cascade,
foreign key(project_id) references menu_project(id) on delete cascade on update cascade
)engine=innodb default charset=utf8;

create table op_info(
	id bigint(10) primary key not null,
	op_num varchar(200),
	op_name varchar(255),
	description varchar(255),
	create_user bigint(10),
	create_time timestamp,
	update_user bigint(10),
	update_time timestamp
)engine=innodb default charset=utf8;

create table menu_op(
	id bigint(10) primary key not null,
	use_flag tinyint(1),
	menu_id bigint(10),
	operator_id bigint(10),
	project_id bigint(10),
	create_user bigint(10),
	create_time timestamp,
	update_user bigint(10),
	update_time timestamp,
foreign key(menu_id) references menu(id) on delete cascade on update cascade,
foreign key(operator_id) references op_info(id) on delete cascade on update cascade,
foreign key(project_id) references menu_project(id) on delete cascade on update cascade
)engine=innodb default charset=utf8;


