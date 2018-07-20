/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : rbac

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2018-07-20 21:25:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for delegation
-- ----------------------------
DROP TABLE IF EXISTS `delegation`;
CREATE TABLE `delegation` (
`delegation_id`  int(11) NOT NULL ,
`delegation_user_id`  int(11) NULL DEFAULT NULL ,
`startDate`  date NULL DEFAULT NULL ,
`endDate`  date NULL DEFAULT NULL ,
PRIMARY KEY (`delegation_id`),
FOREIGN KEY (`delegation_user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `delegation_user_id` (`delegation_user_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of delegation
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
`department_id`  int(11) NOT NULL ,
`department_name`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`department_id`),
UNIQUE INDEX `department_id_UNIQUE` (`department_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of department
-- ----------------------------
BEGIN;
INSERT INTO `department` VALUES ('1', '研发部'), ('2', '设计部');
COMMIT;

-- ----------------------------
-- Table structure for department_permission
-- ----------------------------
DROP TABLE IF EXISTS `department_permission`;
CREATE TABLE `department_permission` (
`department_id`  int(11) NULL DEFAULT NULL ,
`permission_id`  int(11) NULL DEFAULT NULL ,
FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`permission_id`) REFERENCES `permission` (`permission_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `department_id` (`department_id`) USING BTREE ,
INDEX `permission_id` (`permission_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of department_permission
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
`permission_id`  int(11) NOT NULL ,
`resource_id`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`permission_id`),
FOREIGN KEY (`resource_id`) REFERENCES `resource` (`resource_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `resource_id` (`resource_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of permission
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
`resource_id`  int(11) NOT NULL ,
`resource_name`  varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`resource_crud`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`resource_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of resource
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
`role_id`  int(11) NOT NULL ,
`role_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`role_id`),
UNIQUE INDEX `role_id_UNIQUE` (`role_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES ('1', '总经理'), ('2', '副经理');
COMMIT;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
`role_id`  int(11) NULL DEFAULT NULL ,
`permission_id`  int(11) NULL DEFAULT NULL ,
FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`permission_id`) REFERENCES `permission` (`permission_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `role_id` (`role_id`) USING BTREE ,
INDEX `permission_id` (`permission_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`user_id`  int(11) NOT NULL ,
`user_name`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`user_gender`  varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`user_email`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`user_phone`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`user_address`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`user_birthday`  date NULL DEFAULT NULL ,
`department_id`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`user_id`),
FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
UNIQUE INDEX `use_idr_UNIQUE` (`user_id`) USING BTREE ,
INDEX `department_id` (`department_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('101', 'mike', 'male', 'axxxx@163.com', '183xxxxxxxx', 'chengdu', '2017-01-19', '1'), ('102', 'mao', 'female', 'xxxx@163.com', '183xxxxxx', 'chengdu', '2017-01-20', '1'), ('103', 'huang', 'male', 'axxxx@163.com', '183xxxxxxxx', 'chengdu', '2017-01-24', null);
COMMIT;

-- ----------------------------
-- Table structure for user_delegation
-- ----------------------------
DROP TABLE IF EXISTS `user_delegation`;
CREATE TABLE `user_delegation` (
`user_id`  int(11) NULL DEFAULT NULL ,
`delegation_id`  int(11) NULL DEFAULT NULL ,
FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`delegation_id`) REFERENCES `delegation` (`delegation_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `user_id` (`user_id`) USING BTREE ,
INDEX `delegation_id` (`delegation_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of user_delegation
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user_department
-- ----------------------------
DROP TABLE IF EXISTS `user_department`;
CREATE TABLE `user_department` (
`user_id`  int(11) NULL DEFAULT NULL ,
`department_id`  int(11) NULL DEFAULT NULL ,
FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `user_id` (`user_id`) USING BTREE ,
INDEX `department_id` (`department_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of user_department
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
`user_id`  int(11) NULL DEFAULT NULL ,
`role_id`  int(11) NULL DEFAULT NULL ,
FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `user_id` (`user_id`) USING BTREE ,
INDEX `role_id` (`role_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN;
INSERT INTO `user_role` VALUES ('101', '1'), ('101', '2');
COMMIT;
