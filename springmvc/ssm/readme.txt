jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/ssm?useUnicode=true&amp;characterEncoding=utf8
jdbc.username=root
jdbc.password=root

CREATE DATABASE ssm;
USE ssm;
CREATE TABLE account(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	money DOUBLE
);
SELECT * FROM account;