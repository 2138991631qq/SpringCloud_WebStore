/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50128
Source Host           : localhost:3306
Source Database       : b2bgoods

Target Server Type    : MYSQL
Target Server Version : 50128
File Encoding         : 65001

Date: 2022-05-29 11:25:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsname` varchar(255) NOT NULL,
  `number` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `goodid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `gid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gname` varchar(255) NOT NULL COMMENT '商品名称',
  `gremain` varchar(255) NOT NULL COMMENT '商品图片地址',
  `gdetails` varchar(255) NOT NULL COMMENT '商品介绍',
  `gprice` int(11) NOT NULL COMMENT '商品价格',
  `types` int(64) NOT NULL COMMENT '商品类别',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('2', '苹果', 'http://localhost:8894/b2b-goods-consumer/templates/img/2.jpg', '红富士苹果', '2', '0');
INSERT INTO `goods` VALUES ('3', '橙子', 'http://localhost:8894/b2b-goods-consumer/templates/img/goods/goods001.jpg', '金黄的大橙子', '4', '0');
INSERT INTO `goods` VALUES ('4', '葡萄', 'http://localhost:8894/b2b-goods-consumer/templates/img/goods/goods002.jpg', '吐鲁番葡萄', '12', '0');
INSERT INTO `goods` VALUES ('5', '大虾', 'http://localhost:8894/b2b-goods-consumer/templates/img/goods/goods018.jpg', '山东大虾', '4', '2');
INSERT INTO `goods` VALUES ('6', '带鱼', 'http://localhost:8894/goods-consumer/templates/img/goods/goods020.jpg', '好吃的带鱼', '50', '2');
INSERT INTO `goods` VALUES ('7', '扇贝', 'http://localhost:8894/goods-consumer/templates/img/goods/goods019.jpg', '大神快来快来', '20', '2');
INSERT INTO `goods` VALUES ('8', '皮皮虾', 'http://localhost:8894/goods-consumer/templates/img/goods/goods021.jpg', '啥的客户', '10', '2');
INSERT INTO `goods` VALUES ('9', '脉动', 'http://localhost:8894/goods-consumer/templates/img/goods/maidong.png', '不在状态，脉动一下', '4', '1');
INSERT INTO `goods` VALUES ('10', '汽水', 'http://localhost:8894/goods-consumer/templates/img/goods/qishui.png', '栓双', '8', '1');
INSERT INTO `goods` VALUES ('11', '沙棘汁', 'http://localhost:8894/goods-consumer/templates/img/goods/shajizhi.png', '好喝', '3', '1');
INSERT INTO `goods` VALUES ('12', '和其正', 'http://localhost:8894/goods-consumer/templates/img/goods/heqizheng.png', 'dsa asd', '5', '1');
INSERT INTO `goods` VALUES ('13', '菠菜', 'http://localhost:8894/goods-consumer/templates/img/goods/bocai.png', '大', '2', '3');
INSERT INTO `goods` VALUES ('14', '生菜', 'http://localhost:8894/goods-consumer/templates/img/goods/shengcai.png', 'asdajlskdja', '2', '3');
INSERT INTO `goods` VALUES ('15', '番茄', 'http://localhost:8894/goods-consumer/templates/img/goods/fanqie.png', '好吃', '1', '3');
INSERT INTO `goods` VALUES ('16', '胡萝卜', 'http://localhost:8894/goods-consumer/templates/img/goods/huluobo.png', 'asdkjlajkld', '2', '3');
INSERT INTO `goods` VALUES ('17', '西红柿', '123', '西红柿', '3', '4');
INSERT INTO `goods` VALUES ('18', 'kdy', 'kk', 'dd', '2', '4');
INSERT INTO `goods` VALUES ('20', 'ddd', 'sdd', 'sad', '1', '4');
INSERT INTO `goods` VALUES ('21', 's', 's', 's', '1', '4');
INSERT INTO `goods` VALUES ('22', '3', '4', '6', '7', '4');
INSERT INTO `goods` VALUES ('23', '4', '5', '5', '5', '4');
INSERT INTO `goods` VALUES ('24', '5', '5', '5', '5', '4');
INSERT INTO `goods` VALUES ('25', '6', '6', '6', '6', '4');
INSERT INTO `goods` VALUES ('26', '4', '4', '5', '5', '4');
INSERT INTO `goods` VALUES ('27', '5', '5', '5', '5', '4');
INSERT INTO `goods` VALUES ('28', 'aa', 'aa', 'aa', '2', '4');
INSERT INTO `goods` VALUES ('29', 'kdy', 'http://localhost:8894/goods-consumer/templates/img/rotPhoto/1.jpg', '灰太狼', '6', '4');
INSERT INTO `goods` VALUES ('30', '可达鸭', 'http://localhost:8894/goods-consumer/templates/img/rotPhoto/7e58db4c442cc33e1dba1c184012fe6.jpg', '可达鸭', '66', '4');
INSERT INTO `goods` VALUES ('31', 'kedaya', 'http://localhost:8894/goods-consumer/templates/img/rotPhoto/7e58db4c442cc33e1dba1c184012fe6.jpg', 'kedaya', '54', '4');

-- ----------------------------
-- Table structure for goods_copy
-- ----------------------------
DROP TABLE IF EXISTS `goods_copy`;
CREATE TABLE `goods_copy` (
  `gid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gname` varbinary(255) NOT NULL COMMENT '商品名称',
  `gremain` varchar(255) NOT NULL COMMENT '商品图片地址',
  `gdetails` varbinary(255) NOT NULL COMMENT '商品介绍',
  `gprice` int(11) NOT NULL COMMENT '商品价格',
  `types` int(64) NOT NULL COMMENT '商品类别',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_copy
-- ----------------------------
INSERT INTO `goods_copy` VALUES ('1', 0xB2DDDDAE, 'http://localhost:8894/b2b-goods-consumer/templates/img/goods/goods003.jpg', 0xBFC9BFDAB2DDDDAE, '4', '0');
INSERT INTO `goods_copy` VALUES ('2', 0xC6BBB9FB, 'http://localhost:8894/b2b-goods-consumer/templates/img/2.jpg', 0xBAECB8BBCABFC6BBB9FB, '2', '0');
INSERT INTO `goods_copy` VALUES ('3', 0xB3C8D7D3, 'http://localhost:8894/b2b-goods-consumer/templates/img/goods/goods001.jpg', 0xBDF0BBC6B5C4B4F3B3C8D7D3, '4', '0');
INSERT INTO `goods_copy` VALUES ('4', 0xC6CFCCD1, 'http://localhost:8894/b2b-goods-consumer/templates/img/goods/goods002.jpg', 0xCDC2C2B3B7ACC6CFCCD1, '12', '0');
INSERT INTO `goods_copy` VALUES ('5', 0xB4F3CFBA, 'http://localhost:8894/b2b-goods-consumer/templates/img/goods/goods018.jpg', 0xC9BDB6ABB4F3CFBA, '5', '2');
INSERT INTO `goods_copy` VALUES ('6', 0xB4F8D3E3, 'http://localhost:8894/goods-consumer/templates/img/goods/goods020.jpg', 0xBAC3B3D4B5C4B4F8D3E3, '50', '2');
INSERT INTO `goods_copy` VALUES ('7', 0xC9C8B1B4, 'http://localhost:8894/goods-consumer/templates/img/goods/goods019.jpg', 0xB4F3C9F1BFECC0B4BFECC0B4, '20', '2');
INSERT INTO `goods_copy` VALUES ('8', 0xC6A4C6A4CFBA, 'http://localhost:8894/goods-consumer/templates/img/goods/goods021.jpg', 0xC9B6B5C4BFCDBBA7, '10', '2');
INSERT INTO `goods_copy` VALUES ('9', 0xC2F6B6AF, 'http://localhost:8894/goods-consumer/templates/img/goods/maidong.png', 0xB2BBD4DAD7B4CCACA3ACC2F6B6AFD2BBCFC2, '4', '1');
INSERT INTO `goods_copy` VALUES ('10', 0xC6FBCBAE, 'http://localhost:8894/goods-consumer/templates/img/goods/qishui.png', 0xCBA8CBAB, '8', '1');
INSERT INTO `goods_copy` VALUES ('11', 0xC9B3BCACD6AD, 'http://localhost:8894/goods-consumer/templates/img/goods/shajizhi.png', 0xBAC3BAC8, '3', '1');
INSERT INTO `goods_copy` VALUES ('12', 0xBACDC6E4D5FD, 'http://localhost:8894/goods-consumer/templates/img/goods/heqizheng.png', 0x64736120617364, '5', '1');
INSERT INTO `goods_copy` VALUES ('13', 0xB2A4B2CB, 'http://localhost:8894/goods-consumer/templates/img/goods/bocai.png', 0xB4F3, '2', '3');
INSERT INTO `goods_copy` VALUES ('14', 0xC9FAB2CB, 'http://localhost:8894/goods-consumer/templates/img/goods/shengcai.png', 0x617364616A6C736B646A61, '2', '3');
INSERT INTO `goods_copy` VALUES ('15', 0xB7ACC7D1, 'http://localhost:8894/goods-consumer/templates/img/goods/fanqie.png', 0xBAC3B3D4, '1', '3');
INSERT INTO `goods_copy` VALUES ('16', 0xBAFAC2DCB2B7, 'http://localhost:8894/goods-consumer/templates/img/goods/huluobo.png', 0x6173646B6A6C616A6B6C64, '2', '3');

-- ----------------------------
-- Table structure for userorder
-- ----------------------------
DROP TABLE IF EXISTS `userorder`;
CREATE TABLE `userorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `goodsname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '商品名称',
  `number` int(11) NOT NULL COMMENT '购买数量',
  `price` int(11) NOT NULL COMMENT '总价',
  `time` datetime NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=191 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userorder
-- ----------------------------
INSERT INTO `userorder` VALUES ('154', '脉动', '1', '4', '2022-05-17 09:02:07', '10027');
INSERT INTO `userorder` VALUES ('155', '生菜', '1', '2', '2022-05-20 09:14:18', '10027');
INSERT INTO `userorder` VALUES ('156', '汽水', '1', '8', '2022-05-20 14:57:55', '10027');
INSERT INTO `userorder` VALUES ('157', '脉动', '1', '4', '2022-05-20 14:57:55', '10027');
INSERT INTO `userorder` VALUES ('158', '沙棘汁', '1', '3', '2022-05-20 14:57:55', '10027');
INSERT INTO `userorder` VALUES ('159', '扇贝', '1', '20', '2022-05-20 15:30:06', '10027');
INSERT INTO `userorder` VALUES ('160', '脉动', '1', '4', '2022-05-20 15:30:06', '10027');
INSERT INTO `userorder` VALUES ('161', '带鱼', '1', '50', '2022-05-20 15:30:24', '10027');
INSERT INTO `userorder` VALUES ('162', '脉动', '1', '4', '2022-05-20 15:54:08', '10027');
INSERT INTO `userorder` VALUES ('163', '脉动', '8', '32', '2022-05-20 15:54:08', '10027');
INSERT INTO `userorder` VALUES ('164', '菠菜', '3', '6', '2022-05-20 15:54:08', '10027');
INSERT INTO `userorder` VALUES ('165', '生菜', '3', '6', '2022-05-20 15:54:08', '10027');
INSERT INTO `userorder` VALUES ('166', '扇贝', '6', '120', '2022-05-20 15:54:08', '10027');
INSERT INTO `userorder` VALUES ('167', '皮皮虾', '8', '80', '2022-05-20 15:54:08', '10027');
INSERT INTO `userorder` VALUES ('168', '菠菜', '1', '2', '2022-05-21 10:33:31', '10027');
INSERT INTO `userorder` VALUES ('169', '脉动', '1', '4', '2022-05-21 10:42:40', '10027');
INSERT INTO `userorder` VALUES ('170', '扇贝', '1', '20', '2022-05-21 10:42:40', '10027');
INSERT INTO `userorder` VALUES ('171', '脉动', '1', '4', '2022-05-21 15:44:34', '10033');
INSERT INTO `userorder` VALUES ('172', '脉动', '1', '4', '2022-05-22 09:58:01', '10027');
INSERT INTO `userorder` VALUES ('173', '脉动', '3', '12', '2022-05-25 19:50:47', '10027');
INSERT INTO `userorder` VALUES ('174', '脉动', '1', '4', '2022-05-26 14:30:38', '10027');
INSERT INTO `userorder` VALUES ('175', '可达鸭', '5', '330', '2022-05-26 14:30:38', '10027');
INSERT INTO `userorder` VALUES ('176', 'kdy', '3', '18', '2022-05-26 14:30:38', '10027');
INSERT INTO `userorder` VALUES ('177', '扇贝', '2', '40', '2022-05-26 14:30:38', '10027');
INSERT INTO `userorder` VALUES ('178', '皮皮虾', '3', '30', '2022-05-26 14:30:38', '10027');
INSERT INTO `userorder` VALUES ('179', '生菜', '2', '4', '2022-05-26 14:30:38', '10027');
INSERT INTO `userorder` VALUES ('180', '菠菜', '2', '4', '2022-05-26 14:30:38', '10027');
INSERT INTO `userorder` VALUES ('181', '带鱼', '2', '100', '2022-05-26 14:30:38', '10027');
INSERT INTO `userorder` VALUES ('182', '和其正', '3', '15', '2022-05-26 14:30:38', '10027');
INSERT INTO `userorder` VALUES ('183', '脉动', '4', '16', '2022-05-26 14:38:10', '10027');
INSERT INTO `userorder` VALUES ('184', '汽水', '3', '24', '2022-05-26 14:54:49', '10027');
INSERT INTO `userorder` VALUES ('185', '和其正', '5', '25', '2022-05-26 14:54:49', '10027');
INSERT INTO `userorder` VALUES ('186', '皮皮虾', '5', '50', '2022-05-26 14:54:49', '10027');
INSERT INTO `userorder` VALUES ('187', '生菜', '4', '8', '2022-05-26 14:54:50', '10027');
INSERT INTO `userorder` VALUES ('188', '脉动', '3', '12', '2022-05-27 20:16:43', '10027');
INSERT INTO `userorder` VALUES ('189', '汽水', '3', '24', '2022-05-27 20:16:43', '10027');
INSERT INTO `userorder` VALUES ('190', '和其正', '3', '15', '2022-05-27 20:16:43', '10027');
