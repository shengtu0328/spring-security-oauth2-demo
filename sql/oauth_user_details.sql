
CREATE TABLE `oauth_user_details`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of oauth_user_details
-- ----------------------------
INSERT INTO `oauth_user_details` VALUES ('1', 'USER1', '$2a$10$/JoHmaTpOvNXWhWV/6paX.WtjOZ1Ks0yQy7SgLqft6vN5/SCIltXK', '2020-02-24 16:20:54', '2020-02-24 16:20:56');

SET FOREIGN_KEY_CHECKS = 1;
