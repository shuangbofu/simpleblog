DROP DATABASE IF EXISTS `simpleblog`;
CREATE DATABASE `simpleblog` CHARSET UTF8mb4;
use `simpleblog`;

DROP TABLE IF EXISTS `blog`;

CREATE TABLE `blog` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(30) NOT NULL COMMENT '标题',
    `summary` VARCHAR(300) NOT NULL COMMENT '摘要',
    `content` LONGTEXT NOT NULL COMMENT '内容',
    `html_content` LONGTEXT DEFAULT NULL COMMENT 'html格式内容',
    `category_id` INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '分类id',
    `tags` VARCHAR(100) NOT NULL COMMENT '标签集',
    `comment_size` INT(11) DEFAULT 0 COMMENT '评论量',
    `read_size` INT(11) DEFAULT 0 COMMENT '浏览量',
    `is_original` TINYINT(1) UNSIGNED DEFAULT 1 COMMENT '是否原创：1.是，0.否',
    `copyright_info` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '版权信息',
    `gmt_create` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `category_index` (`category_id`)
) CHARSET UTF8mb4 COMMENT '博客表';

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
	-- `name_abbr` VARCHAR(30)	NOT NULL COMMENT '分类名称缩写',
	-- `chinese_name` VARCHAR(30) NOT NULL COMMENT '分类中文名称',
	`usenum` INT(11) NOT NULL DEFAULT 0 COMMENT '使用数量',
	`name` VARCHAR(30) NOT NULL COMMENT '分类名称',
	`gmt_create` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`gmt_modified` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY (`id`),
	INDEX `name_index` (`name`)
) CHARSET UTF8mb4 COMMENT '分类表';

DROP TABLE IF EXISTS `tag`;

CREATE TABLE `tag` (
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL COMMENT '标签名称',
	`usenum` INT(11) NOT NULL COMMENT '使用数量',
	-- `category_id` BIGINT(20) NOT NULL DEFAULT 0 COMMENT '分类id',
	`gmt_create` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_name` (`name`) 
) CHARSET UTF8mb4 COMMENT '标签表';

DROP TABLE IF EXISTS `profile`;

CREATE TABLE `profile` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(5) NOT NULL COMMENT '名字',
    `avatar` VARCHAR(120) NOT NULL COMMENT '头像',
    `motto_cn` VARCHAR(80) NOT NULL,
    `motto_en` VARCHAR(80) NOT NULL, 
    `github_url` VARCHAR(100) NOT NULL COMMENT 'github地址',
    `weibo_url` VARCHAR(100) NOT NULL COMMENT '微博地址',
    `weixin_code_url` VARCHAR(100) NOT NULL COMMENT '微信我二维码图片地址',
    `email_url` VARCHAR(100) NOT NULL COMMENT '邮箱地址',
    `gmt_create` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) CHARSET UTF8mb4 COMMENT '个人表';


-- DROP TABLE IF EXISTS `blog_tag`;

-- CREATE TABLE `blog_tag` (
--     `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
-- 	`blog_id` INT UNSIGNED NOT NULL,
-- 	`tag_id` INT UNSIGNED NOT NULL,
--     `gmt_create` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
--     `gmt_modified` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
--     PRIMARY KEY (`id`)
-- ) CHARSET UTF8mb4 COMMENT '博客标签表';