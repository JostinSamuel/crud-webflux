CREATE TABLE IF NOT EXISTS `product`
( 
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT , 
    `name` VARCHAR(10) NOT NULL , 
    `price` FLOAT NOT NULL , 
    PRIMARY KEY (`id`), UNIQUE 
    `name_unique` (`name`)
) ENGINE = InnoDB;