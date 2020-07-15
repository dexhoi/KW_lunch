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

INSERT INTO user_tbl(name, password) VALUES('CaptainAmerica', 'pass');
INSERT INTO user_tbl(name, password) VALUES('HarleyQuinn', 'pass');
INSERT INTO user_tbl(name, password) VALUES('kain', 'pass');
INSERT INTO user_tbl(name, password) VALUES('ironman', 'pass');


INSERT INTO shop_tbl (user_id,name,genre_id,price,offer_time,address) 
VALUES (1,'タリースパイス',6,800,'00:15:00','香川県高松市田町14-1 田町プラザビル 2F');

INSERT INTO shop_tbl (user_id,name,genre_id,price,offer_time,address) 
VALUES (1,'マサラ亭',6,700,'00:8:00','香川県高松市亀井町9-6');

INSERT INTO shop_tbl (user_id,name,genre_id,price,offer_time,address) 
VALUES (1,'おたるばんや',3,800,'00:15:00','香川県高松市常盤町1-3-1 瓦町FLAG 10F');

INSERT INTO shop_tbl (user_id,name,genre_id,price,offer_time,address) 
VALUES (1,'ニューイハラ食堂',3,800,'00:15:00','香川県高松市常盤町2-14-1');

INSERT INTO shop_tbl (user_id,name,genre_id,price,offer_time,address) 
VALUES (1,'おなじみ',5,700,'00:15:00','香川県高松市瓦町2-5-10');

INSERT INTO shop_tbl (user_id,name,genre_id,price,offer_time,address) 
VALUES (2,'グリル＆洋食　アガぺ',5,1200,'00:15:00','香川県高松市塩上町1-3-15');

INSERT INTO shop_tbl (user_id,name,genre_id,price,offer_time,address) 
VALUES(2, 'マドラス', 6, 770, '00:30:00', '天神前4-1');

INSERT INTO shop_tbl (user_id,name,genre_id,price,offer_time,address) 
VALUES(2, 'キリン堂', 6, 400, '00:30:00', '塩上町1丁目2-30');

INSERT INTO shop_tbl (user_id,name,genre_id,price,offer_time,address) 
VALUES(2, 'うどん棒', 1, 600, '00:20:00', '亀井町8-19');

INSERT INTO shop_tbl (user_id,name,genre_id,price,offer_time,address) 
VALUES(2, '福園', 4, 800, '00:20:00', '香川県高松市常磐町1-9-3 1F');

INSERT INTO shop_tbl(user_id,name,genre_id,price,offer_time,address)
VALUES(3,'すずむし',2,1000,'00:20:00','香川県高松市南新町４-１１吉野ビル１F');

INSERT INTO shop_tbl(user_id,name,genre_id,price,offer_time,address)
VALUES(3,'はやぶさ',2,1000,'00:20:00','香川県高松市瓦町1-4-8');

INSERT INTO shop_tbl(user_id,name,genre_id,price,offer_time,address)
VALUES(3,'王龍ラーメン 高松瓦町店',2,900,'00:20:00','香川県高松市瓦町1-10-14 花田ビル 1F');

INSERT INTO shop_tbl(user_id,name,genre_id,price,offer_time,address)
VALUES(3,'綿谷',1,250,'00:5:00','香川県高松市南新町8-11');

INSERT INTO shop_tbl(user_id,name,genre_id,price,offer_time,address)
VALUES(3,'天下一品',2,900,'00:20:00','香川県高松市瓦町1-2-6');

INSERT INTO shop_tbl(user_id,name,genre_id,price,offer_time,address)
VALUES(3,'たも屋',1,300,'00:5:00','香川県高松市南新町11-9 南新町ビル　１Ｆ');


INSERT INTO img_tbl(shop_id, img_path) VALUES(1, '0.jpg');
INSERT INTO img_tbl(shop_id, img_path) VALUES(1, '1.jpg');
INSERT INTO img_tbl(shop_id, img_path) VALUES(1, '2.jpg');

INSERT INTO img_tbl(shop_id, img_path) VALUES(2, '0.jpg');
INSERT INTO img_tbl(shop_id, img_path) VALUES(2, '1.jpg');
INSERT INTO img_tbl(shop_id, img_path) VALUES(2, '2.jpg');
INSERT INTO img_tbl(shop_id, img_path) VALUES(2, '3.jpg');
INSERT INTO img_tbl(shop_id, img_path) VALUES(3, '0.jpg');
INSERT INTO img_tbl(shop_id, img_path) VALUES(3, '1.jpg');
INSERT INTO img_tbl(shop_id, img_path) VALUES(4, '0.jpg');
INSERT INTO img_tbl(shop_id, img_path) VALUES(5, '0.jpg');
INSERT INTO img_tbl(shop_id, img_path) VALUES(5, '1.jpg');
INSERT INTO img_tbl(shop_id, img_path) VALUES(6, '0.jpg');
INSERT INTO img_tbl(shop_id, img_path) VALUES(6, '1.jpg');
INSERT INTO img_tbl(shop_id, img_path) VALUES(7, '0.jpg');
INSERT INTO img_tbl(shop_id, img_path) VALUES(8, '0.jpg');
INSERT INTO img_tbl(shop_id, img_path) VALUES(9, '0.jpg');
INSERT INTO img_tbl(shop_id, img_path) VALUES(10, '0.jpg');
INSERT INTO img_tbl(shop_id, img_path) VALUES(11, '0.jpg');
INSERT INTO img_tbl(shop_id, img_path) VALUES(12, '0.jpg');
INSERT INTO img_tbl(shop_id, img_path) VALUES(13, '0.jpg');
INSERT INTO img_tbl(shop_id, img_path) VALUES(14, '0.jpg');
INSERT INTO img_tbl(shop_id, img_path) VALUES(15, '0.jpg');
INSERT INTO img_tbl(shop_id, img_path) VALUES(16, '0.jpg');


INSERT INTO review_tbl(shop_id, user_id, score) VALUES(1,1,2);
INSERT INTO review_tbl(shop_id, user_id, score) VALUES(2,1,3);
INSERT INTO review_tbl(shop_id, user_id, score) VALUES(3,1,2);
INSERT INTO review_tbl(shop_id, user_id, score) VALUES(4,1,2);
INSERT INTO review_tbl(shop_id, user_id, score) VALUES(5,1,3);
INSERT INTO review_tbl(shop_id, user_id, score) VALUES(6,2,3);
INSERT INTO review_tbl(shop_id, user_id, score) VALUES(7,2,2);
INSERT INTO review_tbl(shop_id, user_id, score) VALUES(8,2,2);
INSERT INTO review_tbl(shop_id, user_id, score) VALUES(9,2,3);
INSERT INTO review_tbl(shop_id, user_id, score) VALUES(10,2,3);
INSERT INTO review_tbl(shop_id, user_id, score) VALUES(11,3,3);
INSERT INTO review_tbl(shop_id, user_id, score) VALUES(12,3,2);
INSERT INTO review_tbl(shop_id, user_id, score) VALUES(13,3,3);
INSERT INTO review_tbl(shop_id, user_id, score) VALUES(14,3,3);
INSERT INTO review_tbl(shop_id, user_id, score) VALUES(15,3,1);
INSERT INTO review_tbl(shop_id, user_id, score) VALUES(16,3,3);