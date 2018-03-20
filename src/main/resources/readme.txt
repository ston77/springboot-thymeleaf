commit 说明：

1、搭建springboot+thymeleaf的demo
	文档url：https://docs.spring.io/spring-boot/docs/2.0.0.RELEASE/reference/htmlsingle/
	
2、字符集调整乱码
3、集成mybatis，使用druid连接池
	文档url：http://www.mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/
	
4、redis
	安装：make -j 4
		make instal
		vim redis.conf修改：
			bind 0.0.0.0 表示都可以访问
			dae... 修改为 yes 表示允许后台允许
			requierdpass 访问密码
		配置系统文件：
		cd utils 执行install
		redis-cli进入客户端
		auth 1234使用密码登陆
		keys * 查看所有key