package shan.yan.dao;

public class CodeMsg {
	private int code;
	private String msg;
	
	public static CodeMsg SUCCESS = new CodeMsg(0,"success");
	public static CodeMsg SERVER_ERROR = new CodeMsg(5000,"服务器异常");
	
	
	private  CodeMsg(int code, String msg) {
		this.code = code;
		this.msg = msg;
				
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/*mybatis.type-aliases-package=shan.yan.domain
			mybatis.configuration.map-underscore-to-camel-case=true
			mybatis.configuration.default-fetch-size=100
			mybatis.configuration.default-statement-timeout=3000
			mybatis.mapperLocations = classpath:shan/yan/dao.xml

			# druid

			spring.datasource.url=jdbc.mysql://47.94.83.165:3306/miaosha
			spring.datasource.username=root
			spring.datasource.password=xiangys
			spring.datasource.driver-class-name=com.mysql.jdbc.Driver
			spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
			spring.datasource.filter=stat
			spring.datasource.maxActive=2
			spring.datasource.initialSize=1
			spring.datasource.maxWait=60000
			spring.datasource.minIdle=1
			spring.datasource.timeBetweenEvictionRunsMillis=60000
			spring.datasource.minEvictableldleTimeMillis=30000
			spring.datasource.validationQuery=select 'x'
			spring.datasource.testWhileidle=true
			spring.datasource.testOnBorrow=false
			spring.datasource.testOnReturn=false
			spring.datasource.poolPreparedStatements=true
			spring.datasource.maxOpenPreparedStatements=20*/
	
}
