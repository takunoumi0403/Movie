use MovieReservationSystem;

create table gender(
	`gender_code` VARCHAR(4) NOT NULL,
	`gender` VARCHAR(128) NOT NULL,
	PRIMARY KEY(`gender_code`)
);

INSERT INTO `gender`(`gender_code`,`gender`) VALUES ('F001','女性');
INSERT INTO `gender`(`gender_code`,`gender`) VALUES ('M001','男性');
INSERT INTO `gender`(`gender_code`,`gender`) VALUES ('A001','その他');

create table user(
	`user_code` VARCHAR(4) NOT NULL,
	`user_mail` VARCHAR(256) NOT NULL,
	`user_name` VARCHAR(128) NOT NULL,
	`user_phone` VARCHAR(16) NOT NULL,
	`gender_code` VARCHAR(4) NOT NULL,
	`user_birth` DATE NOT NULL,
	`user_pass` VARCHAR(64) NOT NULL,
	PRIMARY KEY(`user_code`),
	FOREIGN KEY `user`(gender_code) REFERENCES `gender`(gender_code)
);

INSERT INTO `user`(`user_code`,`user_mail`,`user_name`,`user_phone`,`gender_code`,`user_birth`,`user_pass`) VALUES('U001','1701163@st.asojuku.ac.jp','吉野拓海','090-9405-0043','M001','1998/04/03','aiueo'); /**/

create table fee(
	`fee_code` VARCHAR(4) NOT NULL,
	`fee_type` VARCHAR(16) NOT NULL,
	`fee` INTEGER NOT NULL,
	PRIMARY KEY(`fee_code`)
);

INSERT INTO `fee`(`fee_code`,`fee_type`,`fee`) VALUES('FEE1','通常料金',3500);

create table movie(
	`movie_code` VARCHAR(16) NOT NULL,
	`movie_name` VARCHAR(128) NOT NULL,
	`movie_time` INTEGER NOT NULL,
	`movie_start` DATE NOT NULL,
	`movie_finish` DATE NOT NULL,
	`movie_adress` VARCHAR(256) NOT NULL,
	`movie_thumbnail` VARCHAR(256) NOT NULL,
	`movie_description` VARCHAR(256) NOT NULL,
	PRIMARY KEY(`movie_code`)
);

INSERT INTO `movie`(`movie_code`,`movie_name`,`movie_time`,`movie_start`,`movie_finish`,`movie_adress`,`movie_thumbnail`,`movie_description`) VALUES('MOVIE01','名探偵ピカチュー',90,'2019/06/01','2019/08/01','https://meitantei-pikachu.jp/','../thumbnail/pikachu','全世界待望のハリウッド感動（電）超大作');

create table shows(
	`show_code` VARCHAR(32) NOT NULL,
	`movie_code` VARCHAR(16) NOT NULL,
	`show_date` DATETIME NOT NULL,
	`theater_code` VARCHAR(128) NOT NULL,
	PRIMARY KEY(`show_code`),
	FOREIGN KEY `shows`(`movie_code`) REFERENCES `movie`(`movie_code`)
);

INSERT INTO `shows`(`show_code`,`movie_code`,`show_date`,`theater_code`) VALUES('S001','MOVIE01','2019/06/01 00:00:00','THEATER01');

create table reservation(
	`reservation_code` VARCHAR(32) NOT NULL,
	`user_code` VARCHAR(4) NOT NULL,
	`show_code` VARCHAR(32) NOT NULL,
	PRIMARY KEY(`reservation_code`),
	FOREIGN KEY (`user_code`) REFERENCES `user`(`user_code`),
	FOREIGN KEY (`show_code`) REFERENCES `shows`(`show_code`)
);

INSERT INTO `reservation`(`reservation_code`,`user_code`,`show_code`) VALUES('RESERVATION01','U001','S001');/**/

create table reservation_details(
	`reservation_code` VARCHAR(32) NOT NULL,
	`seat_code` VARCHAR(4) NOT NULL,
	`fee_code` VARCHAR(4) NOT NULL,
	PRIMARY KEY(`reservation_code`),
	FOREIGN KEY (`reservation_code`) REFERENCES `reservation`(`reservation_code`),
	FOREIGN KEY (`fee_code`) REFERENCES `fee`(`fee_code`)
);/**/

INSERT INTO `reservation_details`(`reservation_code`,`seat_code`,`fee_code`) VALUES('RESERVATION01','A10','FEE1');


select * from gender;
select * from user;
select * from fee;
select * from movie;
select * from shows;
select * from reservation;
select * from reservation_details;