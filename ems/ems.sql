CREATE SCHEMA `organization` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE TABLE `organization`.`role` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(75) NOT NULL,
  `slug` VARCHAR(100) NOT NULL,
  `description` TINYTEXT NULL,
  `type` SMALLINT NOT NULL DEFAULT 0,
  `active` TINYINT NOT NULL DEFAULT 0,
  `createdAt` DATETIME NOT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `content` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `uq_slug` (`slug` ASC) );
  
CREATE TABLE `organization`.`permission` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(75) NOT NULL,
  `slug` VARCHAR(100) NOT NULL,
  `description` TINYTEXT NULL,
  `type` SMALLINT NOT NULL DEFAULT 0,
  `active` TINYINT NOT NULL DEFAULT 0,
  `createdAt` DATETIME NOT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `content` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `uq_slug` (`slug` ASC) );
  
CREATE TABLE `organization`.`role_permission` (
  `roleId` BIGINT NOT NULL,
  `permissionId` BIGINT NOT NULL,
  `createdAt` DATETIME NOT NULL,
  `updatedAt` DATETIME NULL,
  PRIMARY KEY (`roleId`, `permissionId`),
  INDEX `idx_rp_role` (`roleId` ASC),
  INDEX `idx_rp_permission` (`permissionId` ASC),
  CONSTRAINT `fk_rp_role`
    FOREIGN KEY (`roleId`)
    REFERENCES `organization`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rp_permission`
    FOREIGN KEY (`permissionId`)
    REFERENCES `organization`.`permission` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE `organization`.`user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `roleId` BIGINT NOT NULL,
  `firstName` VARCHAR(50) NULL DEFAULT NULL,
  `middleName` VARCHAR(50) NULL DEFAULT NULL,
  `lastName` VARCHAR(50) NULL DEFAULT NULL,
  `username` VARCHAR(50) NULL DEFAULT NULL,
  `mobile` VARCHAR(15) NULL,
  `email` VARCHAR(50) NULL,
  `passwordHash` VARCHAR(32) NOT NULL,
  `registeredAt` DATETIME NOT NULL,
  `lastLogin` DATETIME NULL DEFAULT NULL,
  `intro` TINYTEXT NULL DEFAULT NULL,
  `profile` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `uq_username` (`username` ASC),
  UNIQUE INDEX `uq_mobile` (`mobile` ASC),
  UNIQUE INDEX `uq_email` (`email` ASC),
  INDEX `idx_user_role` (`roleId` ASC),
  CONSTRAINT `fk_user_role`
    FOREIGN KEY (`roleId`)
    REFERENCES `organization`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `organization`.`organization` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `createdBy` BIGINT NOT NULL,
  `updatedBy` BIGINT NOT NULL,
  `title` VARCHAR(75) NOT NULL,
  `metaTitle` VARCHAR(100) NULL,
  `slug` VARCHAR(100) NOT NULL,
  `summary` TINYTEXT NULL,
  `status` SMALLINT NOT NULL DEFAULT 0,
  `createdAt` DATETIME NOT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `profile` TEXT NULL DEFAULT NULL,
  `content` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `uq_slug` (`slug` ASC),
  INDEX `idx_organization_creator` (`createdBy` ASC),
  CONSTRAINT `fk_organization_creator`
    FOREIGN KEY (`createdBy`)
    REFERENCES `organization`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `organization`.`organization` 
ADD INDEX `idx_organization_modifier` (`updatedBy` ASC);
ALTER TABLE `organization`.`organization` 
ADD CONSTRAINT `fk_organization_modifier`
  FOREIGN KEY (`updatedBy`)
  REFERENCES `organization`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

CREATE TABLE `organization`.`organization_meta` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `organizationId` BIGINT NOT NULL,
  `key` VARCHAR(50) NOT NULL,
  `content` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_meta_organization` (`organizationId` ASC),
  UNIQUE INDEX `uq_meta_organization` (`organizationId` ASC, `key` ASC),
  CONSTRAINT `fk_meta_organization`
    FOREIGN KEY (`organizationId`)
    REFERENCES `organization`.`organization` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE `organization`.`employee` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `organizationId` BIGINT NOT NULL,
  `userId` BIGINT NOT NULL,
  `roleId` BIGINT NOT NULL,
  `createdBy` BIGINT NOT NULL,
  `updatedBy` BIGINT NOT NULL,
  `code` VARCHAR(100) NOT NULL,
  `status` SMALLINT NOT NULL DEFAULT 0,
  `createdAt` DATETIME NOT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `startsAt` DATETIME NULL DEFAULT NULL,
  `endsAt` DATETIME NULL DEFAULT NULL,
  `notes` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_employee_user` (`userId` ASC),
  CONSTRAINT `fk_employee_user`
    FOREIGN KEY (`userId`)
    REFERENCES `organization`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `organization`.`employee` 
ADD INDEX `idx_employee_organization` (`organizationId` ASC);
ALTER TABLE `organization`.`employee` 
ADD CONSTRAINT `fk_employee_organization`
  FOREIGN KEY (`organizationId`)
  REFERENCES `organization`.`organization` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `organization`.`employee` 
ADD INDEX `idx_employee_role` (`roleId` ASC);
ALTER TABLE `organization`.`employee` 
ADD CONSTRAINT `fk_employee_role`
  FOREIGN KEY (`roleId`)
  REFERENCES `organization`.`role` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `organization`.`employee` 
ADD INDEX `idx_employee_creator` (`createdBy` ASC);
ALTER TABLE `organization`.`employee` 
ADD CONSTRAINT `fk_employee_creator`
  FOREIGN KEY (`createdBy`)
  REFERENCES `organization`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `organization`.`employee` 
ADD INDEX `idx_employee_modifier` (`updatedBy` ASC);
ALTER TABLE `organization`.`employee` 
ADD CONSTRAINT `fk_employee_modifier`
  FOREIGN KEY (`updatedBy`)
  REFERENCES `organization`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;