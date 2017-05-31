/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : axis

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-05-31 22:45:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_s_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_s_menu`;
CREATE TABLE `t_s_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `parentid` int(11) DEFAULT NULL COMMENT '父级菜单ID',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名',
  `leaf` int(11) DEFAULT NULL COMMENT '0 非叶子节点  1叶子节点',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标样式',
  `path` varchar(255) DEFAULT NULL COMMENT '访问路径',
  `level` int(11) DEFAULT NULL COMMENT '菜单级数',
  `url` varchar(255) DEFAULT NULL COMMENT '跳转地址',
  `target` varchar(255) DEFAULT NULL COMMENT '跳转方式',
  `createtime` datetime DEFAULT NULL,
  `modifytime` datetime DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_menu
-- ----------------------------
INSERT INTO `t_s_menu` VALUES ('1', '-1', '菜单根目录', '0', null, '--', '0', '#', null, '2012-12-15 18:08:07', '2012-12-23 19:46:45', 'admin');
INSERT INTO `t_s_menu` VALUES ('2', '1', '系统管理', '0', null, '1#2', '1', '#', null, '2012-12-13 13:46:00', '2013-04-29 10:36:34', 'admin');
INSERT INTO `t_s_menu` VALUES ('3', '1', '业务管理', '0', null, '1#3', '1', '#', null, '2012-12-13 13:53:10', '2013-04-26 20:15:27', 'admin');
INSERT INTO `t_s_menu` VALUES ('4', '2', '菜单管理', '0', null, '1#2#4', '2', '/system/menu/index', null, '2012-12-13 16:00:02', '2013-04-26 20:15:36', 'admin');
INSERT INTO `t_s_menu` VALUES ('5', '2', '用户管理', '0', null, '1#2#5', '2', '/system/user/index', null, '2012-12-13 16:00:02', '2013-04-26 20:15:47', 'admin');
INSERT INTO `t_s_menu` VALUES ('6', '2', '角色管理', '0', null, '1#2#6', '2', '/system/role/index', null, '2012-12-13 16:00:02', '2013-04-26 20:15:50', 'admin');
INSERT INTO `t_s_menu` VALUES ('7', '4', '菜单添加', '1', null, '1#2#4#7', '3', '/system/menuAdd.jsp', 'centerFrame', '2012-12-15 18:33:28', '2013-04-26 20:16:31', 'admin');
INSERT INTO `t_s_menu` VALUES ('8', '2', '权限管理', '0', null, '1#2#8', '2', '/system/permission/index', null, '2012-12-16 13:59:33', '2013-04-29 11:26:42', 'admin');
INSERT INTO `t_s_menu` VALUES ('9', '4', '菜单查询', '1', null, '1#2#4#9', '3', '/system/menuList.jsp', 'centerFrame', '2012-12-16 14:15:20', '2013-04-26 20:12:33', 'admin');
INSERT INTO `t_s_menu` VALUES ('10', '8', '权限添加', '1', null, '1#2#8#10', '3', '/system/permissionAdd.jsp', 'centerFrame', '2012-12-20 14:58:29', '2013-04-26 20:12:38', 'admin');
INSERT INTO `t_s_menu` VALUES ('13', '8', '权限查询', '1', null, '1#2#8#13', '3', '/system/permissionList.jsp', 'centerFrame', '2012-12-20 16:28:03', '2013-04-26 20:12:43', 'admin');
INSERT INTO `t_s_menu` VALUES ('14', '6', '角色添加', '1', null, '1#2#6#14', '3', '/system/roleAdd.jsp', 'centerFrame', '2012-12-22 12:36:14', '2013-04-26 20:12:48', 'admin');
INSERT INTO `t_s_menu` VALUES ('15', '6', '角色查询', '1', null, '1#2#6#15', '3', '/system/roleList.jsp', 'centerFrame', '2012-12-22 14:29:28', '2013-04-26 20:12:53', 'admin');
INSERT INTO `t_s_menu` VALUES ('16', '5', '用户添加', '1', null, '1#2#5#16', '3', '/system/userAdd.jsp', 'centerFrame', '2012-12-22 18:34:26', '2013-04-26 20:12:57', 'admin');
INSERT INTO `t_s_menu` VALUES ('17', '5', '用户查询', '1', null, '1#2#5#17', '3', '/system/userList.jsp', 'centerFrame', '2012-12-22 19:56:13', '2013-04-26 20:13:01', 'admin');

-- ----------------------------
-- Table structure for t_s_role
-- ----------------------------
DROP TABLE IF EXISTS `t_s_role`;
CREATE TABLE `t_s_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolecode` varchar(32) DEFAULT NULL,
  `rolename` varchar(64) DEFAULT NULL,
  `operator` varchar(32) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `modifytime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_role
-- ----------------------------
INSERT INTO `t_s_role` VALUES ('1', 'BROWER', '浏览', 'admin', null, null);
INSERT INTO `t_s_role` VALUES ('2', 'delete', 'delete', 'admin', null, null);

-- ----------------------------
-- Table structure for t_s_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_s_role_menu`;
CREATE TABLE `t_s_role_menu` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `roleid` int(10) DEFAULT NULL,
  `menuid` int(10) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `modifytime` datetime DEFAULT NULL,
  `operator` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_role_menu
-- ----------------------------
INSERT INTO `t_s_role_menu` VALUES ('1', '1', '1', null, null, 'admin');
INSERT INTO `t_s_role_menu` VALUES ('2', '1', '2', null, null, 'admin');
INSERT INTO `t_s_role_menu` VALUES ('3', '1', '3', null, null, 'admin');
INSERT INTO `t_s_role_menu` VALUES ('4', '1', '4', null, null, 'admin');
INSERT INTO `t_s_role_menu` VALUES ('5', '1', '5', null, null, 'admin');
INSERT INTO `t_s_role_menu` VALUES ('6', '1', '6', null, null, 'admin');
INSERT INTO `t_s_role_menu` VALUES ('7', '1', '7', null, null, 'admin');
INSERT INTO `t_s_role_menu` VALUES ('8', '1', '8', null, null, 'admin');
INSERT INTO `t_s_role_menu` VALUES ('9', '1', '9', null, null, 'admin');
INSERT INTO `t_s_role_menu` VALUES ('10', '1', '10', null, null, 'admin');

-- ----------------------------
-- Table structure for t_s_user
-- ----------------------------
DROP TABLE IF EXISTS `t_s_user`;
CREATE TABLE `t_s_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginaccount` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `modifytime` datetime DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_user
-- ----------------------------
INSERT INTO `t_s_user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '管理员', 'lizhenhua@ukelink.com', '18682321410', '主席', null, null, null);

-- ----------------------------
-- Table structure for t_s_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_s_user_role`;
CREATE TABLE `t_s_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `modifytime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_user_role
-- ----------------------------
INSERT INTO `t_s_user_role` VALUES ('1', '1', '1', 'admin', null, null);
