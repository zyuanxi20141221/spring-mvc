CREATE DATABASE db_spring_mvc;

USE db_spring_mvc;

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE sys_role
(
    `id`       INT AUTO_INCREMENT NOT NULL,
    `roleName` VARCHAR(50),
    `roleDesc` VARCHAR(200),
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user`
(
    `id`       INT AUTO_INCREMENT NOT NULL,
    `username` VARCHAR(50)        NOT NULL,
    `email`    VARCHAR(50),
    `password` VARCHAR(200)       NOT NULL,
    `phoneNum` VARCHAR(20),
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE sys_user_role
(
    `id`     INT AUTO_INCREMENT NOT NULL,
    `userId` INT                NOT NULL,
    `roleId` INT                NOT NULL,

    PRIMARY KEY (`id`),

    CONSTRAINT `sys_user_role_fk1` FOREIGN KEY (`userId`) references `sys_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `sys_user_role_fk2` FOREIGN KEY (`roleId`) references `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)




