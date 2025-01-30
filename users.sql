-- -------------------------------------------------------------
-- -------------------------------------------------------------
-- TablePlus 1.2.2
--
-- https://tableplus.com/
--
-- Database: app
-- Generation Time: 2025-01-27 19:54:08.964594
-- -------------------------------------------------------------

DROP TABLE IF EXISTS `app`.`users`;


CREATE TABLE `users` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `app`.`users` (`id`, `last_name`, `first_name`, `email`, `password`) VALUES (1, 'test', 'test', 'test@test.com', 'secure');

