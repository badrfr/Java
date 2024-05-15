-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema inventory
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `inventory` ;

-- -----------------------------------------------------
-- Schema inventory
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `inventory` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `inventory` ;

-- -----------------------------------------------------
-- Table `inventory`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inventory`.`customer` ;

CREATE TABLE IF NOT EXISTS `inventory`.`customer` (
  `customer_id` DECIMAL(5,0) NOT NULL,
  `cust_name` VARCHAR(30) NULL DEFAULT NULL,
  `city` VARCHAR(15) NULL DEFAULT NULL,
  `grade` DECIMAL(3,0) NULL DEFAULT NULL,
  `salesman_id` DECIMAL(5,0) NULL DEFAULT NULL,
  PRIMARY KEY (`customer_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `inventory`.`salesman`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inventory`.`salesman` ;

CREATE TABLE IF NOT EXISTS `inventory`.`salesman` (
  `salesman_id` DECIMAL(5,0) NOT NULL,
  `name` VARCHAR(30) NULL DEFAULT NULL,
  `city` VARCHAR(15) NULL DEFAULT NULL,
  `commission` DECIMAL(5,2) NULL DEFAULT NULL,
  PRIMARY KEY (`salesman_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `inventory`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inventory`.`orders` ;

CREATE TABLE IF NOT EXISTS `inventory`.`orders` (
  `ord_no` DECIMAL(5,0) NOT NULL,
  `purch_amt` DECIMAL(8,2) NULL DEFAULT NULL,
  `ord_date` DATE NULL DEFAULT NULL,
  `customer_id` DECIMAL(5,0) NULL DEFAULT NULL,
  `salesman_id` DECIMAL(5,0) NULL DEFAULT NULL,
  PRIMARY KEY (`ord_no`),
  INDEX `fk_salesman_id` (`salesman_id` ASC) VISIBLE,
  INDEX `fk_customer_id` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `fk_customer_id`
    FOREIGN KEY (`customer_id`)
    REFERENCES `inventory`.`customer` (`customer_id`),
  CONSTRAINT `fk_salesman_id`
    FOREIGN KEY (`salesman_id`)
    REFERENCES `inventory`.`salesman` (`salesman_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-----
-- insert statments
----
INSERT INTO `customer` VALUES (3001,'Brad Guzan','London',NULL,5005),(3002,'Nick Rimando','New York',100,5001),(3003,'Jozy Altidor','Moncow',200,5007),(3004,'Fabian Johns','Paris',300,5006),(3005,'Graham Zusi','California',200,5002),(3007,'Brad Davis','New York',200,5001),(3008,'Julian Green','London',300,5002),(3009,'Geoff Camero','Berlin',100,5003);
INSERT INTO `orders` VALUES (70001,150.50,'2012-10-05',3005,5002),(70002,65.26,'2012-10-05',3002,5001),(70003,2480.40,'2012-10-10',3009,5003),(70004,110.50,'2012-08-17',3009,5003),(70005,2400.60,'2012-07-27',3007,5001),(70007,948.50,'2012-09-10',3005,5002),(70008,5760.00,'2012-09-10',3002,5001),(70009,270.65,'2012-09-10',3001,5005),(70010,1983.43,'2012-10-10',3004,5006),(70011,75.29,'2012-08-17',3003,5007),(70012,250.45,'2012-06-27',3008,5002),(70013,3045.60,'2012-04-25',3002,5001);
INSERT INTO `salesman` VALUES (5001,'James Hoog','New York',0.15),(5002,'Nail Knite','Paris',0.13),(5003,'Lauson Hen','',0.12),(5005,'Pit Alex','London',0.11),(5006,'Mc Lyon','Paris',0.14),(5007,'Paul Adam','Rome',0.13);

