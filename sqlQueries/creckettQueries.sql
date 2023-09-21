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

-- turf booking 
CREATE TABLE `arunkumar_dhanraj_corejava_project`.`turf_booking` (
  `booking_id` INT NOT NULL,
  `turf_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `date` DATE NOT NULL,
  `time` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`booking_id`),
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
