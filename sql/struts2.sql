CREATE DATABASE IF NOT EXISTS `data1` 
USE `data1`;

CREATE TABLE IF NOT EXISTS `test1` (
  `id` varchar(20) NOT NULL DEFAULT '',
  `name` varchar(20) NOT NULL DEFAULT '',
  `memo` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

