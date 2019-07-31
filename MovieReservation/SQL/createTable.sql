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
INSERT INTO `theater`(`max_seat_space`) VALUES (10);

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
	`delete_flag` bit(1) NOT NULL,
	PRIMARY KEY(`user_code`),
	FOREIGN KEY `user`(gender_code) REFERENCES `gender`(gender_code)
);

INSERT INTO `user`(`user_mail`,`user_name`,`user_phone`,`gender_code`,`user_birth`,`user_pass`,`delete_flag`) VALUES('1701163@st.asojuku.ac.jp','吉野拓海','090-9405-0043','M','1998/04/03','aiueo',0);
INSERT INTO  user(`user_mail`,`user_name`,`user_phone`,`gender_code`,`user_birth`,`user_pass`,`delete_flag`) values("id","name","phone","M","1990-01-01","pass",0);
INSERT INTO  user(`user_mail`,`user_name`,`user_phone`,`gender_code`,`user_birth`,`user_pass`,`delete_flag`) values("id1","name","phone","M","1990-01-01","pass",1);

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
	`movie_adress` VARCHAR(256) ,
	`movie_thumbnail` VARCHAR(256) ,
	`movie_description` VARCHAR(256) NOT NULL,
	PRIMARY KEY(`movie_code`)
);

INSERT INTO `movie`(`movie_name`,`movie_time`,`movie_start`,`movie_finish`,`movie_adress`,`movie_thumbnail`,`movie_description`) VALUES('名探偵ピカチュー',90,'2019/06/01','2019/09/01','https://meitantei-pikachu.jp/','../thumbnail/pikachu','全世界待望のハリウッド感動（電）超大作');
INSERT INTO `movie`(`movie_name`,`movie_time`,`movie_start`,`movie_finish`,`movie_adress`,`movie_thumbnail`,`movie_description`) VALUES('トイストーリー',90,'2019/06/01','2019/09/01','https://www.disney.co.jp/movie/toy4.html','../thumbnail/pikachu','おもちゃが動くぞ！');
INSERT INTO `movie`(`movie_name`,`movie_time`,`movie_start`,`movie_finish`,`movie_adress`,`movie_thumbnail`,`movie_description`) VALUES('ミュツーの逆襲',90,'2019/06/01','2019/09/01','https://www.pokemon-movie.jp/','../thumbnail/pikachu','ミュツーじゃなくてミュウツーらしいぞ');
INSERT INTO `movie`(`movie_name`,`movie_time`,`movie_start`,`movie_finish`,`movie_adress`,`movie_thumbnail`,`movie_description`) VALUES('ダイナー',90,'2019/06/01','2019/09/01','http://wwws.warnerbros.co.jp/diner-movie/','../thumbnail/pikachu','ダイナーーーー');
INSERT INTO `movie`(`movie_name`,`movie_time`,`movie_start`,`movie_finish`,`movie_adress`,`movie_thumbnail`,`movie_description`) VALUES('ザ・ファブル',90,'2019/06/01','2019/09/01','https://meitantei-pikachu.jp/','../thumbnail/pikachu','ファーブル');
INSERT INTO `movie`(`movie_name`,`movie_time`,`movie_start`,`movie_finish`,`movie_adress`,`movie_thumbnail`,`movie_description`) VALUES('うたのプリンスさまっ',90,'2019/06/01','2019/09/01','https://meitantei-pikachu.jp/','../thumbnail/pikachu','歌うまいね');
INSERT INTO `movie`(`movie_name`,`movie_time`,`movie_start`,`movie_finish`,`movie_adress`,`movie_thumbnail`,`movie_description`) VALUES('アラジン',90,'2019/06/01','2019/09/01','https://meitantei-pikachu.jp/','../thumbnail/pikachu','魔法のランプの人');
INSERT INTO `movie`(`movie_name`,`movie_time`,`movie_start`,`movie_finish`,`movie_adress`,`movie_thumbnail`,`movie_description`) VALUES('ゴジラ',90,'2019/06/01','2019/09/01','https://meitantei-pikachu.jp/','../thumbnail/pikachu','おっきい恐竜');


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

INSERT INTO `shows`(`movie_code`,`show_date`,`theater_code`,`seat_space`) VALUES(1,current_date,1,325);
INSERT INTO `shows`(`movie_code`,`show_date`,`theater_code`,`seat_space`) VALUES(2,current_date,2,162);
INSERT INTO `shows`(`movie_code`,`show_date`,`theater_code`,`seat_space`) VALUES(3,current_date,3,224);
INSERT INTO `shows`(`movie_code`,`show_date`,`theater_code`,`seat_space`) VALUES(3,date_add(current_date,interval 1 day),4,10);
INSERT INTO `shows`(`movie_code`,`show_date`,`theater_code`,`seat_space`) VALUES(4,date_add(current_date,interval 1 day),1,325);
INSERT INTO `shows`(`movie_code`,`show_date`,`theater_code`,`seat_space`) VALUES(5,date_add(current_date,interval 1 day),2,162);
INSERT INTO `shows`(`movie_code`,`show_date`,`theater_code`,`seat_space`) VALUES(6,date_add(current_date,interval 2 day),1,325);
INSERT INTO `shows`(`movie_code`,`show_date`,`theater_code`,`seat_space`) VALUES(7,date_add(current_date,interval 2 day),2,162);
INSERT INTO `shows`(`movie_code`,`show_date`,`theater_code`,`seat_space`) VALUES(1,date_add(current_date,interval 2 day),2,162);
INSERT INTO `shows`(`movie_code`,`show_date`,`theater_code`,`seat_space`) VALUES(2,current_date,3,224);
INSERT INTO `shows`(`movie_code`,`show_date`,`theater_code`,`seat_space`) VALUES(3,current_date,3,224);


-- 予約テーブルの作成
create table reservation(
	`reservation_code` INTEGER AUTO_INCREMENT NOT NULL,
	`show_code` INTEGER NOT NULL,
	`user_code` INTEGER NOT NULL,
	PRIMARY KEY(`reservation_code`,`show_code`,`user_code`),
	FOREIGN KEY (`user_code`) REFERENCES `user`(`user_code`),
	FOREIGN KEY (`show_code`) REFERENCES `shows`(`show_code`)
);

-- INSERT INTO `reservation`(`user_code`,`show_code`) VALUES(1,1);
-- INSERT INTO `reservation`(`user_code`,`show_code`) VALUES(1,2);
-- INSERT INTO `reservation`(`user_code`,`show_code`) VALUES(1,3);
-- INSERT INTO `reservation`(`user_code`,`show_code`) VALUES(1,4);
-- INSERT INTO `reservation`(`user_code`,`show_code`) VALUES(1,5);

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

-- INSERT INTO `reservation_details`(`reservation_code`,`detail_number`,`seat_number`,`fee_code`) VALUES(1,1,5,1);
-- INSERT INTO `reservation_details`(`reservation_code`,`detail_number`,`seat_number`,`fee_code`) VALUES(1,2,6,1);
-- INSERT INTO `reservation_details`(`reservation_code`,`detail_number`,`seat_number`,`fee_code`) VALUES(1,3,8,1);
-- INSERT INTO `reservation_details`(`reservation_code`,`detail_number`,`seat_number`,`fee_code`) VALUES(1,4,12,1);
-- INSERT INTO `reservation_details`(`reservation_code`,`detail_number`,`seat_number`,`fee_code`) VALUES(1,5,33,1);
-- INSERT INTO `reservation_details`(`reservation_code`,`detail_number`,`seat_number`,`fee_code`) VALUES(2,1,1,1);
-- INSERT INTO `reservation_details`(`reservation_code`,`detail_number`,`seat_number`,`fee_code`) VALUES(2,2,5,1);
-- INSERT INTO `reservation_details`(`reservation_code`,`detail_number`,`seat_number`,`fee_code`) VALUES(2,3,9,1);
-- INSERT INTO `reservation_details`(`reservation_code`,`detail_number`,`seat_number`,`fee_code`) VALUES(2,4,42,1);
-- INSERT INTO `reservation_details`(`reservation_code`,`detail_number`,`seat_number`,`fee_code`) VALUES(2,5,93,1);
-- INSERT INTO `reservation_details`(`reservation_code`,`detail_number`,`seat_number`,`fee_code`) VALUES(3,1,43,1);
-- INSERT INTO `reservation_details`(`reservation_code`,`detail_number`,`seat_number`,`fee_code`) VALUES(3,2,2,1);
-- INSERT INTO `reservation_details`(`reservation_code`,`detail_number`,`seat_number`,`fee_code`) VALUES(3,3,3,1);
-- INSERT INTO `reservation_details`(`reservation_code`,`detail_number`,`seat_number`,`fee_code`) VALUES(3,4,45,1);
-- INSERT INTO `reservation_details`(`reservation_code`,`detail_number`,`seat_number`,`fee_code`) VALUES(3,5,5,1);

-- 管理者テーブルの作成
create table adm(
	`admin_id` INTEGER AUTO_INCREMENT NOT NULL,
	`admin_name` VARCHAR(128) NOT NULL,
	`admin_password` VARCHAR(32) NOT NULL,
	PRIMARY KEY(`admin_id`)
);

INSERT INTO `adm`(`admin_name`,`admin_password`) VALUES("admin","aiueo");


-- セレクト文
select * from gender;
select * from user;
select * from fee;
select * from movie;
select * from shows;
select * from reservation;
select * from reservation_details;
select * from admin;

SELECT DATE_FORMAT(show_date,'%Y/%m/%d') as YYMMDD ,DATE_FORMAT(show_date,' %H:%i:%s') as HHMMSS
FROM shows ORDER BY YYMMDD , HHMMSS;


SELECT * FROM reservation INNER JOIN reservation_details ON reseravtion.reservation_code = reservation_details.reservation_code INNER JOIN fee ON reservation_details.fee_code = fee.fee_code INNER JOIN shows ON shows.show_code = reservation.show_code INNER JOIN movie ON shows.movie_code = movie.movie_code WHERE user_code = 1;
select s.show_date,r.reservation_code,rd.detail_number,m.movie_name,rd.seat_number,f.fee from reservation r inner join reservation_details rd on r.reservation_code = rd.reservation_code inner join shows s on r.show_code = s.show_code inner join movie m on s.movie_code = m.movie_code inner join fee f on rd.fee_code = f.fee_code;
