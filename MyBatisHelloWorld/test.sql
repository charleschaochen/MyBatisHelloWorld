/*
Navicat MySQL Data Transfer

Source Server         : charles
Source Server Version : 50534
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2014-07-05 12:09:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(10) NOT NULL,
  `role_level` smallint(6) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', '0');
INSERT INTO `role` VALUES ('2', 'superuser', '1');
INSERT INTO `role` VALUES ('3', 'visitor', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `passwd` varchar(20) NOT NULL,
  `role_id` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pk_user_role` (`role_id`),
  CONSTRAINT `pk_user_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('6', 'admin', 'admin', '1');
INSERT INTO `user` VALUES ('7', 'admin', 'admin', '1');
INSERT INTO `user` VALUES ('8', 'admin', 'admin', '1');
INSERT INTO `user` VALUES ('9', 'admin', 'admin', '1');
INSERT INTO `user` VALUES ('10', 'admin', 'admin', '1');
INSERT INTO `user` VALUES ('11', 'admin', 'admin', '1');
