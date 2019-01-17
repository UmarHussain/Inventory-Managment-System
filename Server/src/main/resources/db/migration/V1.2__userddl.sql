CREATE TABLE `user_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_role` VARCHAR(45) NOT NULL,
  `enabled` BIT(1) NOT NULL,
  `created_time` TIMESTAMP(2) NULL,
  `updated_time` TIMESTAMP(2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `created_time` TIMESTAMP(2) NULL,
  `updated_time` TIMESTAMP(2) NULL,
  `enabled` BIT(1) NOT NULL,
  `user_role_id` INT NOT NULL,
  PRIMARY KEY (`id`, `user_role_id`),
  UNIQUE INDEX `user_name_UNIQUE` (`user_name` ASC),
  INDEX `fk_user_user_role1_idx` (`user_role_id` ASC),
  CONSTRAINT `fk_user_user_role1`
    FOREIGN KEY (`user_role_id`)
    REFERENCES `user_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;