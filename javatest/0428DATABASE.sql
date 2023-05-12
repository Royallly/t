DROP DATABASE IF EXISTS `companydata`;

CREATE DATABASE `companydata`;

USE `companydata`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'ユーザーID',
  `username` VARCHAR(255) NOT NULL COMMENT 'ユーザーネーム',
  `password` VARCHAR(255) NOT NULL COMMENT 'パスワード',
  PRIMARY KEY (`id`));

INSERT INTO `user` SET `username` = 'SU', `password` = 'softusing';