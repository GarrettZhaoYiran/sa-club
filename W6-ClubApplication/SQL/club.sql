CREATE SCHEMA club;
CREATE TABLE `club`.`member` (
  `memberNumber` INT NOT NULL,
  `pid` INT NULL,
  `surname` VARCHAR(45) NULL,
  `firstName` VARCHAR(45) NULL,
  `secondName` VARCHAR(45) NULL,
  PRIMARY KEY (`memberNumber`));
  
INSERT INTO `club`.`member` (`memberNumber`, `pid`, `surname`, `firstName`, `secondName`) VALUES (1,1, "Einstein", "Albert", null);
INSERT INTO `club`.`member` (`memberNumber`, `pid`, `surname`, `firstName`, `secondName`) VALUES (2,2, "Picasso", "Pablo", "Ruiz");
INSERT INTO `club`.`member` (`memberNumber`, `pid`, `surname`, `firstName`, `secondName`) VALUES (3,3, "Webber", "Andrew", "Lloyd");
INSERT INTO `club`.`member` (`memberNumber`, `pid`, `surname`, `firstName`, `secondName`) VALUES (4,4, "Baggio", "Roberto", null);
INSERT INTO `club`.`member` (`memberNumber`, `pid`, `surname`, `firstName`, `secondName`) VALUES (5,5, "Raffles", "Stamford", null);

CREATE TABLE `club`.`facility` (
  `fid` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`fid`));

INSERT INTO `club`.`facility` (`fid`, `name`, `description`) VALUES (1, "Room1", "Conference Room on Level 2");
INSERT INTO `club`.`facility` (`fid`, `name`, `description`) VALUES (2, "Room2", "Meeting Room on Level 3");
