-- データベース削除
drop database MovieReservationSystem;

-- データベース作成
create database MovieReservationSystem;

-- データベースの使用
use MovieReservationSystem;

-- シアターテーブルの作成
create table theater(
	`theater_code` INTEGER AUTO_INCREMENT NOT NULL,
	`max_seat_space` INTEGER NOT NULL,
	PRIMARY KEY(`theater_code`)
);

INSERT INTO `theater`(`max_seat_space`) VALUES (325);
INSERT INTO `theater`(`max_seat_space`) VALUES (162);
INSERT INTO `theater`(`max_seat_space`) VALUES (224);

-- 性別テーブルの作成
create table gender(
	`gender_code` VARCHAR(1) NOT NULL,
	`gender` VARCHAR(32) NOT NULL,
	PRIMARY KEY(`gender_code`)
);

INSERT INTO `gender`(`gender_code`,`gender`) VALUES ('F','女性');
INSERT INTO `gender`(`gender_code`,`gender`) VALUES ('M','男性');
INSERT INTO `gender`(`gender_code`,`gender`) VALUES ('A','その他');


-- ユーザーテーブルの作成
create table user(
	`user_code` INTEGER AUTO_INCREMENT NOT NULL,
	`user_mail` VARCHAR(256) NOT NULL,
	`user_name` VARCHAR(128) NOT NULL,
	`user_phone` VARCHAR(16) NOT NULL,
	`gender_code` VARCHAR(4) NOT NULL,
	`user_birth` DATE NOT NULL,
	`user_pass` VARCHAR(64) NOT NULL,
	PRIMARY KEY(`user_code`),
	FOREIGN KEY `user`(gender_code) REFERENCES `gender`(gender_code)
);

INSERT INTO `user`(`user_mail`,`user_name`,`user_phone`,`gender_code`,`user_birth`,`user_pass`) VALUES('1701163@st.asojuku.ac.jp','吉野拓海','090-9405-0043','M','1998/04/03','aiueo');


-- 料金テーブルの作成
create table fee(
	`fee_code` INTEGER AUTO_INCREMENT NOT NULL,
	`fee_type` VARCHAR(128) NOT NULL,
	`fee` INTEGER NOT NULL,
	PRIMARY KEY(`fee_code`)
);

INSERT INTO `fee`(`fee_type`,`fee`) VALUES('通常料金',3500);
INSERT INTO `fee`(`fee_type`,`fee`) VALUES('半額',1750);


-- 映画テーブルの作成
create table movie(
	`movie_code` INTEGER AUTO_INCREMENT NOT NULL,
	`movie_name` VARCHAR(128) NOT NULL,
	`movie_time` INTEGER NOT NULL,
	`movie_start` DATE NOT NULL,
	`movie_finish` DATE NOT NULL,
	`movie_adress` VARCHAR(256) NOT NULL,
	`movie_thumbnail` VARCHAR(256) NOT NULL,
	`movie_description` VARCHAR(256) NOT NULL,
	PRIMARY KEY(`movie_code`)
);

INSERT INTO `movie`(`movie_name`,`movie_time`,`movie_start`,`movie_finish`,`movie_adress`,`movie_thumbnail`,`movie_description`) VALUES('名探偵ピカチュー',90,'2019/06/01','2019/08/01','https://meitantei-pikachu.jp/','../thumbnail/pikachu','全世界待望のハリウッド感動（電）超大作');

-- 上映テーブルの作成
create table shows(
	`show_code` INTEGER AUTO_INCREMENT NOT NULL,
	`movie_code` INTEGER NOT NULL,
	`show_date` DATETIME NOT NULL,
	`theater_code` INTEGER NOT NULL,
	`seat_space` INTEGER NOT NULL,
	PRIMARY KEY(`show_code`),
	FOREIGN KEY (`movie_code`) REFERENCES `movie`(`movie_code`),
	FOREIGN KEY (`theater_code`) REFERENCES `theater`(`theater_code`)
);

INSERT INTO `shows`(`show_code`,`movie_code`,`show_date`,`theater_code`,`seat_space`) VALUES(1,1,'2019/06/01 00:00:00',1,325);

-- 予約テーブルの作成
create table reservation(
	`reservation_code` INTEGER AUTO_INCREMENT NOT NULL,
	`user_code` INTEGER NOT NULL,
	`show_code` INTEGER NOT NULL,
	PRIMARY KEY(`reservation_code`),
	FOREIGN KEY (`user_code`) REFERENCES `user`(`user_code`),
	FOREIGN KEY (`show_code`) REFERENCES `shows`(`show_code`)
);

INSERT INTO `reservation`(`user_code`,`show_code`) VALUES(1,1);

-- 予約詳細のテーブル作成
create table reservation_details(
	`reservation_code` INTEGER NOT NULL,
	`detail_number` INTEGER NOT NULL,
	`seat_number` INTEGER NOT NULL,
	`fee_code` INTEGER NOT NULL,
	PRIMARY KEY(reservation_code,detail_number),
	FOREIGN KEY (`reservation_code`) REFERENCES `reservation`(`reservation_code`),
	FOREIGN KEY (`fee_code`) REFERENCES `fee`(`fee_code`)
);

INSERT INTO `reservation_details`(`reservation_code`,`detail_number`,`seat_number`,`fee_code`) VALUES(1,1,5,1);

-- 管理者テーブルの作成
create table admin(
	`admin_id` INTEGER AUTO_INCREMENT NOT NULL,
	`admin_name` VARCHAR(128) NOT NULL,
	`admin_password` VARCHAR(32) NOT NULL,
	PRIMARY KEY(`admin_id`)
);

INSERT INTO `admin`(`admin_name`,`admin_password`) VALUES("admin","aiueo");


-- セレクト文
select * from gender;
select * from user;
select * from fee;
select * from movie;
select * from shows;
select * from reservation;
select * from reservation_details;
select * from admin;