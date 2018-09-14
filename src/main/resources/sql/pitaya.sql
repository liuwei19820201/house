/*
 Navicat MySQL Data Transfer

 Source Server         : 47.104.100.97
 Source Server Type    : MySQL
 Source Server Version : 50556
 Source Host           : 47.104.100.97:3306
 Source Schema         : pitaya

 Target Server Type    : MySQL
 Target Server Version : 50556
 File Encoding         : 65001

 Date: 28/08/2018 16:57:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_area
-- ----------------------------
DROP TABLE IF EXISTS `sys_area`;
CREATE TABLE `sys_area`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `full_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `full_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `n_parent_id`(`parent_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 588 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_area
-- ----------------------------
INSERT INTO `sys_area` VALUES (0, '全部', NULL, NULL, NULL, 0);
INSERT INTO `sys_area` VALUES (1, '北京市', 0, '', '', 1);
INSERT INTO `sys_area` VALUES (2, '天津市', 0, '/2', '/天津市', 1);
INSERT INTO `sys_area` VALUES (3, '河北省', 0, '/3', '/河北省', 1);
INSERT INTO `sys_area` VALUES (4, '山西省', 0, '/4', '/山西省', 1);
INSERT INTO `sys_area` VALUES (5, '内蒙古自治区', 0, '/5', '/内蒙古自治区', 1);
INSERT INTO `sys_area` VALUES (6, '辽宁省', 0, '/6', '/辽宁省', 1);
INSERT INTO `sys_area` VALUES (7, '吉林省', 0, '/7', '/吉林省', 1);
INSERT INTO `sys_area` VALUES (8, '黑龙江省', 0, '/8', '/黑龙江省', 1);
INSERT INTO `sys_area` VALUES (9, '上海市', 0, '/9', '/上海市', 1);
INSERT INTO `sys_area` VALUES (10, '江苏省', 0, '/10', '/江苏省', 1);
INSERT INTO `sys_area` VALUES (11, '浙江省', 0, '/11', '/浙江省', 1);
INSERT INTO `sys_area` VALUES (12, '安徽省', 0, '/12', '/安徽省', 1);
INSERT INTO `sys_area` VALUES (13, '福建省', 0, '/13', '/福建省', 1);
INSERT INTO `sys_area` VALUES (14, '江西省', 0, '/14', '/江西省', 1);
INSERT INTO `sys_area` VALUES (15, '山东省', 0, '/15', '/山东省', 1);
INSERT INTO `sys_area` VALUES (16, '河南省', 0, '/16', '/河南省', 1);
INSERT INTO `sys_area` VALUES (17, '湖北省', 0, '/17', '/湖北省', 1);
INSERT INTO `sys_area` VALUES (18, '湖南省', 0, '/18', '/湖南省', 1);
INSERT INTO `sys_area` VALUES (19, '广东省', 0, '/19', '/广东省', 1);
INSERT INTO `sys_area` VALUES (20, '海南省', 0, '/20', '/海南省', 1);
INSERT INTO `sys_area` VALUES (21, '广西壮族自治区', 0, '/21', '/广西壮族自治区', 1);
INSERT INTO `sys_area` VALUES (22, '甘肃省', 0, '/22', '/甘肃省', 1);
INSERT INTO `sys_area` VALUES (23, '陕西省', 0, '/23', '/陕西省', 1);
INSERT INTO `sys_area` VALUES (24, '新疆维吾尔自治区', 0, '/24', '/新疆维吾尔自治区', 1);
INSERT INTO `sys_area` VALUES (25, '青海省', 0, '/25', '/青海省', 1);
INSERT INTO `sys_area` VALUES (26, '宁夏回族自治区', 0, '/26', '/宁夏回族自治区', 1);
INSERT INTO `sys_area` VALUES (27, '重庆市', 0, '/27', '/重庆市', 1);
INSERT INTO `sys_area` VALUES (28, '四川省', 0, '/28', '/四川省', 1);
INSERT INTO `sys_area` VALUES (29, '贵州省', 0, '/29', '/贵州省', 1);
INSERT INTO `sys_area` VALUES (30, '云南省', 0, '/30', '/云南省', 1);
INSERT INTO `sys_area` VALUES (31, '西藏自治区', 0, '/31', '/西藏自治区', 1);
INSERT INTO `sys_area` VALUES (32, '东城区', 1, '/1/32', '/北京市/东城区', 2);
INSERT INTO `sys_area` VALUES (33, '西城区', 1, '/1/33', '/北京市/西城区', 2);
INSERT INTO `sys_area` VALUES (34, '崇文区', 1, '/1/34', '/北京市/崇文区', 2);
INSERT INTO `sys_area` VALUES (35, '宣武区', 1, '/1/35', '/北京市/宣武区', 2);
INSERT INTO `sys_area` VALUES (36, '朝阳区', 1, '/1/36', '/北京市/朝阳区', 2);
INSERT INTO `sys_area` VALUES (37, '丰台区', 1, '/1/37', '/北京市/丰台区', 2);
INSERT INTO `sys_area` VALUES (38, '石景山区', 1, '/1/38', '/北京市/石景山区', 2);
INSERT INTO `sys_area` VALUES (39, '海淀区', 1, '/1/39', '/北京市/海淀区', 2);
INSERT INTO `sys_area` VALUES (40, '门头沟区', 1, '/1/40', '/北京市/门头沟区', 2);
INSERT INTO `sys_area` VALUES (41, '房山区', 1, '/1/41', '/北京市/房山区', 2);
INSERT INTO `sys_area` VALUES (42, '通州区', 1, '/1/42', '/北京市/通州区', 2);
INSERT INTO `sys_area` VALUES (43, '顺义区', 1, '/1/43', '/北京市/顺义区', 2);
INSERT INTO `sys_area` VALUES (44, '昌平区', 1, '/1/44', '/北京市/昌平区', 2);
INSERT INTO `sys_area` VALUES (45, '大兴区', 1, '/1/45', '/北京市/大兴区', 2);
INSERT INTO `sys_area` VALUES (46, '怀柔区', 1, '/1/46', '/北京市/怀柔区', 2);
INSERT INTO `sys_area` VALUES (47, '平谷区', 1, '/1/47', '/北京市/平谷区', 2);
INSERT INTO `sys_area` VALUES (48, '密云县', 1, '/1/48', '/北京市/密云县', 2);
INSERT INTO `sys_area` VALUES (49, '延庆县', 1, '/1/49', '/北京市/延庆县', 2);
INSERT INTO `sys_area` VALUES (50, '和平区', 2, '/2/50', '/天津市/和平区', 2);
INSERT INTO `sys_area` VALUES (51, '河东区', 2, '/2/51', '/天津市/河东区', 2);
INSERT INTO `sys_area` VALUES (52, '河西区', 2, '/2/52', '/天津市/河西区', 2);
INSERT INTO `sys_area` VALUES (53, '南开区', 2, '/2/53', '/天津市/南开区', 2);
INSERT INTO `sys_area` VALUES (54, '河北区', 2, '/2/54', '/天津市/河北区', 2);
INSERT INTO `sys_area` VALUES (55, '红桥区', 2, '/2/55', '/天津市/红桥区', 2);
INSERT INTO `sys_area` VALUES (56, '塘沽区', 2, '/2/56', '/天津市/塘沽区', 2);
INSERT INTO `sys_area` VALUES (57, '汉沽区', 2, '/2/57', '/天津市/汉沽区', 2);
INSERT INTO `sys_area` VALUES (58, '大港区', 2, '/2/58', '/天津市/大港区', 2);
INSERT INTO `sys_area` VALUES (59, '东丽区', 2, '/2/59', '/天津市/东丽区', 2);
INSERT INTO `sys_area` VALUES (60, '西青区', 2, '/2/60', '/天津市/西青区', 2);
INSERT INTO `sys_area` VALUES (61, '津南区', 2, '/2/61', '/天津市/津南区', 2);
INSERT INTO `sys_area` VALUES (62, '北辰区', 2, '/2/62', '/天津市/北辰区', 2);
INSERT INTO `sys_area` VALUES (63, '武清区', 2, '/2/63', '/天津市/武清区', 2);
INSERT INTO `sys_area` VALUES (64, '宝坻区', 2, '/2/64', '/天津市/宝坻区', 2);
INSERT INTO `sys_area` VALUES (65, '滨海新区', 2, '/2/65', '/天津市/滨海新区', 2);
INSERT INTO `sys_area` VALUES (66, '宁河县', 2, '/2/66', '/天津市/宁河县', 2);
INSERT INTO `sys_area` VALUES (67, '静海县', 2, '/2/67', '/天津市/静海县', 2);
INSERT INTO `sys_area` VALUES (68, '蓟县', 2, '/2/68', '/天津市/蓟县', 2);
INSERT INTO `sys_area` VALUES (81, '石家庄市', 3, '/3/81', '/河北省/石家庄市', 2);
INSERT INTO `sys_area` VALUES (82, '唐山市', 3, '/3/82', '/河北省/唐山市', 2);
INSERT INTO `sys_area` VALUES (83, '秦皇岛市', 3, '/3/83', '/河北省/秦皇岛市', 2);
INSERT INTO `sys_area` VALUES (84, '邯郸市', 3, '/3/84', '/河北省/邯郸市', 2);
INSERT INTO `sys_area` VALUES (85, '邢台市', 3, '/3/85', '/河北省/邢台市', 2);
INSERT INTO `sys_area` VALUES (86, '保定市', 3, '/3/86', '/河北省/保定市', 2);
INSERT INTO `sys_area` VALUES (87, '张家口市', 3, '/3/87', '/河北省/张家口市', 2);
INSERT INTO `sys_area` VALUES (88, '承德市', 3, '/3/88', '/河北省/承德市', 2);
INSERT INTO `sys_area` VALUES (89, '沧州市', 3, '/3/89', '/河北省/沧州市', 2);
INSERT INTO `sys_area` VALUES (90, '廊坊市', 3, '/3/90', '/河北省/廊坊市', 2);
INSERT INTO `sys_area` VALUES (91, '衡水市', 3, '/3/91', '/河北省/衡水市', 2);
INSERT INTO `sys_area` VALUES (96, '太原市', 4, '/4/96', '/山西省/太原市', 2);
INSERT INTO `sys_area` VALUES (97, '大同市', 4, '/4/97', '/山西省/大同市', 2);
INSERT INTO `sys_area` VALUES (98, '阳泉市', 4, '/4/98', '/山西省/阳泉市', 2);
INSERT INTO `sys_area` VALUES (99, '长治市', 4, '/4/99', '/山西省/长治市', 2);
INSERT INTO `sys_area` VALUES (100, '晋城市', 4, '/4/100', '/山西省/晋城市', 2);
INSERT INTO `sys_area` VALUES (101, '朔州市', 4, '/4/101', '/山西省/朔州市', 2);
INSERT INTO `sys_area` VALUES (102, '晋中市', 4, '/4/102', '/山西省/晋中市', 2);
INSERT INTO `sys_area` VALUES (103, '运城市', 4, '/4/103', '/山西省/运城市', 2);
INSERT INTO `sys_area` VALUES (104, '忻州市', 4, '/4/104', '/山西省/忻州市', 2);
INSERT INTO `sys_area` VALUES (105, '临汾市', 4, '/4/105', '/山西省/临汾市', 2);
INSERT INTO `sys_area` VALUES (106, '吕梁市', 4, '/4/106', '/山西省/吕梁市', 2);
INSERT INTO `sys_area` VALUES (111, '呼和浩特市', 5, '/5/111', '/内蒙古自治区/呼和浩特市', 2);
INSERT INTO `sys_area` VALUES (112, '包头市', 5, '/5/112', '/内蒙古自治区/包头市', 2);
INSERT INTO `sys_area` VALUES (113, '乌海市', 5, '/5/113', '/内蒙古自治区/乌海市', 2);
INSERT INTO `sys_area` VALUES (114, '赤峰市', 5, '/5/114', '/内蒙古自治区/赤峰市', 2);
INSERT INTO `sys_area` VALUES (115, '通辽市', 5, '/5/115', '/内蒙古自治区/通辽市', 2);
INSERT INTO `sys_area` VALUES (116, '鄂尔多斯市', 5, '/5/116', '/内蒙古自治区/鄂尔多斯市', 2);
INSERT INTO `sys_area` VALUES (117, '呼伦贝尔市', 5, '/5/117', '/内蒙古自治区/呼伦贝尔市', 2);
INSERT INTO `sys_area` VALUES (118, '巴彦淖尔市', 5, '/5/118', '/内蒙古自治区/巴彦淖尔市', 2);
INSERT INTO `sys_area` VALUES (119, '乌兰察布市', 5, '/5/119', '/内蒙古自治区/乌兰察布市', 2);
INSERT INTO `sys_area` VALUES (120, '兴安盟', 5, '/5/120', '/内蒙古自治区/兴安盟', 2);
INSERT INTO `sys_area` VALUES (121, '锡林郭勒盟', 5, '/5/121', '/内蒙古自治区/锡林郭勒盟', 2);
INSERT INTO `sys_area` VALUES (122, '阿拉善盟', 5, '/5/122', '/内蒙古自治区/阿拉善盟', 2);
INSERT INTO `sys_area` VALUES (126, '沈阳市', 6, '/6/126', '/辽宁省/沈阳市', 2);
INSERT INTO `sys_area` VALUES (127, '大连市', 6, '/6/127', '/辽宁省/大连市', 2);
INSERT INTO `sys_area` VALUES (128, '鞍山市', 6, '/6/128', '/辽宁省/鞍山市', 2);
INSERT INTO `sys_area` VALUES (129, '抚顺市', 6, '/6/129', '/辽宁省/抚顺市', 2);
INSERT INTO `sys_area` VALUES (130, '本溪市', 6, '/6/130', '/辽宁省/本溪市', 2);
INSERT INTO `sys_area` VALUES (131, '丹东市', 6, '/6/131', '/辽宁省/丹东市', 2);
INSERT INTO `sys_area` VALUES (132, '锦州市', 6, '/6/132', '/辽宁省/锦州市', 2);
INSERT INTO `sys_area` VALUES (133, '营口市', 6, '/6/133', '/辽宁省/营口市', 2);
INSERT INTO `sys_area` VALUES (134, '阜新市', 6, '/6/134', '/辽宁省/阜新市', 2);
INSERT INTO `sys_area` VALUES (135, '辽阳市', 6, '/6/135', '/辽宁省/辽阳市', 2);
INSERT INTO `sys_area` VALUES (136, '盘锦市', 6, '/6/136', '/辽宁省/盘锦市', 2);
INSERT INTO `sys_area` VALUES (137, '铁岭市', 6, '/6/137', '/辽宁省/铁岭市', 2);
INSERT INTO `sys_area` VALUES (138, '朝阳市', 6, '/6/138', '/辽宁省/朝阳市', 2);
INSERT INTO `sys_area` VALUES (139, '葫芦岛市', 6, '/6/139', '/辽宁省/葫芦岛市', 2);
INSERT INTO `sys_area` VALUES (141, '长春市', 7, '/7/141', '/吉林省/长春市', 2);
INSERT INTO `sys_area` VALUES (142, '吉林市', 7, '/7/142', '/吉林省/吉林市', 2);
INSERT INTO `sys_area` VALUES (143, '四平市', 7, '/7/143', '/吉林省/四平市', 2);
INSERT INTO `sys_area` VALUES (144, '辽源市', 7, '/7/144', '/吉林省/辽源市', 2);
INSERT INTO `sys_area` VALUES (145, '通化市', 7, '/7/145', '/吉林省/通化市', 2);
INSERT INTO `sys_area` VALUES (146, '白山市', 7, '/7/146', '/吉林省/白山市', 2);
INSERT INTO `sys_area` VALUES (147, '松原市', 7, '/7/147', '/吉林省/松原市', 2);
INSERT INTO `sys_area` VALUES (148, '白城市', 7, '/7/148', '/吉林省/白城市', 2);
INSERT INTO `sys_area` VALUES (149, '延边朝鲜族自治州', 7, '/7/149', '/吉林省/延边朝鲜族自治州', 2);
INSERT INTO `sys_area` VALUES (156, '哈尔滨市', 8, '/8/156', '/黑龙江省/哈尔滨市', 2);
INSERT INTO `sys_area` VALUES (157, '齐齐哈尔市', 8, '/8/157', '/黑龙江省/齐齐哈尔市', 2);
INSERT INTO `sys_area` VALUES (158, '鸡西市', 8, '/8/158', '/黑龙江省/鸡西市', 2);
INSERT INTO `sys_area` VALUES (159, '鹤岗市', 8, '/8/159', '/黑龙江省/鹤岗市', 2);
INSERT INTO `sys_area` VALUES (160, '双鸭山市', 8, '/8/160', '/黑龙江省/双鸭山市', 2);
INSERT INTO `sys_area` VALUES (161, '大庆市', 8, '/8/161', '/黑龙江省/大庆市', 2);
INSERT INTO `sys_area` VALUES (162, '伊春市', 8, '/8/162', '/黑龙江省/伊春市', 2);
INSERT INTO `sys_area` VALUES (163, '佳木斯市', 8, '/8/163', '/黑龙江省/佳木斯市', 2);
INSERT INTO `sys_area` VALUES (164, '七台河市', 8, '/8/164', '/黑龙江省/七台河市', 2);
INSERT INTO `sys_area` VALUES (165, '牡丹江市', 8, '/8/165', '/黑龙江省/牡丹江市', 2);
INSERT INTO `sys_area` VALUES (166, '黑河市', 8, '/8/166', '/黑龙江省/黑河市', 2);
INSERT INTO `sys_area` VALUES (167, '绥化市', 8, '/8/167', '/黑龙江省/绥化市', 2);
INSERT INTO `sys_area` VALUES (168, '大兴安岭地区', 8, '/8/168', '/黑龙江省/大兴安岭地区', 2);
INSERT INTO `sys_area` VALUES (171, '黄浦区', 9, '/9/171', '/上海市/黄浦区', 2);
INSERT INTO `sys_area` VALUES (172, '卢湾区', 9, '/9/172', '/上海市/卢湾区', 2);
INSERT INTO `sys_area` VALUES (173, '徐汇区', 9, '/9/173', '/上海市/徐汇区', 2);
INSERT INTO `sys_area` VALUES (174, '长宁区', 9, '/9/174', '/上海市/长宁区', 2);
INSERT INTO `sys_area` VALUES (175, '静安区', 9, '/9/175', '/上海市/静安区', 2);
INSERT INTO `sys_area` VALUES (176, '普陀区', 9, '/9/176', '/上海市/普陀区', 2);
INSERT INTO `sys_area` VALUES (177, '闸北区', 9, '/9/177', '/上海市/闸北区', 2);
INSERT INTO `sys_area` VALUES (178, '虹口区', 9, '/9/178', '/上海市/虹口区', 2);
INSERT INTO `sys_area` VALUES (179, '杨浦区', 9, '/9/179', '/上海市/杨浦区', 2);
INSERT INTO `sys_area` VALUES (180, '闵行区', 9, '/9/180', '/上海市/闵行区', 2);
INSERT INTO `sys_area` VALUES (181, '宝山区', 9, '/9/181', '/上海市/宝山区', 2);
INSERT INTO `sys_area` VALUES (182, '嘉定区', 9, '/9/182', '/上海市/嘉定区', 2);
INSERT INTO `sys_area` VALUES (183, '浦东新区', 9, '/9/183', '/上海市/浦东新区', 2);
INSERT INTO `sys_area` VALUES (184, '金山区', 9, '/9/184', '/上海市/金山区', 2);
INSERT INTO `sys_area` VALUES (185, '松江区', 9, '/9/185', '/上海市/松江区', 2);
INSERT INTO `sys_area` VALUES (186, '青浦区', 9, '/9/186', '/上海市/青浦区', 2);
INSERT INTO `sys_area` VALUES (187, '南汇区', 9, '/9/187', '/上海市/南汇区', 2);
INSERT INTO `sys_area` VALUES (188, '奉贤区', 9, '/9/188', '/上海市/奉贤区', 2);
INSERT INTO `sys_area` VALUES (189, '崇明县', 9, '/9/189', '/上海市/崇明县', 2);
INSERT INTO `sys_area` VALUES (202, '南京市', 10, '/10/202', '/江苏省/南京市', 2);
INSERT INTO `sys_area` VALUES (203, '无锡市', 10, '/10/203', '/江苏省/无锡市', 2);
INSERT INTO `sys_area` VALUES (204, '徐州市', 10, '/10/204', '/江苏省/徐州市', 2);
INSERT INTO `sys_area` VALUES (205, '常州市', 10, '/10/205', '/江苏省/常州市', 2);
INSERT INTO `sys_area` VALUES (206, '苏州市', 10, '/10/206', '/江苏省/苏州市', 2);
INSERT INTO `sys_area` VALUES (207, '南通市', 10, '/10/207', '/江苏省/南通市', 2);
INSERT INTO `sys_area` VALUES (208, '连云港市', 10, '/10/208', '/江苏省/连云港市', 2);
INSERT INTO `sys_area` VALUES (209, '淮安市', 10, '/10/209', '/江苏省/淮安市', 2);
INSERT INTO `sys_area` VALUES (210, '盐城市', 10, '/10/210', '/江苏省/盐城市', 2);
INSERT INTO `sys_area` VALUES (211, '扬州市', 10, '/10/211', '/江苏省/扬州市', 2);
INSERT INTO `sys_area` VALUES (212, '镇江市', 10, '/10/212', '/江苏省/镇江市', 2);
INSERT INTO `sys_area` VALUES (213, '泰州市', 10, '/10/213', '/江苏省/泰州市', 2);
INSERT INTO `sys_area` VALUES (214, '宿迁市', 10, '/10/214', '/江苏省/宿迁市', 2);
INSERT INTO `sys_area` VALUES (215, '杭州市', 11, '/11/215', '/浙江省/杭州市', 2);
INSERT INTO `sys_area` VALUES (216, '宁波市', 11, '/11/216', '/浙江省/宁波市', 2);
INSERT INTO `sys_area` VALUES (217, '温州市', 11, '/11/217', '/浙江省/温州市', 2);
INSERT INTO `sys_area` VALUES (218, '嘉兴市', 11, '/11/218', '/浙江省/嘉兴市', 2);
INSERT INTO `sys_area` VALUES (219, '湖州市', 11, '/11/219', '/浙江省/湖州市', 2);
INSERT INTO `sys_area` VALUES (220, '绍兴市', 11, '/11/220', '/浙江省/绍兴市', 2);
INSERT INTO `sys_area` VALUES (221, '金华市', 11, '/11/221', '/浙江省/金华市', 2);
INSERT INTO `sys_area` VALUES (222, '衢州市', 11, '/11/222', '/浙江省/衢州市', 2);
INSERT INTO `sys_area` VALUES (223, '舟山市', 11, '/11/223', '/浙江省/舟山市', 2);
INSERT INTO `sys_area` VALUES (224, '台州市', 11, '/11/224', '/浙江省/台州市', 2);
INSERT INTO `sys_area` VALUES (225, '丽水市', 11, '/11/225', '/浙江省/丽水市', 2);
INSERT INTO `sys_area` VALUES (230, '合肥市', 12, '/12/230', '/安徽省/合肥市', 2);
INSERT INTO `sys_area` VALUES (231, '芜湖市', 12, '/12/231', '/安徽省/芜湖市', 2);
INSERT INTO `sys_area` VALUES (232, '蚌埠市', 12, '/12/232', '/安徽省/蚌埠市', 2);
INSERT INTO `sys_area` VALUES (233, '淮南市', 12, '/12/233', '/安徽省/淮南市', 2);
INSERT INTO `sys_area` VALUES (234, '马鞍山市', 12, '/12/234', '/安徽省/马鞍山市', 2);
INSERT INTO `sys_area` VALUES (235, '淮北市', 12, '/12/235', '/安徽省/淮北市', 2);
INSERT INTO `sys_area` VALUES (236, '铜陵市', 12, '/12/236', '/安徽省/铜陵市', 2);
INSERT INTO `sys_area` VALUES (237, '安庆市', 12, '/12/237', '/安徽省/安庆市', 2);
INSERT INTO `sys_area` VALUES (238, '黄山市', 12, '/12/238', '/安徽省/黄山市', 2);
INSERT INTO `sys_area` VALUES (239, '滁州市', 12, '/12/239', '/安徽省/滁州市', 2);
INSERT INTO `sys_area` VALUES (240, '阜阳市', 12, '/12/240', '/安徽省/阜阳市', 2);
INSERT INTO `sys_area` VALUES (241, '宿州市', 12, '/12/241', '/安徽省/宿州市', 2);
INSERT INTO `sys_area` VALUES (242, '六安市', 12, '/12/242', '/安徽省/六安市', 2);
INSERT INTO `sys_area` VALUES (243, '亳州市', 12, '/12/243', '/安徽省/亳州市', 2);
INSERT INTO `sys_area` VALUES (244, '池州市', 12, '/12/244', '/安徽省/池州市', 2);
INSERT INTO `sys_area` VALUES (245, '宣城市', 12, '/12/245', '/安徽省/宣城市', 2);
INSERT INTO `sys_area` VALUES (261, '福州市', 13, '/13/261', '/福建省/福州市', 2);
INSERT INTO `sys_area` VALUES (262, '厦门市', 13, '/13/262', '/福建省/厦门市', 2);
INSERT INTO `sys_area` VALUES (263, '莆田市', 13, '/13/263', '/福建省/莆田市', 2);
INSERT INTO `sys_area` VALUES (264, '三明市', 13, '/13/264', '/福建省/三明市', 2);
INSERT INTO `sys_area` VALUES (265, '泉州市', 13, '/13/265', '/福建省/泉州市', 2);
INSERT INTO `sys_area` VALUES (266, '漳州市', 13, '/13/266', '/福建省/漳州市', 2);
INSERT INTO `sys_area` VALUES (267, '南平市', 13, '/13/267', '/福建省/南平市', 2);
INSERT INTO `sys_area` VALUES (268, '龙岩市', 13, '/13/268', '/福建省/龙岩市', 2);
INSERT INTO `sys_area` VALUES (269, '宁德市', 13, '/13/269', '/福建省/宁德市', 2);
INSERT INTO `sys_area` VALUES (276, '南昌市', 14, '/14/276', '/江西省/南昌市', 2);
INSERT INTO `sys_area` VALUES (277, '景德镇市', 14, '/14/277', '/江西省/景德镇市', 2);
INSERT INTO `sys_area` VALUES (278, '萍乡市', 14, '/14/278', '/江西省/萍乡市', 2);
INSERT INTO `sys_area` VALUES (279, '九江市', 14, '/14/279', '/江西省/九江市', 2);
INSERT INTO `sys_area` VALUES (280, '新余市', 14, '/14/280', '/江西省/新余市', 2);
INSERT INTO `sys_area` VALUES (281, '鹰潭市', 14, '/14/281', '/江西省/鹰潭市', 2);
INSERT INTO `sys_area` VALUES (282, '赣州市', 14, '/14/282', '/江西省/赣州市', 2);
INSERT INTO `sys_area` VALUES (283, '吉安市', 14, '/14/283', '/江西省/吉安市', 2);
INSERT INTO `sys_area` VALUES (284, '宜春市', 14, '/14/284', '/江西省/宜春市', 2);
INSERT INTO `sys_area` VALUES (285, '抚州市', 14, '/14/285', '/江西省/抚州市', 2);
INSERT INTO `sys_area` VALUES (286, '上饶市', 14, '/14/286', '/江西省/上饶市', 2);
INSERT INTO `sys_area` VALUES (291, '济南市', 15, '/15/291', '/山东省/济南市', 2);
INSERT INTO `sys_area` VALUES (292, '青岛市', 15, '/15/292', '/山东省/青岛市', 2);
INSERT INTO `sys_area` VALUES (293, '淄博市', 15, '/15/293', '/山东省/淄博市', 2);
INSERT INTO `sys_area` VALUES (294, '枣庄市', 15, '/15/294', '/山东省/枣庄市', 2);
INSERT INTO `sys_area` VALUES (295, '东营市', 15, '/15/295', '/山东省/东营市', 2);
INSERT INTO `sys_area` VALUES (296, '烟台市', 15, '/15/296', '/山东省/烟台市', 2);
INSERT INTO `sys_area` VALUES (297, '潍坊市', 15, '/15/297', '/山东省/潍坊市', 2);
INSERT INTO `sys_area` VALUES (298, '济宁市', 15, '/15/298', '/山东省/济宁市', 2);
INSERT INTO `sys_area` VALUES (299, '泰安市', 15, '/15/299', '/山东省/泰安市', 2);
INSERT INTO `sys_area` VALUES (300, '威海市', 15, '/15/300', '/山东省/威海市', 2);
INSERT INTO `sys_area` VALUES (301, '日照市', 15, '/15/301', '/山东省/日照市', 2);
INSERT INTO `sys_area` VALUES (302, '莱芜市', 15, '/15/302', '/山东省/莱芜市', 2);
INSERT INTO `sys_area` VALUES (303, '临沂市', 15, '/15/303', '/山东省/临沂市', 2);
INSERT INTO `sys_area` VALUES (304, '德州市', 15, '/15/304', '/山东省/德州市', 2);
INSERT INTO `sys_area` VALUES (305, '聊城市', 15, '/15/305', '/山东省/聊城市', 2);
INSERT INTO `sys_area` VALUES (306, '滨州市', 15, '/15/306', '/山东省/滨州市', 2);
INSERT INTO `sys_area` VALUES (307, '菏泽市', 15, '/15/307', '/山东省/菏泽市', 2);
INSERT INTO `sys_area` VALUES (322, '郑州市', 16, '/16/322', '/河南省/郑州市', 2);
INSERT INTO `sys_area` VALUES (323, '开封市', 16, '/16/323', '/河南省/开封市', 2);
INSERT INTO `sys_area` VALUES (324, '洛阳市', 16, '/16/324', '/河南省/洛阳市', 2);
INSERT INTO `sys_area` VALUES (325, '平顶山市', 16, '/16/325', '/河南省/平顶山市', 2);
INSERT INTO `sys_area` VALUES (326, '安阳市', 16, '/16/326', '/河南省/安阳市', 2);
INSERT INTO `sys_area` VALUES (327, '鹤壁市', 16, '/16/327', '/河南省/鹤壁市', 2);
INSERT INTO `sys_area` VALUES (328, '新乡市', 16, '/16/328', '/河南省/新乡市', 2);
INSERT INTO `sys_area` VALUES (329, '焦作市', 16, '/16/329', '/河南省/焦作市', 2);
INSERT INTO `sys_area` VALUES (330, '濮阳市', 16, '/16/330', '/河南省/濮阳市', 2);
INSERT INTO `sys_area` VALUES (331, '许昌市', 16, '/16/331', '/河南省/许昌市', 2);
INSERT INTO `sys_area` VALUES (332, '漯河市', 16, '/16/332', '/河南省/漯河市', 2);
INSERT INTO `sys_area` VALUES (333, '三门峡市', 16, '/16/333', '/河南省/三门峡市', 2);
INSERT INTO `sys_area` VALUES (334, '南阳市', 16, '/16/334', '/河南省/南阳市', 2);
INSERT INTO `sys_area` VALUES (335, '商丘市', 16, '/16/335', '/河南省/商丘市', 2);
INSERT INTO `sys_area` VALUES (336, '信阳市', 16, '/16/336', '/河南省/信阳市', 2);
INSERT INTO `sys_area` VALUES (337, '周口市', 16, '/16/337', '/河南省/周口市', 2);
INSERT INTO `sys_area` VALUES (338, '驻马店市', 16, '/16/338', '/河南省/驻马店市', 2);
INSERT INTO `sys_area` VALUES (339, '省直辖县级行政区划', 16, '/16/339', '/河南省/省直辖县级行政区划', 2);
INSERT INTO `sys_area` VALUES (353, '武汉市', 17, '/17/353', '/湖北省/武汉市', 2);
INSERT INTO `sys_area` VALUES (354, '黄石市', 17, '/17/354', '/湖北省/黄石市', 2);
INSERT INTO `sys_area` VALUES (355, '十堰市', 17, '/17/355', '/湖北省/十堰市', 2);
INSERT INTO `sys_area` VALUES (356, '宜昌市', 17, '/17/356', '/湖北省/宜昌市', 2);
INSERT INTO `sys_area` VALUES (357, '襄阳市', 17, '/17/357', '/湖北省/襄阳市', 2);
INSERT INTO `sys_area` VALUES (358, '鄂州市', 17, '/17/358', '/湖北省/鄂州市', 2);
INSERT INTO `sys_area` VALUES (359, '荆门市', 17, '/17/359', '/湖北省/荆门市', 2);
INSERT INTO `sys_area` VALUES (360, '孝感市', 17, '/17/360', '/湖北省/孝感市', 2);
INSERT INTO `sys_area` VALUES (361, '荆州市', 17, '/17/361', '/湖北省/荆州市', 2);
INSERT INTO `sys_area` VALUES (362, '黄冈市', 17, '/17/362', '/湖北省/黄冈市', 2);
INSERT INTO `sys_area` VALUES (363, '咸宁市', 17, '/17/363', '/湖北省/咸宁市', 2);
INSERT INTO `sys_area` VALUES (364, '随州市', 17, '/17/364', '/湖北省/随州市', 2);
INSERT INTO `sys_area` VALUES (365, '恩施土家族苗族自治州', 17, '/17/365', '/湖北省/恩施土家族苗族自治州', 2);
INSERT INTO `sys_area` VALUES (366, '省直辖县级行政区划', 17, '/17/366', '/湖北省/省直辖县级行政区划', 2);
INSERT INTO `sys_area` VALUES (368, '长沙市', 18, '/18/368', '/湖南省/长沙市', 2);
INSERT INTO `sys_area` VALUES (369, '株洲市', 18, '/18/369', '/湖南省/株洲市', 2);
INSERT INTO `sys_area` VALUES (370, '湘潭市', 18, '/18/370', '/湖南省/湘潭市', 2);
INSERT INTO `sys_area` VALUES (371, '衡阳市', 18, '/18/371', '/湖南省/衡阳市', 2);
INSERT INTO `sys_area` VALUES (372, '邵阳市', 18, '/18/372', '/湖南省/邵阳市', 2);
INSERT INTO `sys_area` VALUES (373, '岳阳市', 18, '/18/373', '/湖南省/岳阳市', 2);
INSERT INTO `sys_area` VALUES (374, '常德市', 18, '/18/374', '/湖南省/常德市', 2);
INSERT INTO `sys_area` VALUES (375, '张家界市', 18, '/18/375', '/湖南省/张家界市', 2);
INSERT INTO `sys_area` VALUES (376, '益阳市', 18, '/18/376', '/湖南省/益阳市', 2);
INSERT INTO `sys_area` VALUES (377, '郴州市', 18, '/18/377', '/湖南省/郴州市', 2);
INSERT INTO `sys_area` VALUES (378, '永州市', 18, '/18/378', '/湖南省/永州市', 2);
INSERT INTO `sys_area` VALUES (379, '怀化市', 18, '/18/379', '/湖南省/怀化市', 2);
INSERT INTO `sys_area` VALUES (380, '娄底市', 18, '/18/380', '/湖南省/娄底市', 2);
INSERT INTO `sys_area` VALUES (381, '湘西土家族苗族自治州', 18, '/18/381', '/湖南省/湘西土家族苗族自治州', 2);
INSERT INTO `sys_area` VALUES (383, '广州市', 19, '/19/383', '/广东省/广州市', 2);
INSERT INTO `sys_area` VALUES (384, '韶关市', 19, '/19/384', '/广东省/韶关市', 2);
INSERT INTO `sys_area` VALUES (385, '深圳市', 19, '/19/385', '/广东省/深圳市', 2);
INSERT INTO `sys_area` VALUES (386, '珠海市', 19, '/19/386', '/广东省/珠海市', 2);
INSERT INTO `sys_area` VALUES (387, '汕头市', 19, '/19/387', '/广东省/汕头市', 2);
INSERT INTO `sys_area` VALUES (388, '佛山市', 19, '/19/388', '/广东省/佛山市', 2);
INSERT INTO `sys_area` VALUES (389, '江门市', 19, '/19/389', '/广东省/江门市', 2);
INSERT INTO `sys_area` VALUES (390, '湛江市', 19, '/19/390', '/广东省/湛江市', 2);
INSERT INTO `sys_area` VALUES (391, '茂名市', 19, '/19/391', '/广东省/茂名市', 2);
INSERT INTO `sys_area` VALUES (392, '肇庆市', 19, '/19/392', '/广东省/肇庆市', 2);
INSERT INTO `sys_area` VALUES (393, '惠州市', 19, '/19/393', '/广东省/惠州市', 2);
INSERT INTO `sys_area` VALUES (394, '梅州市', 19, '/19/394', '/广东省/梅州市', 2);
INSERT INTO `sys_area` VALUES (395, '汕尾市', 19, '/19/395', '/广东省/汕尾市', 2);
INSERT INTO `sys_area` VALUES (396, '河源市', 19, '/19/396', '/广东省/河源市', 2);
INSERT INTO `sys_area` VALUES (397, '阳江市', 19, '/19/397', '/广东省/阳江市', 2);
INSERT INTO `sys_area` VALUES (398, '清远市', 19, '/19/398', '/广东省/清远市', 2);
INSERT INTO `sys_area` VALUES (399, '东莞市', 19, '/19/399', '/广东省/东莞市', 2);
INSERT INTO `sys_area` VALUES (400, '中山市', 19, '/19/400', '/广东省/中山市', 2);
INSERT INTO `sys_area` VALUES (401, '潮州市', 19, '/19/401', '/广东省/潮州市', 2);
INSERT INTO `sys_area` VALUES (402, '揭阳市', 19, '/19/402', '/广东省/揭阳市', 2);
INSERT INTO `sys_area` VALUES (403, '云浮市', 19, '/19/403', '/广东省/云浮市', 2);
INSERT INTO `sys_area` VALUES (414, '海口市', 20, '/20/414', '/海南省/海口市', 2);
INSERT INTO `sys_area` VALUES (415, '三亚市', 20, '/20/415', '/海南省/三亚市', 2);
INSERT INTO `sys_area` VALUES (416, '三沙市', 20, '/20/416', '/海南省/三沙市', 2);
INSERT INTO `sys_area` VALUES (417, '省直辖县级行政区划', 20, '/20/417', '/海南省/省直辖县级行政区划', 2);
INSERT INTO `sys_area` VALUES (421, '南宁市', 21, '/21/421', '/广西壮族自治区/南宁市', 2);
INSERT INTO `sys_area` VALUES (422, '柳州市', 21, '/21/422', '/广西壮族自治区/柳州市', 2);
INSERT INTO `sys_area` VALUES (423, '桂林市', 21, '/21/423', '/广西壮族自治区/桂林市', 2);
INSERT INTO `sys_area` VALUES (424, '梧州市', 21, '/21/424', '/广西壮族自治区/梧州市', 2);
INSERT INTO `sys_area` VALUES (425, '北海市', 21, '/21/425', '/广西壮族自治区/北海市', 2);
INSERT INTO `sys_area` VALUES (426, '防城港市', 21, '/21/426', '/广西壮族自治区/防城港市', 2);
INSERT INTO `sys_area` VALUES (427, '钦州市', 21, '/21/427', '/广西壮族自治区/钦州市', 2);
INSERT INTO `sys_area` VALUES (428, '贵港市', 21, '/21/428', '/广西壮族自治区/贵港市', 2);
INSERT INTO `sys_area` VALUES (429, '玉林市', 21, '/21/429', '/广西壮族自治区/玉林市', 2);
INSERT INTO `sys_area` VALUES (430, '百色市', 21, '/21/430', '/广西壮族自治区/百色市', 2);
INSERT INTO `sys_area` VALUES (431, '贺州市', 21, '/21/431', '/广西壮族自治区/贺州市', 2);
INSERT INTO `sys_area` VALUES (432, '河池市', 21, '/21/432', '/广西壮族自治区/河池市', 2);
INSERT INTO `sys_area` VALUES (433, '来宾市', 21, '/21/433', '/广西壮族自治区/来宾市', 2);
INSERT INTO `sys_area` VALUES (434, '崇左市', 21, '/21/434', '/广西壮族自治区/崇左市', 2);
INSERT INTO `sys_area` VALUES (436, '兰州市', 22, '/22/436', '/甘肃省/兰州市', 2);
INSERT INTO `sys_area` VALUES (437, '嘉峪关市', 22, '/22/437', '/甘肃省/嘉峪关市', 2);
INSERT INTO `sys_area` VALUES (438, '金昌市', 22, '/22/438', '/甘肃省/金昌市', 2);
INSERT INTO `sys_area` VALUES (439, '白银市', 22, '/22/439', '/甘肃省/白银市', 2);
INSERT INTO `sys_area` VALUES (440, '天水市', 22, '/22/440', '/甘肃省/天水市', 2);
INSERT INTO `sys_area` VALUES (441, '武威市', 22, '/22/441', '/甘肃省/武威市', 2);
INSERT INTO `sys_area` VALUES (442, '张掖市', 22, '/22/442', '/甘肃省/张掖市', 2);
INSERT INTO `sys_area` VALUES (443, '平凉市', 22, '/22/443', '/甘肃省/平凉市', 2);
INSERT INTO `sys_area` VALUES (444, '酒泉市', 22, '/22/444', '/甘肃省/酒泉市', 2);
INSERT INTO `sys_area` VALUES (445, '庆阳市', 22, '/22/445', '/甘肃省/庆阳市', 2);
INSERT INTO `sys_area` VALUES (446, '定西市', 22, '/22/446', '/甘肃省/定西市', 2);
INSERT INTO `sys_area` VALUES (447, '陇南市', 22, '/22/447', '/甘肃省/陇南市', 2);
INSERT INTO `sys_area` VALUES (448, '临夏回族自治州', 22, '/22/448', '/甘肃省/临夏回族自治州', 2);
INSERT INTO `sys_area` VALUES (449, '甘南藏族自治州', 22, '/22/449', '/甘肃省/甘南藏族自治州', 2);
INSERT INTO `sys_area` VALUES (451, '西安市', 23, '/23/451', '/陕西省/西安市', 2);
INSERT INTO `sys_area` VALUES (452, '铜川市', 23, '/23/452', '/陕西省/铜川市', 2);
INSERT INTO `sys_area` VALUES (453, '宝鸡市', 23, '/23/453', '/陕西省/宝鸡市', 2);
INSERT INTO `sys_area` VALUES (454, '咸阳市', 23, '/23/454', '/陕西省/咸阳市', 2);
INSERT INTO `sys_area` VALUES (455, '渭南市', 23, '/23/455', '/陕西省/渭南市', 2);
INSERT INTO `sys_area` VALUES (456, '延安市', 23, '/23/456', '/陕西省/延安市', 2);
INSERT INTO `sys_area` VALUES (457, '汉中市', 23, '/23/457', '/陕西省/汉中市', 2);
INSERT INTO `sys_area` VALUES (458, '榆林市', 23, '/23/458', '/陕西省/榆林市', 2);
INSERT INTO `sys_area` VALUES (459, '安康市', 23, '/23/459', '/陕西省/安康市', 2);
INSERT INTO `sys_area` VALUES (460, '商洛市', 23, '/23/460', '/陕西省/商洛市', 2);
INSERT INTO `sys_area` VALUES (466, '乌鲁木齐市', 24, '/24/466', '/新疆维吾尔自治区/乌鲁木齐市', 2);
INSERT INTO `sys_area` VALUES (467, '克拉玛依市', 24, '/24/467', '/新疆维吾尔自治区/克拉玛依市', 2);
INSERT INTO `sys_area` VALUES (468, '吐鲁番地区', 24, '/24/468', '/新疆维吾尔自治区/吐鲁番地区', 2);
INSERT INTO `sys_area` VALUES (469, '哈密地区', 24, '/24/469', '/新疆维吾尔自治区/哈密地区', 2);
INSERT INTO `sys_area` VALUES (470, '昌吉回族自治州', 24, '/24/470', '/新疆维吾尔自治区/昌吉回族自治州', 2);
INSERT INTO `sys_area` VALUES (471, '博尔塔拉蒙古自治州', 24, '/24/471', '/新疆维吾尔自治区/博尔塔拉蒙古自治州', 2);
INSERT INTO `sys_area` VALUES (472, '巴音郭楞蒙古自治州', 24, '/24/472', '/新疆维吾尔自治区/巴音郭楞蒙古自治州', 2);
INSERT INTO `sys_area` VALUES (473, '阿克苏地区', 24, '/24/473', '/新疆维吾尔自治区/阿克苏地区', 2);
INSERT INTO `sys_area` VALUES (474, '克孜勒苏柯尔克孜自治州', 24, '/24/474', '/新疆维吾尔自治区/克孜勒苏柯尔克孜自治州', 2);
INSERT INTO `sys_area` VALUES (475, '喀什地区', 24, '/24/475', '/新疆维吾尔自治区/喀什地区', 2);
INSERT INTO `sys_area` VALUES (476, '和田地区', 24, '/24/476', '/新疆维吾尔自治区/和田地区', 2);
INSERT INTO `sys_area` VALUES (477, '伊犁哈萨克自治州', 24, '/24/477', '/新疆维吾尔自治区/伊犁哈萨克自治州', 2);
INSERT INTO `sys_area` VALUES (478, '塔城地区', 24, '/24/478', '/新疆维吾尔自治区/塔城地区', 2);
INSERT INTO `sys_area` VALUES (479, '阿勒泰地区', 24, '/24/479', '/新疆维吾尔自治区/阿勒泰地区', 2);
INSERT INTO `sys_area` VALUES (480, '自治区直辖县级行政区划', 24, '/24/480', '/新疆维吾尔自治区/自治区直辖县级行政区划', 2);
INSERT INTO `sys_area` VALUES (481, '西宁市', 25, '/25/481', '/青海省/西宁市', 2);
INSERT INTO `sys_area` VALUES (482, '海东地区', 25, '/25/482', '/青海省/海东地区', 2);
INSERT INTO `sys_area` VALUES (483, '海北藏族自治州', 25, '/25/483', '/青海省/海北藏族自治州', 2);
INSERT INTO `sys_area` VALUES (484, '黄南藏族自治州', 25, '/25/484', '/青海省/黄南藏族自治州', 2);
INSERT INTO `sys_area` VALUES (485, '海南藏族自治州', 25, '/25/485', '/青海省/海南藏族自治州', 2);
INSERT INTO `sys_area` VALUES (486, '果洛藏族自治州', 25, '/25/486', '/青海省/果洛藏族自治州', 2);
INSERT INTO `sys_area` VALUES (487, '玉树藏族自治州', 25, '/25/487', '/青海省/玉树藏族自治州', 2);
INSERT INTO `sys_area` VALUES (488, '海西蒙古族藏族自治州', 25, '/25/488', '/青海省/海西蒙古族藏族自治州', 2);
INSERT INTO `sys_area` VALUES (496, '银川市', 26, '/26/496', '/宁夏回族自治区/银川市', 2);
INSERT INTO `sys_area` VALUES (497, '石嘴山市', 26, '/26/497', '/宁夏回族自治区/石嘴山市', 2);
INSERT INTO `sys_area` VALUES (498, '吴忠市', 26, '/26/498', '/宁夏回族自治区/吴忠市', 2);
INSERT INTO `sys_area` VALUES (499, '固原市', 26, '/26/499', '/宁夏回族自治区/固原市', 2);
INSERT INTO `sys_area` VALUES (500, '中卫市', 26, '/26/500', '/宁夏回族自治区/中卫市', 2);
INSERT INTO `sys_area` VALUES (503, '成都市', 28, '/28/503', '/四川省/成都市', 2);
INSERT INTO `sys_area` VALUES (504, '自贡市', 28, '/28/504', '/四川省/自贡市', 2);
INSERT INTO `sys_area` VALUES (505, '攀枝花市', 28, '/28/505', '/四川省/攀枝花市', 2);
INSERT INTO `sys_area` VALUES (506, '泸州市', 28, '/28/506', '/四川省/泸州市', 2);
INSERT INTO `sys_area` VALUES (507, '德阳市', 28, '/28/507', '/四川省/德阳市', 2);
INSERT INTO `sys_area` VALUES (508, '绵阳市', 28, '/28/508', '/四川省/绵阳市', 2);
INSERT INTO `sys_area` VALUES (509, '广元市', 28, '/28/509', '/四川省/广元市', 2);
INSERT INTO `sys_area` VALUES (510, '遂宁市', 28, '/28/510', '/四川省/遂宁市', 2);
INSERT INTO `sys_area` VALUES (511, '内江市', 28, '/28/511', '/四川省/内江市', 2);
INSERT INTO `sys_area` VALUES (512, '乐山市', 28, '/28/512', '/四川省/乐山市', 2);
INSERT INTO `sys_area` VALUES (513, '南充市', 28, '/28/513', '/四川省/南充市', 2);
INSERT INTO `sys_area` VALUES (514, '眉山市', 28, '/28/514', '/四川省/眉山市', 2);
INSERT INTO `sys_area` VALUES (515, '宜宾市', 28, '/28/515', '/四川省/宜宾市', 2);
INSERT INTO `sys_area` VALUES (516, '广安市', 28, '/28/516', '/四川省/广安市', 2);
INSERT INTO `sys_area` VALUES (517, '达州市', 28, '/28/517', '/四川省/达州市', 2);
INSERT INTO `sys_area` VALUES (518, '雅安市', 28, '/28/518', '/四川省/雅安市', 2);
INSERT INTO `sys_area` VALUES (519, '巴中市', 28, '/28/519', '/四川省/巴中市', 2);
INSERT INTO `sys_area` VALUES (520, '资阳市', 28, '/28/520', '/四川省/资阳市', 2);
INSERT INTO `sys_area` VALUES (521, '阿坝藏族羌族自治州', 28, '/28/521', '/四川省/阿坝藏族羌族自治州', 2);
INSERT INTO `sys_area` VALUES (522, '甘孜藏族自治州', 28, '/28/522', '/四川省/甘孜藏族自治州', 2);
INSERT INTO `sys_area` VALUES (523, '凉山彝族自治州', 28, '/28/523', '/四川省/凉山彝族自治州', 2);
INSERT INTO `sys_area` VALUES (534, '贵阳市', 29, '/29/534', '/贵州省/贵阳市', 2);
INSERT INTO `sys_area` VALUES (535, '六盘水市', 29, '/29/535', '/贵州省/六盘水市', 2);
INSERT INTO `sys_area` VALUES (536, '遵义市', 29, '/29/536', '/贵州省/遵义市', 2);
INSERT INTO `sys_area` VALUES (537, '安顺市', 29, '/29/537', '/贵州省/安顺市', 2);
INSERT INTO `sys_area` VALUES (538, '毕节市', 29, '/29/538', '/贵州省/毕节市', 2);
INSERT INTO `sys_area` VALUES (539, '铜仁市', 29, '/29/539', '/贵州省/铜仁市', 2);
INSERT INTO `sys_area` VALUES (540, '黔西南布依族苗族自治州', 29, '/29/540', '/贵州省/黔西南布依族苗族自治州', 2);
INSERT INTO `sys_area` VALUES (541, '黔东南苗族侗族自治州', 29, '/29/541', '/贵州省/黔东南苗族侗族自治州', 2);
INSERT INTO `sys_area` VALUES (542, '黔南布依族苗族自治州', 29, '/29/542', '/贵州省/黔南布依族苗族自治州', 2);
INSERT INTO `sys_area` VALUES (549, '昆明市', 30, '/30/549', '/云南省/昆明市', 2);
INSERT INTO `sys_area` VALUES (550, '曲靖市', 30, '/30/550', '/云南省/曲靖市', 2);
INSERT INTO `sys_area` VALUES (551, '玉溪市', 30, '/30/551', '/云南省/玉溪市', 2);
INSERT INTO `sys_area` VALUES (552, '保山市', 30, '/30/552', '/云南省/保山市', 2);
INSERT INTO `sys_area` VALUES (553, '昭通市', 30, '/30/553', '/云南省/昭通市', 2);
INSERT INTO `sys_area` VALUES (554, '丽江市', 30, '/30/554', '/云南省/丽江市', 2);
INSERT INTO `sys_area` VALUES (555, '普洱市', 30, '/30/555', '/云南省/普洱市', 2);
INSERT INTO `sys_area` VALUES (556, '临沧市', 30, '/30/556', '/云南省/临沧市', 2);
INSERT INTO `sys_area` VALUES (557, '楚雄彝族自治州', 30, '/30/557', '/云南省/楚雄彝族自治州', 2);
INSERT INTO `sys_area` VALUES (558, '红河哈尼族彝族自治州', 30, '/30/558', '/云南省/红河哈尼族彝族自治州', 2);
INSERT INTO `sys_area` VALUES (559, '文山壮族苗族自治州', 30, '/30/559', '/云南省/文山壮族苗族自治州', 2);
INSERT INTO `sys_area` VALUES (560, '西双版纳傣族自治州', 30, '/30/560', '/云南省/西双版纳傣族自治州', 2);
INSERT INTO `sys_area` VALUES (561, '大理白族自治州', 30, '/30/561', '/云南省/大理白族自治州', 2);
INSERT INTO `sys_area` VALUES (562, '德宏傣族景颇族自治州', 30, '/30/562', '/云南省/德宏傣族景颇族自治州', 2);
INSERT INTO `sys_area` VALUES (563, '怒江傈僳族自治州', 30, '/30/563', '/云南省/怒江傈僳族自治州', 2);
INSERT INTO `sys_area` VALUES (564, '迪庆藏族自治州', 30, '/30/564', '/云南省/迪庆藏族自治州', 2);
INSERT INTO `sys_area` VALUES (580, '拉萨市', 31, '/31/580', '/西藏自治区/拉萨市', 2);
INSERT INTO `sys_area` VALUES (581, '昌都地区', 31, '/31/581', '/西藏自治区/昌都地区', 2);
INSERT INTO `sys_area` VALUES (582, '山南地区', 31, '/31/582', '/西藏自治区/山南地区', 2);
INSERT INTO `sys_area` VALUES (583, '日喀则地区', 31, '/31/583', '/西藏自治区/日喀则地区', 2);
INSERT INTO `sys_area` VALUES (584, '那曲地区', 31, '/31/584', '/西藏自治区/那曲地区', 2);
INSERT INTO `sys_area` VALUES (585, '阿里地区', 31, '/31/585', '/西藏自治区/阿里地区', 2);
INSERT INTO `sys_area` VALUES (586, '林芝地区', 31, '/31/586', '/西藏自治区/林芝地区', 2);

-- ----------------------------
-- Table structure for sys_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父节点ID',
  `code` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '编码',
  `label` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '名称',
  `description` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `extend` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dictionary
-- ----------------------------
INSERT INTO `sys_dictionary` VALUES (0, NULL, 'root', '全部', '根节点', NULL, NULL);
INSERT INTO `sys_dictionary` VALUES (7, 0, 'ICON', '图标', 'element-ui的icon图标，父节点', '', '');
INSERT INTO `sys_dictionary` VALUES (8, 7, 'el-icon-info', 'el-icon-info', '', '', '');
INSERT INTO `sys_dictionary` VALUES (9, 7, 'el-icon-error', 'el-icon-error', '', '', '');
INSERT INTO `sys_dictionary` VALUES (10, 7, 'el-icon-success', 'el-icon-success', '', '', '');
INSERT INTO `sys_dictionary` VALUES (11, 7, 'el-icon-warning', 'el-icon-warning', '', '', '');
INSERT INTO `sys_dictionary` VALUES (12, 7, 'el-icon-question', 'el-icon-question', '', '', '');
INSERT INTO `sys_dictionary` VALUES (13, 7, 'el-icon-back', 'el-icon-back', '', '', '');
INSERT INTO `sys_dictionary` VALUES (14, 7, 'el-icon-arrow-left', 'el-icon-arrow-left', '', '', '');
INSERT INTO `sys_dictionary` VALUES (15, 7, 'el-icon-arrow-down', 'el-icon-arrow-down', '', '', '');
INSERT INTO `sys_dictionary` VALUES (16, 7, 'el-icon-arrow-right', 'el-icon-arrow-right', '', '', '');
INSERT INTO `sys_dictionary` VALUES (17, 7, 'el-icon-arrow-up', 'el-icon-arrow-up', '', '', '');
INSERT INTO `sys_dictionary` VALUES (18, 7, 'el-icon-caret-left', 'el-icon-caret-left', '', '', '');
INSERT INTO `sys_dictionary` VALUES (19, 7, 'el-icon-caret-bottom', 'el-icon-caret-bottom', '', '', '');
INSERT INTO `sys_dictionary` VALUES (20, 7, 'el-icon-caret-top', 'el-icon-caret-top', '', '', '');
INSERT INTO `sys_dictionary` VALUES (21, 7, 'el-icon-caret-right', 'el-icon-caret-right', '', '', '');
INSERT INTO `sys_dictionary` VALUES (22, 7, 'el-icon-d-arrow-left', 'el-icon-d-arrow-left', '', '', '');
INSERT INTO `sys_dictionary` VALUES (23, 7, 'el-icon-d-arrow-right', 'el-icon-d-arrow-right', '', '', '');
INSERT INTO `sys_dictionary` VALUES (24, 7, 'el-icon-minus', 'el-icon-minus', '', '', '');
INSERT INTO `sys_dictionary` VALUES (25, 7, 'el-icon-plus', 'el-icon-plus', '', '', '');
INSERT INTO `sys_dictionary` VALUES (26, 7, 'el-icon-remove', 'el-icon-remove', '', '', '');
INSERT INTO `sys_dictionary` VALUES (27, 7, 'el-icon-circle-plus', 'el-icon-circle-plus', '', '', '');
INSERT INTO `sys_dictionary` VALUES (28, 7, 'el-icon-remove-outline', 'el-icon-remove-outline', '', '', '');
INSERT INTO `sys_dictionary` VALUES (29, 7, 'el-icon-circle-plus-outline', 'el-icon-circle-plus-outline', '', '', '');
INSERT INTO `sys_dictionary` VALUES (30, 7, 'el-icon-close', 'el-icon-close', '', '', '');
INSERT INTO `sys_dictionary` VALUES (31, 7, 'el-icon-check', 'el-icon-check', '', '', '');
INSERT INTO `sys_dictionary` VALUES (32, 7, 'el-icon-circle-close', 'el-icon-circle-close', '', '', '');
INSERT INTO `sys_dictionary` VALUES (33, 7, 'el-icon-circle-check', 'el-icon-circle-check', '', '', '');
INSERT INTO `sys_dictionary` VALUES (34, 7, 'el-icon-circle-close-outline', 'el-icon-circle-close-outline', '', '', '');
INSERT INTO `sys_dictionary` VALUES (35, 7, 'el-icon-circle-check-outline', 'el-icon-circle-check-outline', '', '', '');
INSERT INTO `sys_dictionary` VALUES (36, 7, 'el-icon-zoom-out', 'el-icon-zoom-out', '', '', '');
INSERT INTO `sys_dictionary` VALUES (37, 7, 'el-icon-zoom-in', 'el-icon-zoom-in', '', '', '');
INSERT INTO `sys_dictionary` VALUES (38, 7, 'el-icon-d-caret', 'el-icon-d-caret', '', '', '');
INSERT INTO `sys_dictionary` VALUES (39, 7, 'el-icon-sort', 'el-icon-sort', '', '', '');
INSERT INTO `sys_dictionary` VALUES (40, 7, 'el-icon-sort-down', 'el-icon-sort-down', '', '', '');
INSERT INTO `sys_dictionary` VALUES (41, 7, 'el-icon-sort-up', 'el-icon-sort-up', '', '', '');
INSERT INTO `sys_dictionary` VALUES (42, 7, 'el-icon-tickets', 'el-icon-tickets', '', '', '');
INSERT INTO `sys_dictionary` VALUES (43, 7, 'el-icon-document', 'el-icon-document', '', '', '');
INSERT INTO `sys_dictionary` VALUES (44, 7, 'el-icon-goods', 'el-icon-goods', '', '', '');
INSERT INTO `sys_dictionary` VALUES (45, 7, 'el-icon-sold-out', 'el-icon-sold-out', '', '', '');
INSERT INTO `sys_dictionary` VALUES (46, 7, 'el-icon-news', 'el-icon-news', '', '', '');
INSERT INTO `sys_dictionary` VALUES (47, 7, 'el-icon-message', 'el-icon-message', '', '', '');
INSERT INTO `sys_dictionary` VALUES (48, 7, 'el-icon-date', 'el-icon-date', '', '', '');
INSERT INTO `sys_dictionary` VALUES (49, 7, 'el-icon-printer', 'el-icon-printer', '', '', '');
INSERT INTO `sys_dictionary` VALUES (50, 7, 'el-icon-time', 'el-icon-time', '', '', '');
INSERT INTO `sys_dictionary` VALUES (51, 7, 'el-icon-bell', 'el-icon-bell', '', '', '');
INSERT INTO `sys_dictionary` VALUES (52, 7, 'el-icon-mobile-phone', 'el-icon-mobile-phone', '', '', '');
INSERT INTO `sys_dictionary` VALUES (53, 7, 'el-icon-service', 'el-icon-service', '', '', '');
INSERT INTO `sys_dictionary` VALUES (54, 7, 'el-icon-view', 'el-icon-view', '', '', '');
INSERT INTO `sys_dictionary` VALUES (55, 7, 'el-icon-menu', 'el-icon-menu', '', '', '');
INSERT INTO `sys_dictionary` VALUES (56, 7, 'el-icon-more', 'el-icon-more', '', '', '');
INSERT INTO `sys_dictionary` VALUES (57, 7, 'el-icon-more-outline', 'el-icon-more-outline', '', '', '');
INSERT INTO `sys_dictionary` VALUES (58, 7, 'el-icon-star-on', 'el-icon-star-on', '', '', '');
INSERT INTO `sys_dictionary` VALUES (59, 7, 'el-icon-star-off', 'el-icon-star-off', '', '', '');
INSERT INTO `sys_dictionary` VALUES (60, 7, 'el-icon-location', 'el-icon-location', '', '', '');
INSERT INTO `sys_dictionary` VALUES (61, 7, 'el-icon-location-outline', 'el-icon-location-outline', '', '', '');
INSERT INTO `sys_dictionary` VALUES (62, 7, 'el-icon-phone', 'el-icon-phone', '', '', '');
INSERT INTO `sys_dictionary` VALUES (63, 7, 'el-icon-phone-outline', 'el-icon-phone-outline', '', '', '');
INSERT INTO `sys_dictionary` VALUES (64, 7, 'el-icon-picture', 'el-icon-picture', '', '', '');
INSERT INTO `sys_dictionary` VALUES (65, 7, 'el-icon-picture-outline', 'el-icon-picture-outline', '', '', '');
INSERT INTO `sys_dictionary` VALUES (66, 7, 'el-icon-delete', 'el-icon-delete', '', '', '');
INSERT INTO `sys_dictionary` VALUES (67, 7, 'el-icon-search', 'el-icon-search', '', '', '');
INSERT INTO `sys_dictionary` VALUES (68, 7, 'el-icon-edit', 'el-icon-edit', '', '', '');
INSERT INTO `sys_dictionary` VALUES (69, 7, 'el-icon-edit-outline', 'el-icon-edit-outline', '', '', '');
INSERT INTO `sys_dictionary` VALUES (70, 7, 'el-icon-rank', 'el-icon-rank', '', '', '');
INSERT INTO `sys_dictionary` VALUES (71, 7, 'el-icon-refresh', 'el-icon-refresh', '', '', '');
INSERT INTO `sys_dictionary` VALUES (72, 7, 'el-icon-share', 'el-icon-share', '', '', '');
INSERT INTO `sys_dictionary` VALUES (73, 7, 'el-icon-setting', 'el-icon-setting', '', '', '');
INSERT INTO `sys_dictionary` VALUES (74, 7, 'el-icon-upload', 'el-icon-upload', '', '', '');
INSERT INTO `sys_dictionary` VALUES (75, 7, 'el-icon-upload2', 'el-icon-upload2', '', '', '');
INSERT INTO `sys_dictionary` VALUES (76, 7, 'el-icon-download', 'el-icon-download', '', '', '');
INSERT INTO `sys_dictionary` VALUES (77, 7, 'el-icon-loading', 'el-icon-loading', '', '', '');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级目录编码',
  `label` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类别：有子目录的branch，没有子目录的leaf，按钮button',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '路径',
  `available` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否可用',
  `icon` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_sys_resource_parent_code`(`parent_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 103 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统-功能权限' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (0, NULL, '全部', 'root', NULL, 1, NULL);
INSERT INTO `sys_permission` VALUES (1, 0, '首页', 'leaf', '', 1, NULL);
INSERT INTO `sys_permission` VALUES (86, 0, '初始设置', 'branch', '', 1, 'el-icon-star-off');
INSERT INTO `sys_permission` VALUES (87, 86, '编码管理', 'leaf', 'increment', 1, 'el-icon-document');
INSERT INTO `sys_permission` VALUES (88, 86, '地区管理', 'leaf', 'area', 1, 'el-icon-document');
INSERT INTO `sys_permission` VALUES (89, 86, '字典管理', 'leaf', 'dictionary', 1, 'el-icon-document');
INSERT INTO `sys_permission` VALUES (90, 86, '权限管理', 'leaf', 'permission', 1, 'el-icon-document');
INSERT INTO `sys_permission` VALUES (91, 0, '系统管理', 'branch', '', 1, 'el-icon-setting');
INSERT INTO `sys_permission` VALUES (92, 91, '角色管理', 'leaf', 'role', 1, 'el-icon-document');
INSERT INTO `sys_permission` VALUES (93, 91, '用户管理', 'leaf', 'user', 1, 'el-icon-document');
INSERT INTO `sys_permission` VALUES (94, 91, '日志管理', 'leaf', 'log', 0, 'el-icon-document');
INSERT INTO `sys_permission` VALUES (95, 0, '公司管理', 'branch', '', 1, 'el-icon-goods');
INSERT INTO `sys_permission` VALUES (96, 95, '组织管理', 'leaf', 'org', 1, 'el-icon-document');
INSERT INTO `sys_permission` VALUES (97, 95, '岗位管理', 'leaf', 'post', 1, 'el-icon-document');
INSERT INTO `sys_permission` VALUES (98, 95, '员工管理', 'leaf', 'hr', 1, 'el-icon-document');
INSERT INTO `sys_permission` VALUES (99, 0, '业务管理', 'branch', '', 1, 'el-icon-caret-bottom');
INSERT INTO `sys_permission` VALUES (100, 99, '分销管理', 'leaf', 'allot', 1, 'el-icon-document');
INSERT INTO `sys_permission` VALUES (101, 99, '客户管理', 'leaf', 'customer', 1, 'el-icon-document');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编码',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `resource_ids` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '功能权限拼串',
  `project` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 169 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统-角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (156, 'root', '超级管理员', '0,1,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102', 'pitaya-pc');
INSERT INTO `sys_role` VALUES (157, 'CM', '公司管理员', '1,95,96,97,98', 'pitaya-pc');
INSERT INTO `sys_role` VALUES (158, 'BM', '业务管理员', '1,99,100,101', 'pitaya-pc');
INSERT INTO `sys_role` VALUES (159, 'SA', '系统管理员', '1,91,92,93,94', 'pitaya-pc');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户编码，可用于登录',
  `nick_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称，可用于登录',
  `real_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号，可用于登录',
  `id_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证号',
  `province` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '现居住省份',
  `city` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '现居住城市',
  `wechat` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '微信号',
  `qq` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'QQ号',
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `roles` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色拼串',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `u_code`(`code`) USING BTREE,
  UNIQUE INDEX `u_nick_name`(`nick_name`) USING BTREE,
  UNIQUE INDEX `u_phone`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 154 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统-用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (122, 'ID-47b1fd9a0ccd00fd2a099', 'N-a418ba8acd008', '罗晋', '698d51a19d8a121ce581499d7b701668', '13500000001', '130622198612224037', '8', '165', 'luo777', '77778888', 'luo@139.com', 'CCC', '2018-05-10 17:58:55');
INSERT INTO `sys_user` VALUES (123, 'ID-47b1fd9a0ccf9f2b677b4', 'N-a418ba8acfa04', '刘烨', '698d51a19d8a121ce581499d7b701668', '13500000002', '420503197901131611', '7', '141', 'y888555', '88885555', 'ye@qq.com', 'DDD', '2018-05-10 17:58:43');
INSERT INTO `sys_user` VALUES (124, 'ID-47b1fd9a0cd26812644e85', 'N-a418ba8ad2684', '黄晓明', '698d51a19d8a121ce581499d7b701668', '13500000003', '371521198310050135', '8', '156', 'ming666', '66669999', 'ming@126.com', 'BBB', '2018-05-10 17:58:32');
INSERT INTO `sys_user` VALUES (127, 'ID-47b1fd9a4e41ae595993c', 'S-001', '胡军', '698d51a19d8a121ce581499d7b701668', '13800001111', '360521198212106956', '1', '39', '13800001111', '11110000', 'huju@qq.com', 'EEE,DDD', '2018-05-10 17:58:20');
INSERT INTO `sys_user` VALUES (128, 'ID-47b1fd9a4ff60232a85fad', 'S-002', '张涵予', '698d51a19d8a121ce581499d7b701668', '13800002222', '14072319900405903X', '7', '143', '13800002222', '123456', 'zhy@qq.com', 'DDD,CCC', '2018-05-10 17:58:01');
INSERT INTO `sys_user` VALUES (129, 'ID-47b1fd9a51a0041208c504', 'S-003', '古力娜扎', '698d51a19d8a121ce581499d7b701668', '13500001111', '445200198806165140', '5', '121', '13500001111', '22223333', 'guli@qq.com', 'CCC', '2018-05-10 17:57:45');
INSERT INTO `sys_user` VALUES (130, 'ID-47b1fd9a53102e343d4fac', 'S-004', '迪丽热巴', '698d51a19d8a121ce581499d7b701668', '13600001111', '120103199111137927', '5', '119', '13600001111', '136000', '136000@qq.com', 'DDD', '2018-05-10 17:57:31');
INSERT INTO `sys_user` VALUES (131, 'ID-47b1fd9a54b50f31faaa34', 'S-005', '孙红雷', '698d51a19d8a121ce581499d7b701668', '13988888888', '230826197901144733', '2', '55', '13988888888', '22228888', '005@163.com', 'BBB', '2018-05-10 17:57:14');
INSERT INTO `sys_user` VALUES (132, 'ID-47b1fd9a57434039b966ba', 'S-006', '张子健', '698d51a19d8a121ce581499d7b701668', '13911115555', '51050019751125343X', '4', '96', '13911115555', '523652', '523652@qq.com', 'CCC', '2018-05-10 17:57:06');
INSERT INTO `sys_user` VALUES (133, 'ID-47b1fd9a59329012029ec3', 'S-007', '薛之谦', '698d51a19d8a121ce581499d7b701668', '13100000002', '330103198205256876', '5', '114', '13100000002', '982052', '982052@qq.com', 'EEE', '2018-05-10 17:56:50');
INSERT INTO `sys_user` VALUES (134, 'ID-47b1fd9a5c8ff036f3be57', 'S-008', '张子文', '698d51a19d8a121ce581499d7b701668', '13922220000', '130525199302250342', '4', '103', '13566662222', '9302', '9302@qq.com', 'DDD', '2018-05-10 17:56:32');
INSERT INTO `sys_user` VALUES (135, 'ID-47b1fd9a5f12432ddc79a7', 'S-009', '杨紫', '698d51a19d8a121ce581499d7b701668', '13100000005', '512002198501214287', '10', '205', '13100000005', '031991111', '031991111@qq.com', 'CCC', '2018-05-10 17:56:23');
INSERT INTO `sys_user` VALUES (140, 'ID-47b1fd9ba46ff126a08041', 'shishi', '刘师师', '698d51a19d8a121ce581499d7b701668', '13111111112', '361130198507077449', '3', '83', 'shi888', '66667778', 'shi@126.com', 'BBB', '2018-05-10 17:56:15');
INSERT INTO `sys_user` VALUES (148, 'ID-47b1fe8842aea324a3e0ee', 'N-a419a8c0aea38', '唐嫣', '698d51a19d8a121ce581499d7b701668', '13100000000', '', '1', '36', NULL, NULL, NULL, 'CM,BM', '2018-05-18 16:07:29');
INSERT INTO `sys_user` VALUES (153, 'ID-47b213bac47081d6ac942', 'root', '超级管理员', '698d51a19d8a121ce581499d7b701668', '13552979387', '230502198803121113', '1', '42', '', '', '', 'root', '2018-05-21 15:41:33');

-- ----------------------------
-- Table structure for t_hr
-- ----------------------------
DROP TABLE IF EXISTS `t_hr`;
CREATE TABLE `t_hr`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '工号',
  `label` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `emp_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `org_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '上级组织编码',
  `post_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '岗位编码',
  `full_name` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '全名称',
  `full_path` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '全路径',
  `id_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '身份证号码',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '手机号码',
  `emergency_contact` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '紧急联系人',
  `emergency_contact_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '紧急联系人电话',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '工作邮箱',
  `marital_status` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '婚姻状况，1：未婚，2：已婚，3：离异 4：丧偶',
  `national` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '民族',
  `political` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '政治面貌',
  `degree` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '学历',
  `native_place` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '籍贯',
  `domicile_place` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '户口所在地',
  `work_date` datetime DEFAULT NULL COMMENT '参加工作日期',
  `entry_date` datetime DEFAULT NULL COMMENT '入职日期',
  `rank_name` varchar(300) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '职级名称',
  `regular` tinyint(1) DEFAULT NULL COMMENT '是否转正',
  `regular_date` datetime DEFAULT NULL COMMENT '转正日期',
  `work_age` double(5, 1) DEFAULT NULL COMMENT '司龄',
  `work_status` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '在职' COMMENT '在职状态',
  `available` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否可用',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `u_id_num`(`id_num`) USING BTREE,
  UNIQUE INDEX `u_phone`(`phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_org
-- ----------------------------
DROP TABLE IF EXISTS `t_org`;
CREATE TABLE `t_org`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '编码',
  `label` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '名称',
  `parent_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '父编码',
  `full_name` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '全名称',
  `full_path` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '全路径',
  `available` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否可用',
  `level` int(1) DEFAULT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `u_code`(`id`) USING BTREE,
  UNIQUE INDEX `u_name`(`label`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '组织表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_org
-- ----------------------------
INSERT INTO `t_org` VALUES ('0', '全部', '-1', '', '', 1, 0, '2018-06-01 09:18:23', '2018-06-01 09:19:40');
INSERT INTO `t_org` VALUES ('O-a4417af9cc601', '太平洋科技有限公司', '0', '/太平洋科技有限公司', '/O-a4417af9cc601', 1, 1, '2018-06-01 14:44:54', '2018-06-01 16:55:47');
INSERT INTO `t_org` VALUES ('O-a4417b10d58a4', '北京思格玛软件公司', '0', '/北京思格玛软件公司', '/O-a4417b10d58a4', 1, 1, '2018-06-01 14:46:14', '2018-06-01 17:02:05');
INSERT INTO `t_org` VALUES ('O-a4417b1379782', '思锐创途有限公司', '0', '/思锐创途有限公司', '/O-a4417b1379782', 1, 1, '2018-06-01 14:47:27', '2018-06-01 17:03:13');
INSERT INTO `t_org` VALUES ('O-a4417b157c737', '云瑞国际', '0', '/云瑞国际', '/O-a4417b157c737', 1, 1, '2018-06-01 14:48:58', '2018-06-01 17:03:17');
INSERT INTO `t_org` VALUES ('O-a4417b167eaf8', '北京阿方提科技有限公司', '0', '/北京阿方提科技有限公司', '/O-a4417b167eaf8', 1, 1, '2018-06-01 14:49:23', '2018-06-01 17:03:23');
INSERT INTO `t_org` VALUES ('O-a4417b218af28', '东方银谷', '0', '/东方银谷', '/O-a4417b218af28', 1, 1, '2018-06-01 14:56:37', '2018-06-01 17:03:28');
INSERT INTO `t_org` VALUES ('O-a4417b22c7b05', '金融科技与系统研发部', 'O-a4417b218af28', '/东方银谷/金融科技与系统研发部', '/O-a4417b218af28/O-a4417b22c7b05', 1, 2, '2018-06-01 14:57:32', '2018-06-01 17:03:36');
INSERT INTO `t_org` VALUES ('O-a4417b2503657', '行政', 'O-a4417b218af28', '/东方银谷/行政', '/O-a4417b218af28/O-a4417b2503657', 1, 2, '2018-06-01 14:59:14', '2018-06-01 17:03:51');
INSERT INTO `t_org` VALUES ('O-a4417b2609f61', '人力资源', 'O-a4417b218af28', '/东方银谷/人力资源', '/O-a4417b218af28/O-a4417b2609f61', 1, 2, '2018-06-01 14:59:25', '2018-06-01 17:03:54');
INSERT INTO `t_org` VALUES ('O-a4417b26418f2', '研发一部', 'O-a4417b22c7b05', '/东方银谷/金融科技与系统研发部/研发一部', '/O-a4417b218af28/O-a4417b22c7b05/O-a4417b26418f2', 1, 3, '2018-06-01 14:59:42', '2018-06-01 17:03:42');
INSERT INTO `t_org` VALUES ('O-a4417b26750f2', '研发二部', 'O-a4417b22c7b05', '/东方银谷/金融科技与系统研发部/研发二部', '/O-a4417b218af28/O-a4417b22c7b05/O-a4417b26750f2', 1, 3, '2018-06-01 14:59:52', '2018-06-01 17:03:44');
INSERT INTO `t_org` VALUES ('O-a4417b2696032', '研发三部', 'O-a4417b22c7b05', '/东方银谷/金融科技与系统研发部/研发三部', '/O-a4417b218af28/O-a4417b22c7b05/O-a4417b2696032', 1, 3, '2018-06-01 15:00:02', '2018-06-01 17:03:47');

-- ----------------------------
-- Table structure for t_post
-- ----------------------------
DROP TABLE IF EXISTS `t_post`;
CREATE TABLE `t_post`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '编码 ',
  `label` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '名称',
  `org_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '父组织编码',
  `full_name` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '全路径(组织+岗位名称)',
  `full_path` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '全路径（组织路径+岗位名称）	',
  `available` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否可用',
  `level` int(1) NOT NULL COMMENT '级别',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '岗位表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_post
-- ----------------------------
INSERT INTO `t_post` VALUES ('P-a4417cace9c67', '总经理', 'O-a4417af9cc601', '/太平洋科技有限公司/总经理', '/O-a4417af9cc601/P-a4417cace9c67', 1, 2, '2018-06-01 17:15:48', '2018-06-05 18:47:10');

SET FOREIGN_KEY_CHECKS = 1;
