DROP TABLE IF EXISTS `blog` ;

CREATE TABLE `blog` (
  `blog_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(30) NOT NULL,
  `summary` VARCHAR(300) NOT NULL,
  `content` LONGTEXT NOT NULL,
  `html_content` LONGTEXT NOT NULL,
  `category_id` VARCHAR(30) DEFAULT NULL,
  `tags` VARCHAR(100) NOT NULL,
  `comment_size` INT(11) DEFAULT 0,
  `read_size` INT(11) DEFAULT 0,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后编辑时间',
  KEY `category_id_key`  (`category_id`),
  KEY `tags_id_key` (`tags`),
  PRIMARY KEY (`blog_id`)
) COMMENT '博客表';

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  #   `category_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `category_id` VARCHAR(30) NOT NULL,
  `category_name`VARCHAR(30) NOT NULL COMMENT '类目名称',
  PRIMARY KEY (`category_id`)
) COMMENT '类目表';


DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `tag_name` VARCHAR(30) NOT NULL COMMENT '标签名称',
  `tag_count` INT(11) NOT NULL,
  `category_id` VARCHAR(20) NOT NULL,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后编辑时间',
  KEY `category_id_key`  (`category_id`),
  KEY `tag_name_key` (`tag_name`),
  PRIMARY KEY (`id`)
)  COMMENT '标签表';

# DROP TABLE IF EXISTS `blog_tag`;
# CREATE TABLE `blog_tag` (
#   `bt_blog_id` BIGINT(20) NOT NULL,
#   `bt_tag_id` BIGINT(20) NOT NULL,
#   UNIQUE KEY `uqe_bt_tag_id` (`bt_tag_id`),
#   KEY `idx_bt_blog_id` (`bt_blog_id`),
#   CONSTRAINT `bt_blog_id_fk` FOREIGN KEY (bt_blog_id) REFERENCES `blog`(blog_id),
#   CONSTRAINT `bt_tag_id_fk` FOREIGN KEY (bt_tag_id) REFERENCES `tag`(tag_id)
# );


INSERT INTO `category` (`category_id`, `category_name`)
VALUES
  ('tech', '技术'),
  ('music', '音乐'),
  ('nba', 'NBA'),
  ('mood', '心情');

INSERT INTO `blog` (`blog_id`, `title`, `content`, `category_id`, `tags`, `comment_size`, `read_size`, `html_content`, `create_time`, `update_time`)
VALUES
  (1, '初步了解Docker', 'Docker 是一个开源的应用容器引擎，让开发者可以打包他们的应用以及依赖包到一个可移植的容器中，然后发布到任何流行的 Linux 机器上，也可以实现虚拟化。容器是完全使用沙箱机制，相互之间不会有任何接口。\n\n起源\nDocker 是 PaaS 提供商 dotCloud 开源的一个基于 LXC 的高级容器引擎，源代码托管在 Github 上, 基于go语言并遵从Apache2.0协议开源。\nDocker自2013年以来非常火热，无论是从 github 上的代码活跃度，还是Redhat在RHEL6.5中集成对Docker的支持, 就连 Google 的 Compute Engine 也支持 docker 在其之上运行。\n一款开源软件能否在商业上成功，很大程度上依赖三件事 - 成功的 user case(用例), 活跃的社区和一个好故事。 dotCloud 自家的 PaaS 产品建立在docker之上，长期维护且有大量的用户，社区也十分活跃，接下来我们看看docker的故事。', 'tech', 'Docker,入门', 0, 0, '', '2018-03-11 20:11:44', '2018-03-13 18:00:45'),
  (2, '什么是Java？', 'Java是一门面向对象编程语言，不仅吸收了C++语言的各种优点，还摒弃了C++里难以理解的多继承、指针等概念，因此Java语言具有功能强大和简单易用两个特征。 Java语言作为静态面向对象编程语言的代表，极好地实现了面向对象理论，允许程序员以优雅的思维方式进行复杂的编程[1] 。 Java具有简单性、面向对象、分布式、健壮性、安全性、平台独立与可移植性、多线程、动态性等特点。Java可以编写桌面应用程序、Web应用程序、分布式系统和嵌入式系统应用程序等 。', 'tech', 'Java,入门', 0, 10, '', '2018-03-11 20:11:45', '2018-03-13 17:05:46'),
  (3, '如何学习Vue.js', 'Vue (读音 /vjuː/，类似于 view) 是一套用于构建用户界面的渐进式框架。与其它大型框架不同的是，Vue 被设计为可以自底向上逐层应用。Vue 的核心库只关注视图层，不仅易于上手，还便于与第三方库或既有项目整合。另一方面，当与现代化的工具链以及各种支持类库结合使用时，Vue 也完全能够为复杂的单页应用提供驱动。\n\n如果你想在深入学习 Vue 之前对它有更多了解，我们制作了一个视频，带您了解其核心概念和一个示例工程。\n\n如果你已经是有经验的前端开发者，想知道 Vue 与其它库/框架有哪些区别，请查看对比其它框架。', 'tech', 'Vue.js,入门', 0, 1, '', '2018-03-11 20:12:48', '2018-03-13 18:00:01'),
  (4, '您已提交备案', '因目前备案提交量较大，我们将在 1个工作日内（2018-03-12 24:00 前）帮助您核查备案信息。\n审核时如发现问题，会第一时间联系网站负责人傅双波，请务必保持电话畅通。\n给您带来不便请谅解，如有特殊问题推荐使用页面右下角的“腾讯云智能客服”，快速高效解决您的备案问题。\n以上方式如没有解答您的问题，也可拨打 4009100100 咨询。\n', 'tech', '其他', 0, 0, '', '2018-03-12 18:44:45', '2018-03-12 18:44:45'),
  (5, '李荣浩是谁？', '李荣浩，1985年7月11日出生于安徽省蚌埠市，中国流行乐男歌手、音乐制作人、演员、吉他手。2013年9月16日，发行首张专辑《模特》，凭借这张专辑提名第25届金曲奖五项大奖并获得最佳新人奖，实现了从制作人到歌手的转型；2014年9月4日签约华纳唱片，发行第二张同名专辑《李荣浩》，并在次年举办8场“天生李荣浩巡回演唱会”。2016年1月22日发行第三张专辑《有理想》，同年举办“有理想世界巡回演唱会”。', 'music', '李荣浩, 百度百科', 0, 0, '', '2018-03-13 10:23:36', '2018-03-13 10:24:56'),
  (6, 'JAVA反射机制', 'JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意方法和属性；这种动态获取信息以及动态调用对象方法的功能称为java语言的反射机制。\nJAVA反射（放射）机制：“程序运行时，允许改变程序结构或变量类型，这种语言称为动态语言”。从这个观点看，Perl，Python，Ruby是动态语言，C++，Java，C#不是动态语言。但是JAVA有着一个非常突出的动态相关机制：Reflection，用在Java身上指的是我们可以于运行时加载、探知、使用编译期间完全未知的classes。换句话说，Java程序可以加载一个运行时才得知名称的class，获悉其完整构造（但不包括methods定义），并生成其对象实体、或对其fields设值、或唤起其methods。', 'tech', 'Java,反射,入门', 0, 0, '', '2018-03-13 11:13:46', '2018-03-13 17:03:58');


INSERT INTO `tag` (`id`, `tag_name`, `tag_count`, `category_id`, `create_time`, `update_time`)
VALUES
  (1, 'Java', 2, 'tech', '2018-03-11 20:07:42', '2018-03-13 14:13:01'),
  (2, 'Vue.js', 1, 'tech', '2018-03-11 20:07:48', '2018-03-13 14:13:03'),
  (3, 'Springboot', 0, 'tech', '2018-03-11 20:07:58', '2018-03-13 14:13:04'),
  (4, '数据结构', 0, 'tech', '2018-03-11 20:08:13', '2018-03-13 14:13:05'),
  (5, '设计模式', 0, 'tech', '2018-03-11 20:08:44', '2018-03-13 14:13:11'),
  (6, 'Docker', 1, 'tech', '2018-03-11 20:08:50', '2018-03-11 20:08:50'),
  (7, '算法', 0, 'tech', '2018-03-11 20:08:56', '2018-03-13 14:13:13'),
  (8, 'Nginx', 0, 'tech', '2018-03-11 20:09:02', '2018-03-13 14:13:14'),
  (9, 'Redis', 0, 'tech', '2018-03-11 20:09:08', '2018-03-13 14:13:14'),
  (10, 'Linux', 0, 'tech', '2018-03-11 20:09:14', '2018-03-13 14:13:15'),
  (11, '入门', 4, 'tech', '2018-03-11 20:15:09', '2018-03-13 17:04:09'),
  (12, 'Mysql', 0, 'tech', '2018-03-11 20:15:09', '2018-03-13 16:54:36'),
  (13, '其他', 1, 'tech', '2018-03-12 18:44:57', '2018-03-12 18:44:57'),
  (14, '反射', 1, 'tech', '2018-03-13 14:13:29', '2018-03-13 14:13:32');










