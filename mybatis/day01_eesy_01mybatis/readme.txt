##mybatis的环境搭建
    第一步：创建maven工程并导入坐标
    第二部：创建实体类和dao的接口
    第三部：创建Mybatis的主配置文件
                SqlMapConfig.xml
    第四部：创建映射配置文件
                IUserDao.xml
##环境搭建注意事项
    第一个：创建IUserDao.xml和IUserDao.java时，名称是为了和我们之前的知识保持一致
            在mybatis中它把持久层的操作接口名称和映射文件也叫做：mapper
            所以IUserDao和IUserMapper是一样的
    第二个：在idea中创建目录的时候，它和包是不一样的
            包在创建时：com.hysoft.dao它是三层结构
            目录在创建时：com.hysoft.dao它是一级结构
    第三个：mybatis的映射配置文件位置必须和dao接口的包结构相同
    第四个：映射配置文件的mapper标签namespace属性的取值必须是dao接口的全限定类名
    第五个：映射配置文件的操作配置(select)，id属性的取值必须是dao接口的方法名
    当我们遵循了第三四五点之后，我们在开发中就无须再写dao的实现类

##mybatis入门案例
    第一步：读取配置文件
    第二部：创建SqlSessionFactory工厂
    第三部：创建SqlSession
    第四部：创建Dao接口的代理对象
    第五步：执行dao中的方法
    第六步：释放资源

    注意事项：
    不要忘记在映射配置中告知mybatis要封装到哪个实体类中
    配置方式：指定实体类的全限定类名

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