CREATE TABLE `spring-react-graphql`.`Blogs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(400) NOT NULL,
  `views` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `title_UNIQUE` (`title` ASC) VISIBLE);