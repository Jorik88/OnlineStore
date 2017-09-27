CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `department_id` int(11) ,
   PRIMARY KEY (`id`),
   UNIQUE KEY `id_UNIQUE` (`id`),
   KEY `fk_products_1_idx` (`department_id`),
   CONSTRAINT `fk_products_1` FOREIGN KEY (`department_id`)
   REFERENCES `departments` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION)
   ENGINE=InnoDB DEFAULT CHARSET=utf8;