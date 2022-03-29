-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `name` varchar(32)  NULL DEFAULT NULL,
                         PRIMARY KEY (`id`)
);

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ROLE_vip0');
INSERT INTO `role` VALUES (2, 'ROLE_vip1');
INSERT INTO `role` VALUES (3, 'ROLE_vip2');
INSERT INTO `role` VALUES (4, 'ROLE_vip3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER`  (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `username` varchar(32)  NULL DEFAULT NULL,
                         `password` varchar(255)  NULL DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `USER` VALUES (1, 'root', '$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqilXzbz50dceRsga.WYiq');
INSERT INTO `USER` VALUES (3, '灰太狼', '$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqilXzbz50dceRsga.WYiq');
INSERT INTO `USER` VALUES (4, '喜羊羊', '$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqilXzbz50dceRsga.WYiq');
INSERT INTO `USER` VALUES (5, '懒羊羊', '$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqilXzbz50dceRsga.WYiq');
INSERT INTO `USER` VALUES (6, '小灰灰', '$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqilXzbz50dceRsga.WYiq');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
                              `id` int(11) NOT NULL AUTO_INCREMENT,
                              `uid` int(11) NULL DEFAULT NULL,
                              `rid` int(11) NULL DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (2, 1, 2);
INSERT INTO `user_role` VALUES (3, 1, 3);
INSERT INTO `user_role` VALUES (4, 1, 4);
INSERT INTO `user_role` VALUES (5, 3, 2);
INSERT INTO `user_role` VALUES (6, 4, 3);
INSERT INTO `user_role` VALUES (7, 6, 4);
INSERT INTO `user_role` VALUES (8, 5, 1);

