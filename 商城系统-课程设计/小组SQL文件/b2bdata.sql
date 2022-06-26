/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50128
Source Host           : localhost:3306
Source Database       : b2bdata

Target Server Type    : MYSQL
Target Server Version : 50128
File Encoding         : 65001

Date: 2022-05-29 10:58:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `grade` float DEFAULT NULL,
  `grender` char(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'dsad', '2', '男');
INSERT INTO `student` VALUES ('2', 'sda', '2', '女');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uaccount` int(11) NOT NULL AUTO_INCREMENT COMMENT '账号',
  `upassword` varbinary(255) NOT NULL COMMENT '密码',
  `uname` varbinary(255) NOT NULL COMMENT '姓名',
  `usex` varbinary(50) NOT NULL COMMENT '性别',
  PRIMARY KEY (`uaccount`)
) ENGINE=InnoDB AUTO_INCREMENT=10034 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10018', 0x61646D696E, 0x61646D696E, 0xE794B7);
INSERT INTO `user` VALUES ('10019', 0x31, 0x77616E676A696E, 0x31);
INSERT INTO `user` VALUES ('10020', 0x313233, 0xE78E8BE4B889, 0xE794B7);
INSERT INTO `user` VALUES ('10021', 0x31, 0xE68891, 0xE794B7);
INSERT INTO `user` VALUES ('10022', 0x31, 0x31323131, 0xE79A84);
INSERT INTO `user` VALUES ('10023', 0x32, 0x77686868, 0x6E616E);
INSERT INTO `user` VALUES ('10024', 0x31, 0x77686868, 0x6E616E);
INSERT INTO `user` VALUES ('10025', 0x31, 0x6868, 0x6E616E);
INSERT INTO `user` VALUES ('10026', 0x313233, 0x313233, 0x313233);
INSERT INTO `user` VALUES ('10027', 0x323232, 0x3232, 0x31);
INSERT INTO `user` VALUES ('10028', 0x313233, 0x313233, 0x31);
