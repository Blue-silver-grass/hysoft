##mysql代码
    CREATE DATABASE maven CHARACTER SET utf8;
    USE maven;
    CREATE TABLE items(
    id INT(10) PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(20) NOT NULL,
    price FLOAT(10,0),
    pic   VARCHAR(40),
    createtime DATETIME,
    detail     VARCHAR(200)
    );
    INSERT INTO items VALUES(NULL,'传智播客', 1000, NULL, NULL, '带我走上人生巅峰');

## 项目：maven操作mysql数据库