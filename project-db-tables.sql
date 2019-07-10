-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema sample
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sample
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sample` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
-- -----------------------------------------------------
-- Schema project_management
-- -----------------------------------------------------
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user_account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user_account` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Project` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `project_description` VARCHAR(333) NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`task` (
  `id` INT NOT NULL,
  `name` VARCHAR(333) NOT NULL,
  `description` VARCHAR(45) NULL,
  `start_date` DATE NOT NULL,
  `project_id` INT NULL,
  `end_date` DATE NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Sub_task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Sub_task` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `priority` INT NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `project_id` INT NULL,
  `task_id` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`assigned`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`assigned` (
  `project_id` INT NOT NULL,
  `user_account_id` INT NOT NULL,
  `sub_id` INT NOT NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Role` (
  `role_id` INT NOT NULL,
  `role_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `first_name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `contact` INT(10) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `address` VARCHAR(300) NULL,
  `user_account_id` INT NULL)
ENGINE = InnoDB;

USE `sample` ;

-- -----------------------------------------------------
-- Table `sample`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sample`.`customer` (
  `id` INT(11) NULL DEFAULT NULL,
  `name` VARCHAR(20) NULL DEFAULT NULL,
  `amount` INT(11) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sample`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sample`.`department` (
  `department_id` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`department_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sample`.`employeeio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sample`.`employeeio` (
  `id` INT(11) NULL DEFAULT NULL,
  `name` VARCHAR(40) NULL DEFAULT NULL,
  `salary` INT(11) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sample`.`employees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sample`.`employees` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(65) NULL DEFAULT NULL,
  `last_name` VARCHAR(65) NULL DEFAULT NULL,
  `salary` INT(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sample`.`login_maven`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sample`.`login_maven` (
  `username` VARCHAR(100) NULL DEFAULT NULL,
  `password` VARCHAR(80) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sample`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sample`.`student` (
  `id` INT(11) NULL DEFAULT NULL,
  `first_name` VARCHAR(32) NULL DEFAULT NULL,
  `last_name` VARCHAR(43) NULL DEFAULT NULL,
  `age` INT(11) NULL DEFAULT NULL,
  UNIQUE INDEX `index_new` (`first_name` ASC) VISIBLE,
  INDEX `index_student` (`first_name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sample`.`student_hibernate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sample`.`student_hibernate` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NULL DEFAULT NULL,
  `last_name` VARCHAR(100) NULL DEFAULT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sample`.`studentspringmvc`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sample`.`studentspringmvc` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(40) NULL DEFAULT NULL,
  `last_name` VARCHAR(40) NULL DEFAULT NULL,
  `language` VARCHAR(30) NULL DEFAULT NULL,
  `country` VARCHAR(40) NULL DEFAULT NULL,
  `operatingsystem` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sample`.`userdetail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sample`.`userdetail` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `uname` VARCHAR(80) NULL DEFAULT NULL,
  `password` VARCHAR(20) NULL DEFAULT NULL,
  `utype` VARCHAR(40) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
