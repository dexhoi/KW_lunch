create database shop_db with encoding='UTF-8';

create table genre_tbl(
	id SERIAL PRIMARY KEY,
	name varchar(120) not null
);

create table user_tbl(
	id  SERIAL PRIMARY KEY,
	name varchar (50) not null,
	password varchar(50) not null
);

create table shop_tbl(
	id  SERIAL PRIMARY KEY,
	user_id integer not null,
	name varchar (120) not null,
	genre_id integer not null,
	price integer not null,
	offer_time time,
	address varchar(120) not null,
	
	foreign key(genre_id) references genre_tbl(id) ON UPDATE CASCADE ON DELETE CASCADE,
	foreign key(user_id) references user_tbl(id) ON UPDATE CASCADE ON DELETE CASCADE
);


create table review_tbl(
	shop_id integer not null,
	user_id integer not null,
	score integer not null,
	
	foreign key(shop_id) references shop_tbl(id) ON UPDATE CASCADE ON DELETE CASCADE,
	foreign key(user_id) references user_tbl(id) ON UPDATE CASCADE ON DELETE CASCADE
);


create table img_tbl(
	shop_id integer not null,
	img_path varchar(200) not null,

	foreign key(shop_id) references shop_tbl(id) ON UPDATE CASCADE ON DELETE CASCADE
);

create table vac_tbl(
	shop_id integer not null,
	vacation integer default -1,

	foreign key(shop_id) references shop_tbl(id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO genre_tbl(name) VALUES('うどん');
INSERT INTO genre_tbl(name) VALUES('ラーメン');
INSERT INTO genre_tbl(name) VALUES('和食');
INSERT INTO genre_tbl(name) VALUES('中華');
INSERT INTO genre_tbl(name) VALUES('洋食');
INSERT INTO genre_tbl(name) VALUES('カレー');

INSERT INTO user_tbl(name, password) VALUES('ironman', 'pass');