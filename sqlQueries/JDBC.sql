-- corejava database
CREATE DATABASE IF NOT EXISTS corejava;

-- Using the project
USE corejava;

-- Table task
CREATE TABLE IF NOT EXISTS task (
    id int PRIMARY KEY,
    name VARCHAR(30),
    status VARCHAR(20)
);

-- Selecting the all task-table list
SELECT * 
FROM task;

-- Update
update task set name="Drink" where id = 1;
 




