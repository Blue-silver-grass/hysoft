##案例
    案例需求：
        1.提供index.html页面，页面中有一个省份下拉列表
        2.当页面加载完成后，发送ajax请求，加载所有省份

       *注意：使用Redis缓存一些不经常发生变化的数据
            *数据库的数据一旦发生改变，则需要更新缓存
                *数据库的表执行增删改的操作，需要将Redis缓存删除，再次存入
                *在service对应的增删改方法中，将Redis数据删除


##mysql代码
    CREATE DATABASE day23 CHARACTER SET utf8;
    USE day23;
    CREATE TABLE province(
    id INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(20) NOT NULL
    );

    -- 插入数据
    INSERT INTO province VALUES(NULL,'北京');
    INSERT INTO province VALUES(NULL,'上海');
    INSERT INTO province VALUES(NULL,'广州');
    INSERT INTO province VALUES(NULL,'陕西');

    SELECT * FROM province;

##需求
  tomcat-8服务
  mysql数据库
  idea编译器
  Redis服务