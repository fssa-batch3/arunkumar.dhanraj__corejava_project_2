use arunkumar_dhanraj_corejava_project;

-- User table in corejava project
CREATE TABLE IF NOT EXISTS users (
    id int PRIMARY KEY auto_increment,
    name VARCHAR(30),
    email VARCHAR(40),
    password VARCHAR(40),
    phonenumber VARCHAR(10)
);

select * from  users;
UPDATE users SET name = 'Surava', phonenumber = '1234567890', blood_group = 'A+ve', availability = 'Sunday', category = 'bowler' WHERE id = 87;

delete from users where name="Muthu";


-- Turf 
CREATE TABLE IF NOT EXISTS turf(
turf_id int auto_increment, 
image varchar(500),
details varchar(500),
PRIMARY KEY(turf_id)
);

select * from  turf;
delete from turf where details="Chennai chennai";

-- requirement tables 
CREATE TABLE IF NOT EXISTS requirement(
requirement_id int auto_increment, 
message varchar(500),
PRIMARY KEY(requirement_id )
); 

select * from requirement;
delete from requirement;

-- turf booking 
CREATE TABLE `arunkumar_dhanraj_corejava_project`.`turf_booking` (
  `booking_id` INT NOT NULL ,
  `turf_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `date` DATE NOT NULL,
  `time` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`booking_id`) , 
  UNIQUE INDEX `booking_id_UNIQUE` (`booking_id` ASC) VISIBLE,
  INDEX `FK_turf_id_idx` (`turf_id` ASC) VISIBLE,
  INDEX `FK_user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FK_turf_id`
    FOREIGN KEY (`turf_id`)
    REFERENCES `arunkumar_dhanraj_corejava_project`.`turf` (`turf_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_USER_TURF_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `arunkumar_dhanraj_corejava_project`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    select * from turf_booking;
    delete from turf_booking where turf_id = 71;
    
  SELECT time FROM turf_booking WHERE turf_id = 71 AND date = '2023-09-22';

    CREATE TABLE `turf_booking` (
  `booking_id` int NOT NULL AUTO_INCREMENT,
  `turf_id` int NOT NULL,
  `user_id` int NOT NULL,
  `date` date NOT NULL,
  `time` varchar(20) NOT NULL,
  PRIMARY KEY (`booking_id`),
  UNIQUE KEY `booking_id_UNIQUE` (`booking_id`),
  KEY `FK_turf_id_idx` (`turf_id`),
  KEY `FK_user_id_idx` (`user_id`),
  CONSTRAINT `FK_turf_id` FOREIGN KEY (`turf_id`) REFERENCES `turf` (`turf_id`),
  CONSTRAINT `FK_USER_TURF_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ;
CREATE TABLE `turf` (
  `turf_id` int NOT NULL AUTO_INCREMENT,
  `image` varchar(500) NOT NULL,
  `details` varchar(500) NOT NULL,
  `created_user` int NOT NULL,
  PRIMARY KEY (`turf_id`),
  KEY `FK_USER_ID_idx` (`created_user`),
  CONSTRAINT `FK_CREATED_USER_ID` FOREIGN KEY (`created_user`) REFERENCES `users` (`id`)
);


SELECT
    tb.booking_id,
    tb.date,
    tb.time,
    t.image,
    t.details,
    t.created_user,
    u.id,
    u.name,
    u.email,
    u.phonenumber
FROM
    turf_booking AS tb
INNER JOIN
    turf AS t ON tb.turf_id = t.turf_id 
INNER JOIN users as u ON u.id = t.created_user 
	where t.turf_id=71 ;






