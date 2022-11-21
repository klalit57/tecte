drop database if exists techblog; 

create database techblog;

use techblog;

CREATE TABLE `techblog`.`user` (
  `userId` INT(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(500) NOT NULL,
  `email` VARCHAR(500) NOT NULL unique,
  `password` VARCHAR(500) NOT NULL,
  `gender` VARCHAR(10) NOT NULL,
  `about` VARCHAR(100) NULL DEFAULT 'hey! I am using  Tech Blog',
  `rdate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `profile` VARCHAR(100) NULL DEFAULT 'default.png',
  PRIMARY KEY (`userId`),
  INDEX `email_id` (`email` ASC) VISIBLE
  );
  
  
  CREATE TABLE `techblog`.`categories` (
  `cId` INT(2) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `description` VARCHAR(200) NULL,
  PRIMARY KEY (`cId`));
  
  CREATE TABLE `techblog`.`posts` (
  `pId` INT(10) NOT NULL AUTO_INCREMENT,
  `pTitle` VARCHAR(150) NOT NULL,
  `pContent` LONGTEXT NULL,
  `pCode` LONGTEXT NULL,
  `pPic` VARCHAR(100) NULL,
  `pDate` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  `c_Id` INT(2) NULL,
  `u_Id` INT(10) NULL,
  PRIMARY KEY (`pId`),
  INDEX `u_Id_idx` (`u_Id` ASC) VISIBLE,
  INDEX `c_Id_idx` (`c_Id` ASC) VISIBLE,
  CONSTRAINT `u_Id`
    FOREIGN KEY (`u_Id`)
    REFERENCES `techblog`.`user` (`userId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    
    CONSTRAINT `c_Id`
    FOREIGN KEY (`c_Id`)
    REFERENCES `techblog`.`categories` (`cId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
   
INSERT INTO `techblog`.`categories` (`name`, `description`) VALUES ('java programming', 'java is one of the most popular programming language');
INSERT INTO `techblog`.`categories` (`name`, `description`) VALUES ('python programming', 'java is one the most popularlaguage for Machine learning');
INSERT INTO `techblog`.`categories` (`name`, `description`) VALUES ('Web technolgy', 'Used mostly for Website and web appication');

    
  ALTER TABLE `techblog`.`posts` 
DROP FOREIGN KEY `u_Id`;
ALTER TABLE `techblog`.`posts` 
CHANGE COLUMN `u_Id` `u_Id` INT NOT NULL ;
ALTER TABLE `techblog`.`posts` 
ADD CONSTRAINT `u_Id`
  FOREIGN KEY (`u_Id`)
  REFERENCES `techblog`.`user` (`userId`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
commit;

