DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id BIGINT(20) NOT NULL COMMENT '主键ID',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age INT(11) NULL DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (id)
);

--权限表

DROP TABLE IF EXISTS `acl_permission`;
CREATE TABLE `acl_permission`  (
                                   `id` varchar(255)   NOT NULL DEFAULT '' COMMENT '编号',
                                   `pid` varchar(255)   NOT NULL DEFAULT '' COMMENT '所属上级',
                                   `name` varchar(255)   NOT NULL DEFAULT '' COMMENT '名称',
                                   `type` int(3) NOT NULL DEFAULT 0 COMMENT '类型(1:菜单,2:按钮)',
                                   `permission_value` varchar(50)   NULL DEFAULT NULL COMMENT '权限值',
                                   `path` varchar(100)   NULL DEFAULT NULL COMMENT '访问路径',
                                   `component` varchar(100)   NULL DEFAULT NULL COMMENT '组件路径',
                                   `icon` varchar(50)   NULL DEFAULT NULL COMMENT '图标',
                                   `status` int(4) NULL DEFAULT NULL COMMENT '状态(0:禁止,1:正常)',
                                   `been_deleted` int(1)  NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
                                   `gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                   `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
                                   `remark` varchar(255)   NULL DEFAULT NULL COMMENT '备注'
);

--角色表

DROP TABLE IF EXISTS `acl_role`;
CREATE TABLE `acl_role`  (
                             `id` varchar(255)    NOT NULL DEFAULT '' COMMENT '角色id',
                             `role_name` varchar(20)    NOT NULL DEFAULT '' COMMENT '角色名称',
                             `role_code` varchar(20)    NULL DEFAULT NULL COMMENT '角色编码',
                             `remark` varchar(255)    NULL DEFAULT NULL COMMENT '备注',
                             `been_deleted` int(1)  NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
                             `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
                             `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间'
);

--角色权限表

DROP TABLE IF EXISTS `acl_role_permission`;
CREATE TABLE `acl_role_permission`  (
                                        `id` varchar(255)     NOT NULL DEFAULT '',
                                        `role_id` varchar(255)     NOT NULL DEFAULT '',
                                        `permission_id` varchar(255)     NOT NULL DEFAULT '',
                                        `been_deleted` int(1)  NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
                                        `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
                                        `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
                                        `remark` varchar(255)     NULL DEFAULT NULL COMMENT '备注'
);

--用户表

DROP TABLE IF EXISTS `acl_user`;
CREATE TABLE `acl_user`  (
                             `id` varchar(255)   NOT NULL COMMENT '会员id',
                             `username` varchar(64)   NOT NULL DEFAULT '' COMMENT '微信openid',
                             `password` varchar(64)   NOT NULL DEFAULT '' COMMENT '密码',
                             `nick_name` varchar(50)   NULL DEFAULT NULL COMMENT '昵称',
                             `been_deleted` int(1)  NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
                             `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
                             `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
                             `remark` varchar(255)   NULL DEFAULT NULL COMMENT '备注'
);
-- Table structure for acl_user_role 角色表
DROP TABLE IF EXISTS `acl_user_role`;
CREATE TABLE `acl_user_role`  (
                                  `id` varchar(255)    NOT NULL DEFAULT '' COMMENT '主键id',
                                  `role_id` varchar(255)    NOT NULL DEFAULT '0' COMMENT '角色id',
                                  `user_id` varchar(255)    NOT NULL DEFAULT '0' COMMENT '用户id',
                                  `been_deleted` int(1)   NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
                                  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
                                  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
                                  `remark` varchar(255)    NULL DEFAULT NULL COMMENT '备注'
)
