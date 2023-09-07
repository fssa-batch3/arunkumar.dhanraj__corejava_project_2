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

-- delete from	 users where name="vinit";

-- Turf 
CREATE TABLE IF NOT EXISTS turf(
turf_id int auto_increment, 
image varchar(500),
details varchar(500),
PRIMARY KEY(turf_id)
);

select * from  turf;

delete from turf where details="Chennai chennai";
-- delete from turf ;

INSERT INTO turf (image,details,created_user) VALUES ("asdasdawsd","casdadas",16);

-- requirement tables 
CREATE TABLE IF NOT EXISTS requirement(
requirement_id int auto_increment, 
message varchar(500),
PRIMARY KEY(requirement_id )
); 

select * from requirement;

-- delete from requirement;