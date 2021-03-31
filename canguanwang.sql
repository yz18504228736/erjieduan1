/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : canguanwang

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 30/03/2021 21:05:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_dinner_table
-- ----------------------------
DROP TABLE IF EXISTS `t_dinner_table`;
CREATE TABLE `t_dinner_table`  (
  `table_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '餐桌ID',
  `table_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '餐桌名称',
  `table_status` tinyint(4) NOT NULL COMMENT '状态(是否预定) 0:否 1:是',
  `reservation_time` datetime(0) NULL DEFAULT NULL COMMENT '预定时间',
  PRIMARY KEY (`table_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '餐桌表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_dinner_table
-- ----------------------------
INSERT INTO `t_dinner_table` VALUES (7, '纽约', 0, NULL);
INSERT INTO `t_dinner_table` VALUES (8, '巴黎', 0, NULL);
INSERT INTO `t_dinner_table` VALUES (9, '丹麦', 0, NULL);
INSERT INTO `t_dinner_table` VALUES (10, '首尔', 0, NULL);

-- ----------------------------
-- Table structure for t_food
-- ----------------------------
DROP TABLE IF EXISTS `t_food`;
CREATE TABLE `t_food`  (
  `food_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜品ID',
  `type_id` int(11) NULL DEFAULT NULL COMMENT '菜系ID',
  `food_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜品名称',
  `food_price` decimal(8, 2) NOT NULL COMMENT '价格',
  `food_mprice` decimal(8, 2) NOT NULL COMMENT '会员价格',
  `food_image` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片',
  `food_desc` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简介',
  PRIMARY KEY (`food_id`) USING BTREE,
  INDEX `FK_fk_food_type_id`(`type_id`) USING BTREE,
  CONSTRAINT `FK_fk_food_type_id` FOREIGN KEY (`type_id`) REFERENCES `t_food_type` (`type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_food
-- ----------------------------
INSERT INTO `t_food` VALUES (1, 6, '白灼虾', 36.00, 23.10, 'upload/ec77d574-f82c-484f-9960-ec87d2a0e3fc.jpg', '粤菜白灼虾');
INSERT INTO `t_food` VALUES (2, 6, '白切鸡', 56.00, 43.00, 'upload/7fa0c57e-4d63-4f7e-a1a7-c594f4315e71.jpg', '粤菜白切鸡，大件！');
INSERT INTO `t_food` VALUES (3, 6, '烤乳猪', 97.00, 85.00, 'upload/934f1ed8-b8ad-44c2-9b13-020c02fe20f2.jpg', '粤菜烤乳猪，大件！');
INSERT INTO `t_food` VALUES (5, 6, '烧鹅', 54.00, 42.00, 'upload/8e79a594-9cb8-4f35-9f04-780bc11802d3.jpg', '一只漂亮的烧鹅，大件');
INSERT INTO `t_food` VALUES (6, 6, '猪肉荷兰豆', 68.00, 50.00, 'upload/c43dd219-7552-459c-93d4-300d8182cac2.jpg', '粤菜猪肉荷兰豆，大件');
INSERT INTO `t_food` VALUES (7, 6, '黄埔炒蛋', 68.00, 50.00, 'upload/358ebd02-6a9e-42f3-87e3-a70cc99f5312.jpg', '黄埔炒蛋，大件');
INSERT INTO `t_food` VALUES (8, 6, '狗肉煲', 69.00, 50.00, 'upload/d4ce28b6-988f-4fb8-b38b-b134588f15da.jpg', '狗肉煲，大份');
INSERT INTO `t_food` VALUES (9, 1, '鲫鱼汤', 29.00, 16.00, 'upload/dddab172-74a2-48be-b55d-d8f96ed88631.jpg', '鲫鱼汤，大份');
INSERT INTO `t_food` VALUES (11, 1, '宫保鸡丁', 45.00, 34.00, 'upload/1908d0ae-ef6e-41cc-b8eb-aa228df392da.jpg', '这是一份美味的宫保鸡丁');

-- ----------------------------
-- Table structure for t_food_type
-- ----------------------------
DROP TABLE IF EXISTS `t_food_type`;
CREATE TABLE `t_food_type`  (
  `type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜系ID',
  `type_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜系名称',
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_food_type
-- ----------------------------
INSERT INTO `t_food_type` VALUES (1, '川菜');
INSERT INTO `t_food_type` VALUES (6, '粤菜');
INSERT INTO `t_food_type` VALUES (7, '湘菜');
INSERT INTO `t_food_type` VALUES (8, '东北菜');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `menu_url` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单URL',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '这是一个菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_menu
-- ----------------------------

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `order_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单ID',
  `table_id` int(11) NULL DEFAULT NULL COMMENT '餐桌ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '主键',
  `total_num` int(11) NOT NULL COMMENT '总数量',
  `order_total_price` decimal(20, 2) NOT NULL COMMENT '订单总金额',
  `order_create_time` datetime(0) NOT NULL COMMENT '下单时间',
  `order_status` tinyint(4) NOT NULL COMMENT '状态',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `FK_fk_dinner_table_id`(`table_id`) USING BTREE,
  INDEX `FK_fk_user_id`(`user_id`) USING BTREE,
  CONSTRAINT `FK_fk_dinner_table_id` FOREIGN KEY (`table_id`) REFERENCES `t_dinner_table` (`table_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('2230be4bf0f442', 7, 1, 2, 46.20, '2021-03-30 20:37:27', 1);
INSERT INTO `t_order` VALUES ('3100397b07344e', 7, 1, 2, 32.00, '2021-03-30 20:03:34', 1);
INSERT INTO `t_order` VALUES ('3241ba35bba747', 7, 1, 6, 303.00, '2021-03-30 20:17:07', 1);
INSERT INTO `t_order` VALUES ('379048d15f7247', 7, 1, 4, 146.20, '2021-03-30 20:46:27', 1);
INSERT INTO `t_order` VALUES ('3dc222eb59334e', 7, 1, 3, 62.20, '2021-03-30 20:39:52', 1);
INSERT INTO `t_order` VALUES ('46a2df568d0643', 7, 1, 3, 62.20, '2021-03-30 20:33:37', 1);
INSERT INTO `t_order` VALUES ('5ca8e6b3da774c', 9, 1, 1, 50.00, '2021-03-30 06:27:20', 1);
INSERT INTO `t_order` VALUES ('5ed00d9e591f4d', 7, 1, 3, 62.20, '2021-03-30 20:37:41', 1);
INSERT INTO `t_order` VALUES ('63764d00961f48', 7, 1, 4, 146.20, '2021-03-30 20:40:59', 1);
INSERT INTO `t_order` VALUES ('7ad1c7fbab6b4e', 7, 1, 2, 46.20, '2021-03-30 20:12:04', 1);
INSERT INTO `t_order` VALUES ('806eea116e2f4c', 7, 1, 4, 146.20, '2021-03-30 20:41:03', 1);
INSERT INTO `t_order` VALUES ('8be11d158ba94d', 7, 1, 6, 231.00, '2021-03-30 06:12:31', 1);
INSERT INTO `t_order` VALUES ('8e9cb7f794df43', 10, 1, 3, 82.00, '2021-03-30 06:17:25', 1);
INSERT INTO `t_order` VALUES ('9a27a0211ba94a', 7, 1, 4, 146.20, '2021-03-30 20:46:24', 1);
INSERT INTO `t_order` VALUES ('a4593568bd584b', 7, 1, 3, 62.20, '2021-03-30 20:08:04', 1);
INSERT INTO `t_order` VALUES ('a6026d0be31d4b', 10, 1, 1, 85.00, '2021-03-30 06:23:25', 1);
INSERT INTO `t_order` VALUES ('b51fa73542e044', 7, 1, 2, 46.20, '2021-03-30 20:07:45', 1);
INSERT INTO `t_order` VALUES ('bd21312038ce4e', 8, 1, 3, 116.00, '2021-03-30 20:18:28', 1);
INSERT INTO `t_order` VALUES ('e9c3ddbbbc044d', 7, 1, 4, 146.20, '2021-03-30 20:41:09', 1);
INSERT INTO `t_order` VALUES ('ea1d84cf25834c', 8, 1, 3, 116.00, '2021-03-30 20:18:44', 1);
INSERT INTO `t_order` VALUES ('ea464d5e093a4e', 8, 1, 2, 66.00, '2021-03-30 06:22:11', 1);
INSERT INTO `t_order` VALUES ('fe88bfbee0f64e', 9, 1, 1, 23.10, '2021-03-30 06:07:50', 1);

-- ----------------------------
-- Table structure for t_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE `t_order_detail`  (
  `order_detail_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详情ID',
  `order_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单ID',
  `food_id` int(11) NULL DEFAULT NULL COMMENT '菜品ID',
  `num` int(11) NULL DEFAULT NULL COMMENT '菜数量',
  `food_total_price` decimal(20, 2) NULL DEFAULT NULL COMMENT '小计',
  PRIMARY KEY (`order_detail_id`) USING BTREE,
  INDEX `FK_fk_food_id`(`food_id`) USING BTREE,
  INDEX `FK_fk_order_id`(`order_id`) USING BTREE,
  CONSTRAINT `FK_fk_food_id` FOREIGN KEY (`food_id`) REFERENCES `t_food` (`food_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_fk_order_id` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单详情实体' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nick_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `is_admin` tinyint(4) NOT NULL COMMENT '是否管理员 0:否  1:是',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `gender` tinyint(4) NOT NULL COMMENT '性别 0:保密 1:男 2:女',
  `user_status` tinyint(4) NOT NULL COMMENT '状态(是否激活) 0:否 1:是',
  `user_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `user_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(4) NOT NULL COMMENT '是否删除',
  `is_member` tinyint(4) NOT NULL COMMENT '是否会员 0:否 1:是',
  `balance` decimal(20, 2) NULL DEFAULT NULL COMMENT '账户余额',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '这是一个用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', '123456', '管理员1', 1, '15336290620', 1, 1, NULL, NULL, 0, 1, 52.00);

SET FOREIGN_KEY_CHECKS = 1;
