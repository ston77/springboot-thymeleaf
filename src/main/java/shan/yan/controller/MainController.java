package shan.yan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shan.yan.dao.CodeMsg;
import shan.yan.dao.Result;
import shan.yan.domain.User;
import shan.yan.redis.RedisService;
import shan.yan.redis.UserKey;
import shan.yan.service.UserService;

@Controller
@RequestMapping("/xys")
public class MainController {
	@Autowired 
	UserService userService;
	
	@Autowired 
	RedisService redisService;
	
	// doc url : https://docs.spring.io/spring-boot/docs/2.0.0.RELEASE/reference/htmlsingle/
	// www.mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/
	@RequestMapping("/")
	@ResponseBody
	String home(){
		return "Hello Spring Boot";
	}
	
	@RequestMapping("/hello")
	@ResponseBody
	public Result<String> Hello(){
		return Result.success("begin work!");
	}
	@RequestMapping("/helloError")
	@ResponseBody
	public Result<String> HelloErr(){
		return Result.error(CodeMsg.SERVER_ERROR);
	}
	@RequestMapping("/thymeleaf")
	public String thymeleaf(Model model) {
		model.addAttribute("name", "靠，跑起来了，真他么神奇，amazing!");
		return "xiang";
	}
	
	@RequestMapping("/mysql")
	@ResponseBody
	public Result<User> mysql(){
		
		return Result.success(userService.getById(1));
	}
	
	@RequestMapping("/tx")
	@ResponseBody
	public Result<Boolean> tx(){
		return Result.success(userService.tx());
	}
	
	@RequestMapping("/redis/get")
	@ResponseBody
	public Result<User> redisGet(){
		User long1 = redisService.get(UserKey.getById,""+1, User.class);
		return Result.success(long1);
	}
	
	@RequestMapping("/redis/set")
	@ResponseBody
	public Result<Boolean> redisSet(){
		User user = new User();
		user.setUid("123");
		user.setUname("redis user");
		boolean rr = redisService.set(UserKey.getById, ""+1,user);
		//String set = redisService.get("key2", String.class);
		return Result.success(true);
	}
}
