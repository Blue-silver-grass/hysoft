##mybatis基于注解的入门案例
    把IUserDao.xml移除，在dao接口的方法上使用@Select注解，并且指定SQL语句
    同时需要在SQLMapConfig.xml中的mapper配置时，使用class属性指定dao接口的全限定类名
##明确：
    我们在实际开发中，都是越简单越好，所以都是采用不写dao实现类的方式
    不管使用xml还是注解配置。
    但是mybatis它是支持写dao实现类的

##mysql
CREATE DATABASE eesy_mybatis;
USE eesy_mybatis;
CREATE TABLE USER (
id INT(11) NOT NULL AUTO_INCREMENT,
username VARCHAR(32) NOT NULL COMMENT '用户名称',
birthday DATETIME DEFAULT NULL COMMENT '生日',
sex CHAR(1) DEFAULT NULL COMMENT '性别',
address VARCHAR(256) DEFAULT NULL COMMENT '地址',
PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET = utf8;
SELECT * FROM USER;

INSERT INTO USER (id,username,birthday,sex,address) VALUES(41,'老王','2018-02-27 17:47:08','男','北京');
INSERT INTO USER (id,username,birthday,sex,address) VALUES(42,'小二王','2018-03-17 17:47:08','女','北京金燕龙');
INSERT INTO USER (id,username,birthday,sex,address) VALUES(43,'小二王','2018-03-17 17:47:08','女','北京金燕龙');
INSERT INTO USER (id,username,birthday,sex,address) VALUES(45,'传智播客','2018-02-27 17:47:08','男','北京金燕龙');
INSERT INTO USER (id,username,birthday,sex,address) VALUES(46,'老王','2018-03-27 17:47:08','男','北京');
INSERT INTO USER (id,username,birthday,sex,address) VALUES(48,'小马宝莉','2018-03-27 17:47:08','女','北京修正');

SELECT * FROM USER
SELECT * FROM USER WHERE 1=1 AND username= '老王' AND sex = '女'

CREATE TABLE account (
id INT(11) NOT NULL COMMENT '编号',
UID INT(11) DEFAULT NULL COMMENT '用户编号',
money DOUBLE DEFAULT NULL COMMENT '金额',
PRIMARY KEY (id),
KEY FK_Reference_8 (UID),
CONSTRAINT FK_Reference_8 FOREIGN KEY (UID) REFERENCES USER (ID)
)ENGINE=INNODB DEFAULT CHARSET = utf8;
INSERT INTO account (ID,UID,money) VALUES (1,46,1000),(2,45,1000),(3,46,2000);

SELECT * FROM account;
SELECT * FROM USER;
SELECT u.*,a.id AS aid,a.uid,a.money FROM account a ,USER u WHERE a.`UID`=u.`id`;
SELECT a.id AS aid,a.uid,a.account,u.* FROM account a ,USER u WHERE a.`UID`=u.`id`;
SELECT *FROM USER u LEFT OUTER JOIN account a ON u.id=a.uid

CREATE TABLE role (id INT(11) NOT NULL COMMENT '编号',
role_name VARCHAR(30) DEFAULT NULL COMMENT '角色名称',
role_desc VARCHAR(60) DEFAULT NULL COMMENT '角色描述',
PRIMARY KEY (id)
)ENGINE=INNODB DEFAULT CHARSET = utf8;

INSERT INTO role (id,role_name,role_desc) VALUES (1,'院长','管理整个学院'),(2,'总裁','管理整个公司'),(3,'校长','管理整个学校')

CREATE TABLE user_role (
uid INT(11) NOT NULL COMMENT '用户编号',
rid INT(11) NOT NULL COMMENT '角色编号',
PRIMARY KEY (uid,rid),
KEY FK_Reference_10 (rid),
KEY FK_Reference_9 (uid),
 CONSTRAINT FK_Reference_10 FOREIGN KEY (rid) REFERENCES role (id),
 CONSTRAINT FK_Reference_9 FOREIGN KEY (uid) REFERENCES USER (id)
)ENGINE=INNODB DEFAULT CHARSET = utf8;

INSERT INTO user_role (uid,rid) VALUES(41,1),(45,1),(41,2)
SELECT * FROM USER
SELECT * FROM role
SELECT * FROM user_role


SELECT u.*,r.id AS rid,r.role_name,r.role_desc FROM role r 
LEFT OUTER JOIN user_role ur ON r.id=ur.rid
LEFT OUTER JOIN USER u ON u.id=ur.uid

SELECT u.*,r.id AS rid,r.role_name,r.role_desc FROM USER u 
LEFT OUTER JOIN user_role ur ON u.id=ur.uid
LEFT OUTER JOIN role r ON r.id=ur.rid

