/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : axis

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-08-10 19:13:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_s_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_s_menu`;
CREATE TABLE `t_s_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `parentid` int(11) DEFAULT NULL COMMENT '父级菜单ID',
  `sys_id` varchar(64) DEFAULT NULL COMMENT '系统ID',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名',
  `leaf` int(11) DEFAULT NULL COMMENT '0 非叶子节点  1叶子节点',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标样式',
  `path` varchar(255) DEFAULT NULL COMMENT '访问路径',
  `level` int(11) DEFAULT NULL COMMENT '菜单级数',
  `url` varchar(255) DEFAULT NULL COMMENT '跳转地址',
  `target` varchar(255) DEFAULT NULL COMMENT '跳转方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_menu
-- ----------------------------
INSERT INTO `t_s_menu` VALUES ('1', '-1', null, '菜单根目录', '0', null, '--', '0', '#', null);
INSERT INTO `t_s_menu` VALUES ('2', '1', null, '系统管理', '0', null, '1#2', '1', '#', null);
INSERT INTO `t_s_menu` VALUES ('3', '1', null, '业务管理', '0', null, '1#3', '1', '#', null);
INSERT INTO `t_s_menu` VALUES ('4', '2', null, '菜单管理', '0', null, '1#2#4', '2', '/system/menu/index', null);
INSERT INTO `t_s_menu` VALUES ('5', '2', null, '用户管理', '0', null, '1#2#5', '2', '/system/user/index', null);
INSERT INTO `t_s_menu` VALUES ('6', '2', null, '角色管理', '0', null, '1#2#6', '2', '/system/role/index', null);
INSERT INTO `t_s_menu` VALUES ('7', '4', null, '菜单添加', '1', null, '1#2#4#7', '3', '/system/menuAdd.jsp', 'centerFrame');
INSERT INTO `t_s_menu` VALUES ('8', '2', null, '权限管理', '0', null, '1#2#8', '2', '/system/permission/index', null);
INSERT INTO `t_s_menu` VALUES ('9', '4', null, '菜单查询', '1', null, '1#2#4#9', '3', '/system/menuList.jsp', 'centerFrame');
INSERT INTO `t_s_menu` VALUES ('10', '8', null, '权限添加', '1', null, '1#2#8#10', '3', '/system/permissionAdd.jsp', 'centerFrame');
INSERT INTO `t_s_menu` VALUES ('13', '8', null, '权限查询', '1', null, '1#2#8#13', '3', '/system/permissionList.jsp', 'centerFrame');
INSERT INTO `t_s_menu` VALUES ('14', '6', null, '角色添加', '1', null, '1#2#6#14', '3', '/system/roleAdd.jsp', 'centerFrame');
INSERT INTO `t_s_menu` VALUES ('15', '6', null, '角色查询', '1', null, '1#2#6#15', '3', '/system/roleList.jsp', 'centerFrame');
INSERT INTO `t_s_menu` VALUES ('16', '5', null, '用户添加', '1', null, '1#2#5#16', '3', '/system/userAdd.jsp', 'centerFrame');
INSERT INTO `t_s_menu` VALUES ('17', '5', null, '用户查询', '1', null, '1#2#5#17', '3', '/system/userList.jsp', 'centerFrame');

-- ----------------------------
-- Table structure for `t_s_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_s_role`;
CREATE TABLE `t_s_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolecode` varchar(32) DEFAULT NULL,
  `rolename` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_role
-- ----------------------------
INSERT INTO `t_s_role` VALUES ('1', 'BROWER', '浏览');
INSERT INTO `t_s_role` VALUES ('2', 'delete', 'delete');

-- ----------------------------
-- Table structure for `t_s_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_s_role_menu`;
CREATE TABLE `t_s_role_menu` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `roleid` int(10) DEFAULT NULL,
  `menuid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_role_menu
-- ----------------------------
INSERT INTO `t_s_role_menu` VALUES ('1', '1', '1');
INSERT INTO `t_s_role_menu` VALUES ('2', '1', '2');
INSERT INTO `t_s_role_menu` VALUES ('3', '1', '3');
INSERT INTO `t_s_role_menu` VALUES ('4', '1', '4');
INSERT INTO `t_s_role_menu` VALUES ('5', '1', '5');
INSERT INTO `t_s_role_menu` VALUES ('6', '1', '6');
INSERT INTO `t_s_role_menu` VALUES ('7', '1', '7');
INSERT INTO `t_s_role_menu` VALUES ('8', '1', '8');
INSERT INTO `t_s_role_menu` VALUES ('9', '1', '9');
INSERT INTO `t_s_role_menu` VALUES ('10', '1', '10');

-- ----------------------------
-- Table structure for `t_s_sys`
-- ----------------------------
DROP TABLE IF EXISTS `t_s_sys`;
CREATE TABLE `t_s_sys` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `sys_id` varchar(32) DEFAULT NULL COMMENT '系统ID--唯一标识',
  `sys_code` varchar(32) DEFAULT NULL COMMENT '系统编码',
  `sys_name` varchar(255) DEFAULT NULL COMMENT '系统名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统信息表';

-- ----------------------------
-- Records of t_s_sys
-- ----------------------------
INSERT INTO `t_s_sys` VALUES ('1', 'a99c066ff8724f2e9b4267ed36239dd7', 'axis', '轴');

-- ----------------------------
-- Table structure for `t_s_sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_s_sys_user`;
CREATE TABLE `t_s_sys_user` (
  `sys_id` varchar(32) NOT NULL DEFAULT '' COMMENT '系统ID',
  `user_id` varchar(32) NOT NULL DEFAULT '' COMMENT '用户ID',
  `password` varchar(128) DEFAULT NULL,
  `user_type_id` varchar(64) DEFAULT NULL COMMENT '类型ID',
  `enable` tinyint(1) DEFAULT '1' COMMENT '0 禁用  1 正常',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `operator_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`sys_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_sys_user
-- ----------------------------
INSERT INTO `t_s_sys_user` VALUES ('a99c066ff8724f2e9b4267ed36239dd7', '8979d0383623432885229bc00dc157d5', null, null, '1', null, null, null);

-- ----------------------------
-- Table structure for `t_s_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_s_user`;
CREATE TABLE `t_s_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `login_account` varchar(64) DEFAULT NULL COMMENT '登录帐号',
  `full_name` varchar(64) DEFAULT NULL COMMENT '用户姓名',
  `nick_name` varchar(64) DEFAULT NULL COMMENT '昵称',
  `email` varchar(64) DEFAULT NULL COMMENT '电子邮箱',
  `mobile` varchar(16) DEFAULT NULL COMMENT '联系电话',
  `remark` varchar(512) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `operator_id` varchar(64) DEFAULT NULL COMMENT '操作员id',
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of t_s_user
-- ----------------------------
INSERT INTO `t_s_user` VALUES ('1', '8979d0383623432885229bc00dc157d5', null, '管理员', '主席', '123456@qq.com', '18682321410', '这个是管理员', '2017-07-26 15:53:11', '2017-07-26 15:53:53', null);

-- ----------------------------
-- Table structure for `t_s_user_role`
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_s_user_role
-- ----------------------------
INSERT INTO `t_s_user_role` VALUES ('1', '1', '1', 'admin', null, null);

-- ----------------------------
-- Function structure for `getChildList`
-- ----------------------------
DROP FUNCTION IF EXISTS `getChildList`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getChildList`(rootId INT) RETURNS varchar(1000) CHARSET utf8
BEGIN
   DECLARE sTemp VARCHAR(1000);
   DECLARE sTempChd VARCHAR(1000);

	 SET sTemp='$';
   SET sTempChd =cast(rootId as CHAR);
	 
   WHILE sTempChd is not null DO
		SET sTemp = concat(sTemp,',',sTempChd);
     SELECT group_concat(id) INTO sTempChd FROM t_s_menu where FIND_IN_SET(parentid,sTempChd)>0;
   END WHILE;
   RETURN sTemp;
 END
;;
DELIMITER ;
