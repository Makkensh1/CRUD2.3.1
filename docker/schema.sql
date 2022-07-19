CREATE TABLE `database_1`.`employee_roles` (
                                               `role_id` BIGINT(255) NOT NULL,
                                               `employee_id` BIGINT(255) NOT NULL,
                                               PRIMARY KEY (`role_id`, `employee_id`),
                                               INDEX `employee_id_idx` (`employee_id` ASC) VISIBLE,
                                               CONSTRAINT `role_id`
                                                   FOREIGN KEY (`role_id`)
                                                       REFERENCES `database_1`.`roles` (`id`)
                                                       ON DELETE NO ACTION
                                                       ON UPDATE NO ACTION,
                                               CONSTRAINT `employee_id`
                                                   FOREIGN KEY (`employee_id`)
                                                       REFERENCES `database_1`.`employees` (`id`)
                                                       ON DELETE NO ACTION
                                                       ON UPDATE NO ACTION);

CREATE TABLE `database_1`.`employees` (
                                          `id` BIGINT(255) NOT NULL AUTO_INCREMENT,
                                          `name` VARCHAR(45) NOT NULL,
                                          `surName` VARCHAR(45) NOT NULL,
                                          `email` VARCHAR(255) NOT NULL,
                                          `password` VARCHAR(255) NOT NULL,
                                          `salary` DOUBLE NOT NULL,
                                          PRIMARY KEY (`id`),
                                          UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                          UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);


CREATE TABLE `database_1`.`roles` (
                                      `id` BIGINT(255) NOT NULL,
                                      `name` VARCHAR(45) NOT NULL,
                                      PRIMARY KEY (`id`));

CREATE TABLE `database_1`.`users` (
                                      `id` BIGINT(255) NOT NULL AUTO_INCREMENT,
                                      `name` VARCHAR(45) NOT NULL,
                                      `surName` VARCHAR(45) NOT NULL,
                                      `email` VARCHAR(255) NOT NULL,
                                      `password` VARCHAR(255) NOT NULL,
                                      `cash` DOUBLE NOT NULL,
                                      PRIMARY KEY (`id`),
                                      UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                      UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);

CREATE TABLE `database_1`.`carts` (
                                     `id` BIGINT(255) NOT NULL AUTO_INCREMENT,
                                     `cartCost` DOUBLE NOT NULL,
                                     `statusPaid` TINYINT NOT NULL DEFAULT 0,
                                     `user_id` BIGINT(255) NOT NULL,
                                     PRIMARY KEY (`id`),
                                     INDEX `users_id_idx` (`user_id` ASC) VISIBLE,
                                     CONSTRAINT `email`
                                         FOREIGN KEY (`user_id`)
                                             REFERENCES `database_1`.`users` (`id`)
                                             ON DELETE CASCADE
                                             ON UPDATE CASCADE);


CREATE TABLE `database_1`.`products` (
                                         `id` BIGINT(255) NOT NULL AUTO_INCREMENT,
                                         `cost` DOUBLE NOT NULL,
                                         `manufacturer` VARCHAR(45) NOT NULL,
                                         `type` VARCHAR(45) NOT NULL,
                                         `paramName` VARCHAR(45) NOT NULL,
                                         `paramValue` VARCHAR(45) NOT NULL,
                                         `stockBalance` BIGINT(255) NOT NULL DEFAULT 0,
                                         PRIMARY KEY (`id`),
                                         UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);

CREATE TABLE `database_1`.`product_list` (
                                             `cart_id` BIGINT NOT NULL,
                                             `product_id` BIGINT NOT NULL,
                                             PRIMARY KEY (`cart_id`, `product_id`),
                                             INDEX `product_id_idx` (`product_id` ASC) VISIBLE,
                                             CONSTRAINT `cart_id`
                                                 FOREIGN KEY (`cart_id`)
                                                     REFERENCES `database_1`.`carts` (`id`)
                                                     ON DELETE CASCADE
                                                     ON UPDATE CASCADE,
                                             CONSTRAINT `product_id`
                                                 FOREIGN KEY (`product_id`)
                                                     REFERENCES `database_1`.`products` (`id`)
                                                     ON DELETE CASCADE
                                                     ON UPDATE CASCADE);

CREATE TABLE `database_1`.`orders` (
                                       `id` BIGINT NOT NULL,
                                       `user_id` BIGINT NOT NULL,
                                       `orderCost` DOUBLE NOT NULL,
                                       `cart_id` BIGINT NOT NULL,
                                       PRIMARY KEY (`id`),
                                       INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
                                       INDEX `cart_id_idx` (`cart_id` ASC) VISIBLE,
                                       CONSTRAINT `user`
                                           FOREIGN KEY (`user_id`)
                                               REFERENCES `database_1`.`users` (`id`)
                                               ON DELETE CASCADE
                                               ON UPDATE CASCADE,
                                       CONSTRAINT `cart`
                                           FOREIGN KEY (`cart_id`)
                                               REFERENCES `database_1`.`carts` (`id`)
                                               ON DELETE CASCADE
                                               ON UPDATE CASCADE);
