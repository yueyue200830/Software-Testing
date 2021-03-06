/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : timeline

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 14/11/2019 19:44:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` datetime(0) NOT NULL,
  `comment` varchar(2550) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 'Tom', '2019-10-04 19:37:59', 'hello', 'https://cn.bing.com/th?id=OHR.BarcolanaTrieste_ZH-CN5745744257_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp%22');
INSERT INTO `comment` VALUES (2, 'Kitty', '2019-10-14 17:27:36', 'Recently, a female weather reporter stunned the world for her young look. The public found she stay as young as twenty years ago. Nowadays, more and more women look much younger than their ages. People always want to search the secret and keep young. In my opinion, healthy diet and good mood are the best ways.\r\nSo many celebrities attach the importance of healthy diet. They show their recipes and advocate people to live the good life. Many young people like to stay up and eat fast food, because of the fast pace lifestyle. So they are easy to be sick and have the medicine, which age them mainly. The best medicine is from food according to the traditional Chinese way of treatment as every medicine has its poison.', 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg');
INSERT INTO `comment` VALUES (3, 'Tobby', '2019-10-14 19:33:22', 'hello, this is tobby', 'https://cn.bing.com/th?id=OHR.RedRocksArches_ZH-CN5664546697_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp%22');
INSERT INTO `comment` VALUES (4, 'Bob', '2019-10-16 19:34:54', '美国作家海明威是一个极具进取精神的硬汉子。他曾尝试吃过蚯蚓、蜥蜴，在墨西哥斗牛场亮过相，闯荡过非洲的原始森林，两次世界大战都上了战场。\r\n第一次世界大战时，19岁的他见一意大利士兵负伤，便冒着奥军的炮火上去抢救，结果自己也被炸伤了腿，但他仍背着伤员顽强前进。突然间，炮击停止，探照灯大亮，海明威终于回到阵地。原来是他的英勇行为感动了奥军将领，下令放他过去。\r\n作为作家的海明威，曾雄心勃勃地表示要超过莎士比亚，“干掉”屠格涅夫，把莫泊桑、斯汤达打在地上说胡话。决心下定，就得奋力拼搏。1949年，他的朋友福克纳获诺贝尔文学奖，海明威不服气，匆匆写了一部小说要超过人家，反遭失败。倔强的海明威爬起来再干，终于写出了小说《老人与海》，获1954年诺贝尔文学奖。', NULL);
INSERT INTO `comment` VALUES (5, 'Tobby', '2019-10-01 21:52:37', 'A netizen published funny things about his foreign friend. The friend decided to come back the UK, because he got tired of taking so much time on the way to the work office in China, but a few days later, he came back because he missed Chinese food. He couldn’t bear the food in his country. Then more and more people shared funny things about how their foreign friends are crazy about Chinese food. The impressive one is that a foreigner decided to take 5 years to taste all kinds of food. But when the time ended, he was still stuck in Sichuan.\r\nThe various kinds of food is the presentation of Chinese profound culture. Different areas have their features and reflect the heritage of the ancestors. We are so proud of Chinese culture and hope it won’t be forgotten.', 'https://cn.bing.com/th?id=OHR.BubbleNebula_ZH-CN2787112807_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp');
INSERT INTO `comment` VALUES (6, 'Mon', '2019-10-02 21:52:58', '辛弃疾曾写《美芹十论》献给宋孝宗。论文前三篇详细分析了北方人民对女真统治者的怨恨，以及女真统治集团内部的尖锐矛盾。后七篇就南宋方面应如何充实国力，积极准备，及时完成统一中国的事业等问题，提出了一些具体的规划。但是当时宋金议和刚确定，朝廷没有采纳他的建议。', NULL);

SET FOREIGN_KEY_CHECKS = 1;
