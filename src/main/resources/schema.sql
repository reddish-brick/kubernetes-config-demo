DROP DATABASE IF EXISTS kubernetes_demo;
CREATE DATABASE IF NOT EXISTS kubernetes_demo DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `kubernetes_demo`;

CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `address` varchar(1000) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;