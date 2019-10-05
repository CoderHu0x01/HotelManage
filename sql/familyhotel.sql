/*
Navicat MySQL Data Transfer

Source Server         : familyhotel
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : familyhotel

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-06-26 14:06:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_bill
-- ----------------------------
DROP TABLE IF EXISTS `tb_bill`;
CREATE TABLE `tb_bill` (
  `billID` int(11) NOT NULL AUTO_INCREMENT,
  `billNo` varchar(50) DEFAULT NULL,
  `expendPrice` decimal(10,0) DEFAULT NULL,
  `expendTime` datetime DEFAULT NULL,
  `tallyPeople` varchar(20) DEFAULT NULL,
  `rebate` int(11) DEFAULT NULL,
  `guestNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`billID`),
  KEY `FK_Reference_5` (`guestNo`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`guestNo`) REFERENCES `tb_guest` (`guestNo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_bill
-- ----------------------------
INSERT INTO `tb_bill` VALUES ('1', '170626134736', null, null, null, null, null);

-- ----------------------------
-- Table structure for tb_guest
-- ----------------------------
DROP TABLE IF EXISTS `tb_guest`;
CREATE TABLE `tb_guest` (
  `guestNo` int(11) NOT NULL AUTO_INCREMENT,
  `guestName` varchar(10) DEFAULT NULL,
  `gender` varchar(5) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `credeType` varchar(10) DEFAULT NULL,
  `crederNum` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `guestType` varchar(10) DEFAULT NULL,
  `collectPrice` decimal(10,0) DEFAULT NULL,
  `realCash` decimal(10,0) DEFAULT NULL,
  `guestRemark` text,
  `roomNo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`guestNo`),
  KEY `fk_guest` (`roomNo`),
  CONSTRAINT `fk_guest` FOREIGN KEY (`roomNo`) REFERENCES `tb_roominfo` (`roomNo`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_guest
-- ----------------------------
INSERT INTO `tb_guest` VALUES ('19', '张三', '男', null, '学生证', '4203689', '湖北十堰', '会员宾客', null, '2000', '66666', null);
INSERT INTO `tb_guest` VALUES ('20', 'hu', '男', null, '身份证', '12345', '湖北', '普通宾客', null, '300', '号', null);
INSERT INTO `tb_guest` VALUES ('21', '李四', '男', null, '身份证', '5555', '好得', '普通宾客', null, '400', 'ok', null);
INSERT INTO `tb_guest` VALUES ('22', 'gh', '男', null, '身份证', '8888', '倍', '普通宾客', null, '300', '主', null);
INSERT INTO `tb_guest` VALUES ('23', '王五', '男', null, '身份证', '420683111', '湖北襄阳', '普通宾客', null, '900', '66', null);
INSERT INTO `tb_guest` VALUES ('24', '小飞', '男', null, '身份证', '1211212', '4545', '普通宾客', null, '1222', '22', 'BD10010');
INSERT INTO `tb_guest` VALUES ('25', '5好', '男', null, '身份证', '877875', '而突然抬头人', '普通宾客', null, '200', '颠三倒四', null);
INSERT INTO `tb_guest` VALUES ('26', '地方', '男', null, '身份证', '789454', '地方防辐射服', '普通宾客', null, '422', '和规范和规范和', null);
INSERT INTO `tb_guest` VALUES ('27', '地方', '男', null, '身份证', '789454', '地方防辐射服', '普通宾客', null, '422', '和规范和规范和', null);
INSERT INTO `tb_guest` VALUES ('28', '432', '男', null, '身份证', '234', '432', '普通宾客', null, '434', '324', null);
INSERT INTO `tb_guest` VALUES ('29', '342', '男', null, '身份证', '2134', '432', '普通宾客', null, '432', '432', null);
INSERT INTO `tb_guest` VALUES ('30', '324', '男', null, '身份证', '324234', '345', '普通宾客', null, '888', '666', null);
INSERT INTO `tb_guest` VALUES ('31', '35', '男', null, '身份证', '231', '第三方', '普通宾客', null, '222', '发多少', null);
INSERT INTO `tb_guest` VALUES ('32', '23', '男', null, '身份证', '213', '4545', '普通宾客', null, '500', '45455', null);
INSERT INTO `tb_guest` VALUES ('33', '32', '男', null, '身份证', '4335', '435454', '普通宾客', null, '3000', '4554', null);
INSERT INTO `tb_guest` VALUES ('34', '4556', '男', null, '身份证', '3424', '5665', '普通宾客', null, '3000', '65656', null);
INSERT INTO `tb_guest` VALUES ('35', '6746', '男', null, '身份证', '454', '789678', '普通宾客', null, '3000', '789987', null);
INSERT INTO `tb_guest` VALUES ('36', '4343', '男', null, '身份证', '3455', '454545', '普通宾客', null, '6000', '45434', null);
INSERT INTO `tb_guest` VALUES ('37', '6767', '男', null, '身份证', '667', '6556', '普通宾客', null, '564', '6456', null);
INSERT INTO `tb_guest` VALUES ('38', '324', '男', null, '身份证', '213', '3424', '普通宾客', null, '500', '342', null);
INSERT INTO `tb_guest` VALUES ('39', '45', '男', null, '身份证', '3423', '54', '普通宾客', null, '546', '544', null);
INSERT INTO `tb_guest` VALUES ('40', '周杰伦', '男', null, '身份证', '123456', '北京', '普通宾客', null, '6000', '6666666', null);
INSERT INTO `tb_guest` VALUES ('41', '张三', '男', null, '身份证', '111111', '湖北十堰', '普通宾客', null, '1000', '6666', null);
INSERT INTO `tb_guest` VALUES ('42', '李四', '男', null, '身份证', '2222', '湖北襄阳', '普通宾客', null, '5000', '666666', null);

-- ----------------------------
-- Table structure for tb_memberinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_memberinfo`;
CREATE TABLE `tb_memberinfo` (
  `memberNo` int(11) NOT NULL AUTO_INCREMENT,
  `guestNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`memberNo`),
  KEY `FK_fk_memberIno` (`guestNo`),
  CONSTRAINT `FK_fk_memberIno` FOREIGN KEY (`guestNo`) REFERENCES `tb_guest` (`guestNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_memberinfo
-- ----------------------------

-- ----------------------------
-- Table structure for tb_reseverinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_reseverinfo`;
CREATE TABLE `tb_reseverinfo` (
  `reseverID` int(11) NOT NULL AUTO_INCREMENT,
  `roomNo` varchar(20) DEFAULT NULL,
  `resevertime` datetime DEFAULT NULL,
  `estime` datetime DEFAULT NULL,
  `restaintime` datetime DEFAULT NULL,
  `liveDay` int(11) DEFAULT NULL,
  PRIMARY KEY (`reseverID`),
  KEY `FK_resever` (`roomNo`),
  CONSTRAINT `FK_resever` FOREIGN KEY (`roomNo`) REFERENCES `tb_roominfo` (`roomNo`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_reseverinfo
-- ----------------------------
INSERT INTO `tb_reseverinfo` VALUES ('3', 'BD10015', null, null, null, '20');
INSERT INTO `tb_reseverinfo` VALUES ('4', 'BD1002', null, null, null, '10');
INSERT INTO `tb_reseverinfo` VALUES ('5', null, null, null, null, '5');
INSERT INTO `tb_reseverinfo` VALUES ('6', 'BD10015', null, null, null, '11');
INSERT INTO `tb_reseverinfo` VALUES ('7', 'BD10015', null, null, null, '6');
INSERT INTO `tb_reseverinfo` VALUES ('8', 'BD1001', null, null, null, '7');
INSERT INTO `tb_reseverinfo` VALUES ('9', 'BD1004', null, null, null, '9');
INSERT INTO `tb_reseverinfo` VALUES ('10', 'BD10014', null, null, null, '2');
INSERT INTO `tb_reseverinfo` VALUES ('11', 'BD10015', null, null, null, '1');
INSERT INTO `tb_reseverinfo` VALUES ('12', 'BD1005', null, null, null, '2');
INSERT INTO `tb_reseverinfo` VALUES ('13', null, null, null, null, '42');
INSERT INTO `tb_reseverinfo` VALUES ('14', null, null, null, null, '234');
INSERT INTO `tb_reseverinfo` VALUES ('15', null, null, null, null, '12');
INSERT INTO `tb_reseverinfo` VALUES ('16', 'BD1001', null, null, null, '54');
INSERT INTO `tb_reseverinfo` VALUES ('17', 'BD1003', null, null, null, '32');
INSERT INTO `tb_reseverinfo` VALUES ('18', 'BD10012', null, null, null, '20');
INSERT INTO `tb_reseverinfo` VALUES ('19', 'BD1001', null, null, null, '10');
INSERT INTO `tb_reseverinfo` VALUES ('20', 'BD1002', null, null, null, '76');
INSERT INTO `tb_reseverinfo` VALUES ('21', 'BD1003', null, null, null, '30');
INSERT INTO `tb_reseverinfo` VALUES ('22', 'BD1004', null, null, null, '54');
INSERT INTO `tb_reseverinfo` VALUES ('23', 'BD10014', null, null, null, '6');
INSERT INTO `tb_reseverinfo` VALUES ('24', 'BD10013', null, null, null, '10');
INSERT INTO `tb_reseverinfo` VALUES ('25', 'BD10010', null, null, null, '5');

-- ----------------------------
-- Table structure for tb_roominfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_roominfo`;
CREATE TABLE `tb_roominfo` (
  `roomID` int(11) NOT NULL AUTO_INCREMENT,
  `roomNo` varchar(20) DEFAULT NULL,
  `roomPrice` decimal(10,0) DEFAULT NULL,
  `guestNo` int(11) DEFAULT NULL,
  `guesNum` int(11) DEFAULT NULL,
  `roomType` varchar(20) DEFAULT NULL,
  `roomState` varchar(20) DEFAULT NULL,
  `roomRemark` text,
  `floor` int(11) DEFAULT NULL,
  `roomPhone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`roomID`),
  KEY `FK_fk_roomInfo` (`guestNo`) USING BTREE,
  KEY `roomNo` (`roomNo`),
  CONSTRAINT `FK_fk_roomInfo` FOREIGN KEY (`guestNo`) REFERENCES `tb_guest` (`guestNo`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_roominfo
-- ----------------------------
INSERT INTO `tb_roominfo` VALUES ('1', 'BD1001', '250', '36', '54', '标准单人间', '当前占用', null, '1', '1001');
INSERT INTO `tb_roominfo` VALUES ('2', 'BS2001', '300', null, null, '标准双人间', '当前可用', null, '2', '2001');
INSERT INTO `tb_roominfo` VALUES ('3', 'HD3001', '350', null, null, '豪华单人间', '当前可用', null, '3', '3001');
INSERT INTO `tb_roominfo` VALUES ('4', 'HS4001', '400', null, null, '豪华双人间', '当前可用', null, '4', '4001');
INSERT INTO `tb_roominfo` VALUES ('5', 'SW5001', '450', null, null, '商务套房', '当前可用', null, '5', '5001');
INSERT INTO `tb_roominfo` VALUES ('6', 'ZT6001', '500', null, null, '总统套房', '当前可用', null, '6', '6001');
INSERT INTO `tb_roominfo` VALUES ('7', 'BD1002', '250', '37', '675674', '标准单人间', '当前占用', null, '1', '1002');
INSERT INTO `tb_roominfo` VALUES ('8', 'BD1003', '250', '38', '43', '标准单人间', '钟点房', null, '1', '1003');
INSERT INTO `tb_roominfo` VALUES ('9', 'BD1004', '250', '39', '43', '标准单人间', '钟点房', null, '1', '1004');
INSERT INTO `tb_roominfo` VALUES ('10', 'BD1005', '250', '27', '6', '标准单人间', '当前可用', null, '1', '1005');
INSERT INTO `tb_roominfo` VALUES ('11', 'BD1006', '250', '21', '8', '标准单人间', '当前可用', null, '1', '1006');
INSERT INTO `tb_roominfo` VALUES ('12', 'BD1007', '250', null, '9', '标准单人间', '当前可用', null, '1', '1007');
INSERT INTO `tb_roominfo` VALUES ('13', 'BD1008', '250', null, '5', '标准单人间', '当前可用', null, '1', '1008');
INSERT INTO `tb_roominfo` VALUES ('14', 'BD1009', '250', null, '20', '标准单人间', '当前可用', null, '1', '1009');
INSERT INTO `tb_roominfo` VALUES ('15', 'BD10010', '250', '42', '5', '标准单人间', '当前占用', null, '1', '10010');
INSERT INTO `tb_roominfo` VALUES ('16', 'BD10011', '250', null, null, '标准单人间', '当前可用', null, '1', '10011');
INSERT INTO `tb_roominfo` VALUES ('17', 'BD10012', '250', '35', '20', '标准单人间', '当前可用', null, '1', '10012');
INSERT INTO `tb_roominfo` VALUES ('18', 'BD10013', '250', '41', '3', '标准单人间', '当前占用', null, '1', '10013');
INSERT INTO `tb_roominfo` VALUES ('19', 'BD10014', '250', '40', '3', '标准单人间', '当前占用', null, '1', '10014');
INSERT INTO `tb_roominfo` VALUES ('20', 'BD10015', '250', '25', '4', '标准单人间', '当前可用', null, '1', '10015');
INSERT INTO `tb_roominfo` VALUES ('21', 'BS2002', '300', null, null, '标准双人间', '当前可用', null, '2', '2002');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', 'admin');
INSERT INTO `tb_user` VALUES ('2', 'hu', '123');
